package com.darling.eureka.consumer.controller;

import com.darling.api.model.UserInfo;
import com.darling.eureka.consumer.model.User;
import com.darling.eureka.consumer.service.UserApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 测试openFeign的远程调用
 * @author: dll
 * @date: Created in 2021/8/25 21:52
 * @version: 1.0
 * @modified By:
 */
@RestController
@RequestMapping("/consumer/test")
public class TestConsumerController {

    @Resource
    private UserApiService userApiService;

    /**
     * 调用UserApiService中自己根据接口文档编写的调用代码
     * @return
     */
    @RequestMapping("/sayHello")
    public String sayHello() {
        String res = userApiService.sayHi("hahaha");
        System.out.println("res = " + res);
        return res;
    }

    /**
     * 调用UserApiService中自己根据接口文档编写的调用代码
     * @param user
     * @return
     */
    @RequestMapping("/insert")
    public String insertInfo(User user) {
        String res = userApiService.insertInfo(user);
        System.out.println("res = " + res);
        return res;
    }

    /**
     * 调用UserApiService中由Prodiver提供的server-apis依赖包中的UserService的接口
     * @return
     */
    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo() {
        UserInfo res = userApiService.getInfo();
        System.out.println("res = " + res);
        return res;
    }

}
