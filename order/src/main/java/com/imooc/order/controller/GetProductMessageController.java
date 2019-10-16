package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GetProductMessageController {
    //@Autowired
    //LoadBalancerClient loadBalancerClient;

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    ProductClient productClient;


    @RequestMapping("/getProductMsg")
    public String  getProductMessage(){
        //1.第一种方式（直接使用RestTemplate，缺点是url写死）
        //RestTemplate restTemplate = new RestTemplate();
        //String  response = restTemplate.getForObject("http://localhost:8083/getMessage",String.class);


        //2.第二种方式（利用loadBalancerClient获取url,然后再使用RestTemplate）
        //RestTemplate restTemplate = new RestTemplate();
        //ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        //String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort());
        //String  response = restTemplate.getForObject(url+"/getMessage",String.class);


        //3.第三种方式（使用@LoadBalanced注解，可在url中使用应用名称）
        //String response = restTemplate.getForObject("http://PRODUCT/getMessage",String.class);


        String response = productClient.productMessage();

        return response;

    }
}
