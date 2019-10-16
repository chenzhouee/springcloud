package com.imooc.product.service.impl;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.entity.ProductInfo;
import com.imooc.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductServiceImplTest extends ProductApplicationTests {
    @Autowired
    ProductService productService;

    @Test
    public void findUpAll() throws Exception{
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }
}
