package com.imooc.product.service;

import com.imooc.product.common.DesreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {

    /**查询上架商品
     * @return
     * @throws Exception
     */
    List<ProductInfo> findUpAll() throws Exception;

    /**查询订单中的所有商品信息
     * @param productIdList
     * @return
     * @throws Exception
     */
    List<ProductInfoOutput> findList(List<String> productIdList) throws  Exception;

    /**删除库存
     * @param cartDTOList
     * @throws Exception
     */
    void resetStock(List<DesreaseStockInput> cartDTOList) throws  Exception;
}
