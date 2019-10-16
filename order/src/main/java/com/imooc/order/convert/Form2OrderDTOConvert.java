package com.imooc.order.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.order.form.OrderForm;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.entity.OrderDetail;
import com.imooc.order.enums.ResultStatusEnum;
import com.imooc.order.exception.OrderException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Form2OrderDTOConvert {
    /*
    * 将表单传过来的值转化为OrderDTO
    * */
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        }catch (Exception e){
            log.error("【json格式转换错误】，String={}",orderForm.getItems());
            throw new OrderException(ResultStatusEnum.JSONCONVERT_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
