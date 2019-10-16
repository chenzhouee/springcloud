package com.imooc.product.service;

import com.imooc.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll() throws Exception;
}
