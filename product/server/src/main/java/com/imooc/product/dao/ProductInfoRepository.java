package com.imooc.product.dao;

import com.imooc.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /**通过状态值查询商品
     * @param productStatus
     * @return
     * @throws Exception
     */
    List<ProductInfo> findByProductStatus(Integer productStatus) throws  Exception;

    /**通过id列表查询商品信息
     * @param productIdList
     * @return
     * @throws Exception
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList) throws Exception;




}
