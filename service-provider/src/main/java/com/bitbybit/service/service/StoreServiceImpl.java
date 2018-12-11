package com.bitbybit.service.service;

import com.bitbybit.service.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreDao storeDao;

    @Override
    public Integer updateStore() {
        return storeDao.updateStore();
    }
}
