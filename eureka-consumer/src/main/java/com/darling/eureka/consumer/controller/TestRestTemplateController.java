package com.darling.eureka.consumer.controller;

import com.darling.eureka.consumer.service.TestRestTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 测试restTemplate的远程调用
 * @author: dll
 * @date: Created in 2021/9/23 11:19
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("/consumer/rest")
public class TestRestTemplateController {

    @Resource
    private TestRestTemplateService restTemplateService;

    /**
     * 通过restTemplate整合Hystrix发起远程调用
     * @param name
     * @return
     */
    @RequestMapping("/sayRestHi")
    public String sayRestHi (String name) {
        String res = restTemplateService.sayRestHi(name);
        System.out.println("res = " + res);
        return res;
    }

}
