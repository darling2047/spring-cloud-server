package com.darling.eureka.consumer.service;

import com.darling.api.service.UserService;
import com.darling.eureka.consumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description:  通过openFeign远程调用服务提供者
 * @author: dll
 * @date: Created in 2021/9/14 12:29
 * @version: 1.0
 * @modified By:
 */
@FeignClient(name = "EUREKA-PROVIDER",fallbackFactory = UserClientFallbackFactory.class)
public interface UserApiService extends UserService{

    @GetMapping("/serverApis/test/sayHi?name={name}")
    String sayHi(@PathVariable String name);

    /**
     * 测试 插入一条信息
     * @param user
     * @return
     */
    @GetMapping("/serverApis/test/insertInfo")
    String insertInfo(@RequestBody User user);

}
