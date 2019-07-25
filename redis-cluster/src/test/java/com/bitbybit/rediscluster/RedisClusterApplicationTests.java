package com.bitbybit.rediscluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterApplicationTests {

    private static final Logger logger = Logger.getLogger("com.bitbybit.rediscluster.RedisClusterApplicationTests");

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    CustomProperties customProperties;

    @Test
    public void contextLoads() {
        try {
            redisTemplate.opsForValue().set(6, 6);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "contextLoads", e);
        }
    }

    @Test
    public void pipeline() {
        try {
            PipelineCallBack pipelineCallBack = new PipelineCallBack();
            redisTemplate.executePipelined(pipelineCallBack);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "pipelining", e);
        }
    }

    /**
     * 集群模式不支持multi
     */
    @Test
    public void multi() {
        try {
            redisTemplate.multi();
            MultiCallBack multiCallBack = new MultiCallBack();
            redisTemplate.execute(multiCallBack);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "multi", e);
        }
    }

    @Test
    public void nodes () {
        try {
            List<String> nodes = customProperties.getNodes();

            logger.log(Level.SEVERE,"", nodes);
        }catch (Exception e) {
            
        }
    }
}

class PipelineCallBack implements RedisCallback {

    @Override
    public Object doInRedis(RedisConnection connection) throws DataAccessException {
        connection.openPipeline();
        connection.set("1".getBytes(), "1a".getBytes());
        connection.set("2".getBytes(), "2a".getBytes());
        connection.set("3".getBytes(), "3a".getBytes());
        connection.set("4".getBytes(), "4a".getBytes());
        connection.set("5".getBytes(), "5a".getBytes());
        connection.set("6".getBytes(), "6a".getBytes());
        connection.closePipeline();
        return null;
    }
}

class MultiCallBack implements SessionCallback {

    @Override
    public Object execute(RedisOperations operations) throws DataAccessException {
        operations.opsForValue().set("1".getBytes(), "1".getBytes());
        operations.opsForValue().set("2".getBytes(), "2".getBytes());
        operations.opsForValue().set("3".getBytes(), "3".getBytes());
        operations.opsForValue().set("4".getBytes(), "4".getBytes());
        operations.opsForValue().set("5".getBytes(), "5".getBytes());
        operations.opsForValue().set("6".getBytes(), "6".getBytes());
        return null;
    }
}

@ConfigurationProperties(prefix="spring.custom")
@Component
class CustomProperties {

    private List<String> nodes;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
