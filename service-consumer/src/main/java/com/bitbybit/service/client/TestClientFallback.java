package com.bitbybit.service.client;

import org.springframework.stereotype.Component;

@Component
public class TestClientFallback implements TestClient{

    @Override
    public String hello() {
        return "fail";
    }
    
}