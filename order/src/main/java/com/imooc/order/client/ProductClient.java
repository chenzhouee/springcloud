package com.imooc.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 定义好调用的接口
 */
@FeignClient(name = "PRODUCT")
public interface ProductClient {
    @GetMapping("/getMessage")
    String productMessage();
}
