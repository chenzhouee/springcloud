package com.imooc.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductMessageController {
    @RequestMapping("/getMessage")
    public String productMessage(){
        return "这是服务提供的信息";
    }
}
