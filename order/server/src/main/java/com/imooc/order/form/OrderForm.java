package com.imooc.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/*
* 前台传过来的对象
*
* */
@Data
public class OrderForm {
    /*姓名*/
    @NotEmpty(message = "姓名为空")
    private String name;
    /*电话*/
    @NotEmpty(message = "电话为空")
    private String phone;
    /*地址*/
    @NotEmpty(message = "地址为空")
    private String address;
    /*微信id*/
    @NotEmpty(message = "微信为空")
    private String openid;
    /*购物车*/
    @NotEmpty(message = "购物车为空")
    private String items;

}
