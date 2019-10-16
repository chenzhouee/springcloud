package com.imooc.order.dto;

import com.imooc.order.entity.OrderDetail;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {

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

    private List<OrderDetail> OrderDetailList;
}
