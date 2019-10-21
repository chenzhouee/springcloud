package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.exception
 * @ClassName: ProductException
 * @Author: chenzhou
 * @Description: 产品异常
 * @Date: 2019/10/18 14:54
 * @Version: 1.0
 */
public class ProductException  extends  RuntimeException{
    private Integer code;
    private String message;

    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }


    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
