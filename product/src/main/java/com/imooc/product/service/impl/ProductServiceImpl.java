package com.imooc.product.service.impl;

import com.imooc.product.dao.ProductInfoRepository;
import com.imooc.product.entity.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() throws Exception {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
