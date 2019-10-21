package com.imooc.product.service.impl;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.entity.ProductCategory;
import com.imooc.product.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class ProductCategoryServiceImplTest extends ProductApplicationTests {
    @Autowired
    ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() throws  Exception{
        List<ProductCategory> list =  productCategoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}
