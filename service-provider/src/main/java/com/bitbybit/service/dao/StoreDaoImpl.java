package com.bitbybit.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl implements StoreDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
}
