package com.bitbybit.redislock.controller;

import com.bitbybit.common.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "redis-lock")
public class RedisLockController {

    private static final Logger logger = LoggerFactory.getLogger(RedisLockController.class);

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "lock")
    public ResultData lock() {

        ResultData resultData = new ResultData();
        Long id = Thread.currentThread().getId();
        Long currentTime = System.currentTimeMillis();
        String value = id + "-" + currentTime;
        try {
            Boolean result;
            while (!(result = redisTemplate.opsForValue().setIfAbsent("liulin", value, 10, TimeUnit.SECONDS))) {
//                Thread.sleep(5000);
                logger.info(" Thread-{},is waiting", id);
            }

            Thread.sleep(1000);
            logger.info(" Thread-{},is killing", id);

            if(value.equals(redisTemplate.opsForValue().get("liulin"))) {
                redisTemplate.delete("liulin");
            }
            resultData.setData(result);
        } catch (Exception e) {
            logger.error("lock fail", e);
        }

        return resultData;
    }

}
