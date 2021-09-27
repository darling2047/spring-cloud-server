package com.darling.eureka.consumer.service.impl;

import com.darling.eureka.consumer.service.TestRestTemplateService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/9/23 11:21
 * @version:
 * @modified By:
 */
@Service
public class TestRestTemplateServiceImpl implements TestRestTemplateService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "sayRestHiCallBack")
    public String sayRestHi(String name) {
        String url = "http://EUREKA-PROVIDER//serverApis/test/sayHi?name="+name;
        String object = restTemplate.getForObject(url, String.class);
        return object;
    }

    public String sayRestHiCallBack(String name) {
        return "向"+name+"sayRestHi失败啦!";
    }
}
