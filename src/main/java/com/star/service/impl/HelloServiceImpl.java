package com.star.service.impl;

import com.star.service.HelloService;

/**
 * @author star
 * @date 2022/6/1 9:38 PM
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello "+name;
    }
}
