package com.imooc.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*
* 注解@LoadBalanced的使用，可以直接使用应用名代替ip
* */
@Component
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate  restTemplate(){
        return new RestTemplate();
    }
}
