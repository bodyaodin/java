package com.rest.user.dao;

import com.rest.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String SQL_GET_USERS = "SELECT * FROM USER";

    private final UserMapper userMapper;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(UserMapper userMapper, JdbcTemplate jdbcTemplate) {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getUser() {
        try {
            return jdbcTemplate.query(SQL_GET_USERS, userMapper);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
