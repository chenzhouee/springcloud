package com.imooc.order.service.Impl;

import com.imooc.order.dao.OrderDetailRepository;
import com.imooc.order.dao.OrderMasterRepository;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.entity.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.GetUUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) throws Exception {
        //TODO 查询商品信息(调用商品服务)

        //TODO 计算总价(商品单价 * 数量)

        //TODO 扣库存（调用商品服务）

        //TODO 订单入库（添加订单）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(GetUUID.getUuid());
        BeanUtils.copyProperties(orderDTO,orderMaster);

        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(new BigDecimal(5));

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
