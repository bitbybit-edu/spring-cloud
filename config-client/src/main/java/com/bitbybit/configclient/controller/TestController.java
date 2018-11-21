package com.bitbybit.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestController {

    // @Value("${development.foo}")
    String name = "World";

    @RequestMapping("home")
    public String home() {
        return "Hello " + name;
    }
}