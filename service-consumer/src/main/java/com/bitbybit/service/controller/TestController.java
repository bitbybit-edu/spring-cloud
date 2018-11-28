package com.bitbybit.service.controller;

import com.bitbybit.service.client.TestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    @Autowired
    @Qualifier("serviceProvider")
    TestClient testClient;

    @RequestMapping("hello")
    public String hello() {
        String hello = testClient.hello();
        return hello;
    }

}