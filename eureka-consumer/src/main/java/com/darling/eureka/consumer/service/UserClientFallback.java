package com.darling.eureka.consumer.service;

import com.darling.api.model.UserInfo;
import com.darling.eureka.consumer.model.User;
import org.springframework.stereotype.Component;

/**
 * @description: 基于htstrix封装的处理feign调用出错的熔断策略
 * @author: dll
 * @date: Created in 2021/9/22 12:08
 * @version:
 * @modified By:
 */
@Component
public class UserClientFallback implements UserApiService {

    @Override
    public String sayHi(String name) {
        return "我被降级了。。。";
    }

    @Override
    public String insertInfo(User user) {
        return null;
    }

    @Override
    public UserInfo test() {
        return null;
    }

    @Override
    public UserInfo getInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setServerPort("我被降级啦");
        return userInfo;
    }
}
