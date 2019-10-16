package com.imooc.product.service.impl;

import com.imooc.product.dao.ProductCategoryRepository;
import com.imooc.product.entity.ProductCategory;
import com.imooc.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryType) throws Exception {
        return productCategoryRepository.findByCategoryTypeIn(CategoryType);
    }
}
