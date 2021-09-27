package com.darling.eureka.consumer.service;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/9/23 11:20
 * @version:
 * @modified By:
 */
public interface TestRestTemplateService {

    /**
     * 通过restTemplate整合Hystrix发起远程调用
     * @param name
     * @return
     */
    String sayRestHi(String name);
}
