package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum  PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    public Integer code;
    public String message;

    PayStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
