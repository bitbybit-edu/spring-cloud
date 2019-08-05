package com.bitbybit.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bitbybit.dubboapi.entity.TestEntity;
import com.bitbybit.dubboapi.service.TestService;


@Service
public class TestServiceImpl implements TestService {
    @Override
    public TestEntity test() {
        TestEntity testEntity = new TestEntity();
        testEntity.setStatus(0);
        testEntity.setMessage("test");
        return testEntity;
    }
}
