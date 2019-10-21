package com.imooc.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.common
 * @ClassName: ProductInfoOutput
 * @Author: chenzhou
 * @Description: 产品信息对象
 * @Date: 2019/10/20 14:31
 * @Version: 1.0
 */
@Data
public class ProductInfoOutput {
    private String productId;
    /*产品名称*/
    private String productName;
    /*产品价格*/
    private BigDecimal productPrice;
    /*库存*/
    private Integer productStock;
    /*产品描述*/
    private String productDescription;
    /*产品图标*/
    private String productIcon;
    /*产品状态*/
    private Integer productStatus;
    /*类目编号*/
    private Integer categoryType;
}
