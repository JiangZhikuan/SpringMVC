package com.mxixm.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String getName(int id) {
        return jdbcTemplate.queryForObject("select name from user where id = ?", String.class, id);
    }

}
