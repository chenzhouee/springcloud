package com.imooc.order.dao;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.entity.OrderMaster;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterRepositoryTest  extends OrderApplicationTests {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void  testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("111");
        orderMaster.setBuyerAddress("111");
        orderMaster.setBuyerName("cz");
        orderMaster.setBuyerOpenid("666");
        orderMaster.setBuyerPhone("138239823922");
        orderMaster.setOrderAmount(BigDecimal.valueOf(1.22));
        orderMaster.setOrderStatus(2);
        orderMaster.setPayStatus(1);

        orderMasterRepository.save(orderMaster);
    }


}
