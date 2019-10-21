package com.imooc.order.dao;

import com.imooc.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

}
