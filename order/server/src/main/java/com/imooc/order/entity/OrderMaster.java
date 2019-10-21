package com.imooc.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
* 订单实体类
* */
@Data
@Entity
public class OrderMaster {
    @Id
    private String orderId;
    /*买家名称*/
    private String buyerName;
    /*买家电话*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家微信*/
    private String buyerOpenid;
    /*订单总价*/
    private BigDecimal orderAmount;
    /*订单状态*/
    private Integer orderStatus;
    /*支付状态*/
    private Integer payStatus;
    /*创建时间*/
    private Date createTime;
    /*修改时间*/
    private  Date updateTime;

}
