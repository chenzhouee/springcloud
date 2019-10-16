package com.imooc.order.controller;

import com.imooc.order.form.OrderForm;
import com.imooc.order.VO.ResultVO;
import com.imooc.order.convert.Form2OrderDTOConvert;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultStatusEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;
    /*
    * 参数验证
    * */
    @RequestMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确,orderFrom={}",orderForm);
            throw new OrderException(ResultStatusEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO =Form2OrderDTOConvert.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】 购物车信息为空,orderFrom={}");
            throw new OrderException(ResultStatusEnum.CART_EMPTY);
        }
        ResultVO resultVO = new ResultVO();
        try{
            OrderDTO result = orderService.create(orderDTO);
            Map<String,String> map = new HashMap<>();
            map.put("orderId",result.getOrderId());

            resultVO.setCode(200);
            resultVO.setMessage("创建成功");
            resultVO.setData(map);

            return resultVO;
        }catch (Exception e){
            resultVO.setCode(400);
            resultVO.setMessage("创建成功");
            resultVO.setData(resultVO);

            return resultVO;
        }


    }

}
