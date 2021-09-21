package com.darling.eureka.provider.service;

import com.darling.api.model.UserInfo;
import com.darling.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/9/18 11:42
 * @version:
 * @modified By:
 */
@RestController
@Slf4j
public class TestUserApiService implements UserService {

    @Value("${server.port}")
    public String serverPort;

    @Override
    public UserInfo test() {
        return null;
    }

    @Override
    public UserInfo getInfo() {
        log.info("请求的端口为：{}",serverPort);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserInfo user = new UserInfo();
        user.setServerPort(serverPort);
        user.setAddress("杭州市西湖区三墩镇");
        user.setUserName("董琳琳");
        user.setAge(21);
        return user;
    }

}
