package com.imooc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.controller
 * @ClassName: ConfigController
 * @Author: chenzhou
 * @Description: 测试是否将配置文件拉取下来
 * @Date: 2019/10/30 14:55
 * @Version: 1.0
 */
@RestController
@RequestMapping("/env")
public class ConfigController {
    @Value("${env}")
    private String env;

    @GetMapping("/print")
    public  String  print(){
        return env;
    }

}
