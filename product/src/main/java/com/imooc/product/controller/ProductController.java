package com.imooc.product.controller;

import com.imooc.product.VO.ProductInfoVO;
import com.imooc.product.VO.ProductVO;
import com.imooc.product.VO.ResultVO;
import com.imooc.product.entity.ProductCategory;
import com.imooc.product.entity.ProductInfo;
import com.imooc.product.service.ProductCategoryService;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ProductService productService;
    /*
    * 1.查询所有在架列表
    * 2.获取类目type列表
    * 3.查询类目
    * 4.构造数据
    * */
    @RequestMapping("/list")
    public ResultVO<ProductVO> list(){
        ResultVO resultVO = new ResultVO();
        List<ProductVO> ProductVOList = new ArrayList<>();
        try {
            //1.查询所有在架列表
            List<ProductInfo> ProductInfoList = productService.findUpAll();
            //2.查询类目type列表
            List<Integer> categoryTypeList = ProductInfoList.stream()
                    .map(ProductInfo::getCategoryType)
                    .collect(Collectors.toList());
            //比较笨的方式
            /*List<Integer> categoryTypeList = new ArrayList<>();
            for (ProductInfo productInfo:ProductInfoList) {
                Integer categoryType =  productInfo.getCategoryType();
                categoryTypeList.add(categoryType);
            }*/
            //3.查询类目
            List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

            //4.构造数据
            for (ProductCategory productCategory : productCategoryList) {
                ProductVO productVO = new ProductVO();
                productVO.setCategoryName(productCategory.getCategoryName());
                productVO.setCategoryType(productCategory.getCategoryType());

                List<ProductInfoVO> productInfoVOList = new ArrayList<>();
                for (ProductInfo productInfo : ProductInfoList) {
                    if(productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        productInfoVO.setProductId(productInfo.getProductId());
                        productInfoVO.setProductName(productInfo.getProductName());
                        productInfoVO.setProductPrice(productInfo.getProductPrice());
                        productInfoVO.setProductDescription(productInfo.getProductDescription());
                        productInfoVO.setProductIcon(productInfo.getProductIcon());
                        productInfoVOList.add(productInfoVO);
                    }
                }
                productVO.setProductInfoVoList(productInfoVOList);
                ProductVOList.add(productVO);
            }

            resultVO.setData(ProductVOList);
            resultVO.setCode(200);
            resultVO.setMsg("成功");

            return resultVO;
        }catch (Exception e){
            resultVO.setData(ProductVOList);
            resultVO.setCode(400);
            resultVO.setMsg("失败");
            return resultVO;
        }
    }
}
