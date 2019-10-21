package com.imooc.product.service.impl;

import com.imooc.product.common.DesreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dao.ProductInfoRepository;
import com.imooc.product.entity.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() throws Exception {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) throws Exception {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e->{
                    ProductInfoOutput productInfoOutput = new ProductInfoOutput();
                    BeanUtils.copyProperties(e,productInfoOutput);
                    return productInfoOutput;
                }).collect(Collectors.toList());
    }

    @Override
    public void resetStock(List<DesreaseStockInput> desreaseStockInputList) throws Exception {
        //1.根据商品id修改对应的库存信息
        for (DesreaseStockInput desreaseStockInput:desreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(desreaseStockInput.getProductId());
            if(!productInfoOptional.isPresent()){ //如果没查到值
                //抛出异常
                throw  new  ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo =  productInfoOptional.get();
            Integer productStock = productInfo.getProductStock();
            if(productStock < desreaseStockInput.getProductQuantity()){
                //库存不够抛出异常
                throw  new  ProductException(ResultEnum.STOCK_NOT_ENOUGH);
            }
            Integer stock = productStock-desreaseStockInput.getProductQuantity();//计算剩下来的库存
            productInfo.setProductStock(stock);

            productInfoRepository.save(productInfo); //保存数据库

        }
    }
}
