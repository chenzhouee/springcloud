package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum ResultStatusEnum {
    PARAM_ERROR(1,"参数错误"),
    JSONCONVERT_ERROR(2,"json格式转化错误"),
    CART_EMPTY(3,"购物车为空")
    ;

    private Integer code;
    private String message;

    ResultStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
