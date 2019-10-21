package com.imooc.product.client;

import com.imooc.product.common.DesreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.client
 * @ClassName: ProductClient
 * @Author: chenzhou
 * @Description: 商品服务对外提供的接口
 * @Date: 2019/10/20 15:03
 * @Version: 1.0
 */
@FeignClient(name = "product")
public interface ProductClient {
    /*
     * 得到所有的商品列表（供订单服务调用）
     * */
    @RequestMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);


    /**重置库存
     * @param cartDTOList
     */
    @RequestMapping("/product/resetProductStock")
    void  resetStock(@RequestBody List<DesreaseStockInput> desreaseStockInputList);
}
