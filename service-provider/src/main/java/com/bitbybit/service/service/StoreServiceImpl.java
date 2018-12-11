package com.bitbybit.service.service;

import com.bitbybit.service.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreDao storeDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer updateStore() throws Exception {
        Integer integer = storeDao.updateStore();
        if (integer > 0) {
            throw new Exception();
        }
        return integer;
    }
}
