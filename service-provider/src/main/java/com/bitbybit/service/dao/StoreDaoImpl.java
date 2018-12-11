package com.bitbybit.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl implements StoreDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer updateStore() {
        String sql = "update store set stock = stock - 1 where id = ? ";
        Object[] objects = new Object[]{1};
        return jdbcTemplate.update(sql, objects);
    }
}
