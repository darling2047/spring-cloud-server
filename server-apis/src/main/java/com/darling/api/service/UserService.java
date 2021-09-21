package com.darling.api.service;

import com.darling.api.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/9/15 22:02
 * @version:
 * @modified By:
 */
@RequestMapping("/serverApis")
public interface UserService {

    @GetMapping("/test")
    UserInfo test();

    /**
     * 获取用户信息
     * @return  用户姓名、年龄等信息
     */
    @GetMapping("/getInfo")
    UserInfo getInfo();

}
