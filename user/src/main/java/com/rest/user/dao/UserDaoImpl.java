package com.rest.user.dao;

import com.rest.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String SQL_GET_USERS = "SELECT * FROM USER";
    private static final String SQL_ADD_USER = "INSERT INTO USER (FIRST_NAME, LAST_NAME, USERNAME) VALUES (?, ?, ?)";

    private final UserMapper userMapper;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(UserMapper userMapper, JdbcTemplate jdbcTemplate) {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getUsers() {
        try {
            return jdbcTemplate.query(SQL_GET_USERS, userMapper);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserID(long id) {
        return null;
    }

    @Override
    public String addUser(User user) {
        jdbcTemplate.execute(SQL_ADD_USER, new PreparedStatementCallback<Integer>() {
                    @Override
                    public Integer doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                        preparedStatement.setString(1, user.getFirstName());
                        preparedStatement.setString(2, user.getLastName());
                        preparedStatement.setString(3, user.getUsername());
                        return preparedStatement.executeUpdate();
                    }
                }
        );
        return "User - " + user.toString() + " was added to DB";
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public String updateUser(User newUser, long id) {
        return null;
    }
}
