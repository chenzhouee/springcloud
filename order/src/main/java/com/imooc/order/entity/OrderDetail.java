package com.imooc.order.entity;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
* 订单商品实体类
* */
@Data
@Entity
public class OrderDetail {
    @Id
    private String detailId;
    /*订单编号*/
    private String orderId;
    /*产品编号*/
    private String productId;
    /*产品名称*/
    private String productName;
    /*产品价格*/
    private BigDecimal productPrice;
    /*产品数量*/
    private Integer productQuantity;
    /*产品图标*/
    private String productIcon;
    /*创建时间*/
    private Date createTime;
    /*修改时间*/
    private Date updateTime;


}
