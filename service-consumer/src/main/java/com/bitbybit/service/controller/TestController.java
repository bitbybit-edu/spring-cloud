package com.bitbybit.service.controller;

import com.bitbybit.service.client.TestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    @Qualifier("service-provider")
    TestClient testClient;

    @RequestMapping("hello")
    public String hello() {
        String hello = testClient.hello();
        Random random = new Random();
        Integer redisKey = random.nextInt(100);
//        redisTemplate.opsForValue().set(redisKey, hello, 3, TimeUnit.MINUTES);
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(redisKey, hello, 3, TimeUnit.DAYS);
        return hello + aBoolean;
    }

}