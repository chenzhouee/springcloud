package com.imooc.order.dao;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.entity.OrderDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("123456");
        orderDetail.setDetailId("123456");
        orderDetail.setProductId("123456");
        orderDetail.setProductIcon("xxxxx");
        orderDetail.setProductName("xxxx");
        orderDetail.setProductPrice(BigDecimal.valueOf(1.2));
        orderDetail.setProductQuantity(2);

        orderDetailRepository.save(orderDetail);
    }
}
