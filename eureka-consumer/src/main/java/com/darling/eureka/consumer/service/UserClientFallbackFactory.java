package com.darling.eureka.consumer.service;

import com.darling.api.model.UserInfo;
import com.darling.eureka.consumer.model.User;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/9/22 13:06
 * @version:
 * @modified By:
 */
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserApiService> {


    @Override
    public UserApiService create(Throwable throwable) {

        return new UserApiService() {
            @Override
            public String sayHi(String name) {
                System.out.println("throwable = " + throwable);
                if (throwable instanceof HystrixTimeoutException) {
                    return "连接超时了";
                }
                return "系统异常";
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
        };
    }
}
