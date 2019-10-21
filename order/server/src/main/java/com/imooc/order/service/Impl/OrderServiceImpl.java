package com.imooc.order.service.Impl;

import com.imooc.order.dao.OrderDetailRepository;
import com.imooc.order.dao.OrderMasterRepository;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.entity.OrderDetail;
import com.imooc.order.entity.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.GetUUID;
import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DesreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    ProductClient productClient;


    @Override
    public OrderDTO create(OrderDTO orderDTO) throws Exception {
        String uuid = GetUUID.getUuid();
        // 查询商品信息(调用商品服务)
        List<String > productIdList =  orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());


        List<ProductInfoOutput> productList = productClient.listForOrder(productIdList);
        //计算总价(商品单价 * 数量)
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            for (ProductInfoOutput productInfo : productList){
                if(productInfo.getProductId() .equals( orderDetail.getProductId()) ){
                    orderAmout= productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(uuid);
                    orderDetail.setDetailId(GetUUID.getUuid());

                    orderDetailRepository.save(orderDetail);//订单详情入库
                }

            }
        }
        //扣库存（调用商品服务）
        List<DesreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DesreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        productClient.resetStock(cartDTOList);//扣库存

        //订单入库（添加订单）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(uuid);
        BeanUtils.copyProperties(orderDTO,orderMaster);

        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmout);//总价

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
