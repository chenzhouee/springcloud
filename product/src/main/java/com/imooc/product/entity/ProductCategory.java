package com.imooc.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ProductCategory {
    @Id
    private String categoryId;
    /*类目名称*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;
    /*创建时间*/
    private Date createTime;
    /*修改时间*/
    private Date updateTime;
}
