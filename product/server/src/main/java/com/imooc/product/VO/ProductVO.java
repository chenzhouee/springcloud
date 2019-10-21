package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    /*类目名称*/
    @JsonProperty("name")
    private String categoryName;
    /*类目类型*/
    @JsonProperty("type")
    private Integer categoryType;
    /*商品*/
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVoList;
}
