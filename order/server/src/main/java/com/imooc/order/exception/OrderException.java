package com.imooc.order.exception;

import com.imooc.order.enums.ResultStatusEnum;
import org.apache.commons.lang.enums.Enum;

/*
* 自定义异常
* */
public class OrderException extends   RuntimeException{
    //错误码
    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }
    public OrderException(ResultStatusEnum resultStatusEnum){
        super(resultStatusEnum.getMessage());
        this.code = resultStatusEnum.getCode();
    }
}
