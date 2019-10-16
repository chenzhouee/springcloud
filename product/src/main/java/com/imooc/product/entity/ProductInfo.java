package com.imooc.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
产品实体类
 */
@Data
@Entity
public class ProductInfo {
    @Id
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
    /*创建时间*/
    private Date createTime;
    /*修改时间*/
    private Date updateTime;
}
