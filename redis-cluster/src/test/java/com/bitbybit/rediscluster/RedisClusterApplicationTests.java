package com.bitbybit.rediscluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterApplicationTests {

    private static final Logger logger = Logger.getLogger("com.bitbybit.rediscluster.RedisClusterApplicationTests");

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        try {
            redisTemplate.opsForValue().set(6, 6);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "contextLoads", e);
        }
    }
}
