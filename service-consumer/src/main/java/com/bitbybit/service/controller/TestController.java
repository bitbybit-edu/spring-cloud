package com.bitbybit.service.controller;

import com.bitbybit.service.client.TestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
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

    @Autowired
    RedisConnectionFactory redisConnectionFactory;



    @RequestMapping("hello")
    public String hello(Integer key) {
        String hello = testClient.hello();
        Random random = new Random();
        Integer redisKey = random.nextInt(100);
//        redisTemplate.opsForValue().set(redisKey, hello, 3, TimeUnit.MINUTES);

//        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(redisKey, key, 3, TimeUnit.DAYS);

        redisTemplate.opsForValue().set(key, key, 1, TimeUnit.DAYS);
        return redisTemplate.opsForValue().get(key).toString();
    }

    @RequestMapping("cluster-redis")
    public String clusterRedis() {
        RedisClusterConnection clusterConnection = redisConnectionFactory.getClusterConnection();

        return null;
    }

}