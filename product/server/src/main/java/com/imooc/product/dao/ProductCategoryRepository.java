package com.imooc.product.dao;

import com.imooc.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryType) throws Exception;
}
