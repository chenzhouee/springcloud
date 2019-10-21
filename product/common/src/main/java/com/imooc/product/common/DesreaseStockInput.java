package com.imooc.product.common;

import lombok.Data;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.common
 * @ClassName: DesreaseStockInput
 * @Author: chenzhou
 * @Description: 买家传到后台的参数，包括商品id，和数量
 * @Date: 2019/10/20 14:36
 * @Version: 1.0
 */
@Data
public class DesreaseStockInput {
    /*
     * 商品id
     * */
    private String  productId;
    /*
     * 购买的数量
     * */
    private Integer productQuantity;


    public DesreaseStockInput(){

    }

    public DesreaseStockInput(String productId,Integer productQuantity){
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
