package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductInfoVO {
    /*主键*/
    @JsonProperty("id")
    private String productId;
    /*产品名称*/
    @JsonProperty("name")
    private String productName;
    /*产品价格*/
    @JsonProperty("price")
    private BigDecimal productPrice;
    /*产品描述*/
    @JsonProperty("description")
    private String productDescription;
    /*产品图标*/
    @JsonProperty("icon")
    private String productIcon;
}
