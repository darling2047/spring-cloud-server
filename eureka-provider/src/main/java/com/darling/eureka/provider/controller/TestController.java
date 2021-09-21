package com.darling.eureka.provider.controller;

import com.darling.eureka.provider.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/8/25 21:27
 * @version: 1.0
 * @modified By:
 */
@RestController
@RequestMapping("/serverApis/test")
public class TestController {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/sayHi")
    public String sayHi(String name) {
        return serverPort + ":" + name + "：Hello!";
    }

    @GetMapping("/insertInfo")
    public String insertInfo(@RequestBody User user) {
        return serverPort + ":" + user.toString();
    }

}
