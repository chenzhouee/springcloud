package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消");

    public Integer code;
    public String message;

    OrderStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
