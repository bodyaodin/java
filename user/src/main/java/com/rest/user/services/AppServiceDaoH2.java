package com.rest.user.services;

import com.rest.user.dao.UserDao;
import com.rest.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Service
public class AppServiceDaoH2 implements AppService {

    private final UserDao userDao;

    @Autowired
    public AppServiceDaoH2(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserID(long id) {
        return null;
    }

    @Override
    public String addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public String updateUser(User newUser, long id) {
        return null;
    }
}
