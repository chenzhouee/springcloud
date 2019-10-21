package com.imooc.product.enums;

import lombok.Getter;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.enums
 * @ClassName: ResultEnum
 * @Author: chenzhou
 * @Description: 商品异常状态
 * @Date: 2019/10/18 14:57
 * @Version: 1.0
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    STOCK_NOT_ENOUGH(2,"商品库存不够");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
