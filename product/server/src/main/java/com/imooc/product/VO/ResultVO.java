package com.imooc.product.VO;

import lombok.Data;

/*
* 返回结果
* */
@Data
public class ResultVO<T> {
    /*状态码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*数据*/
    private T data;
}
