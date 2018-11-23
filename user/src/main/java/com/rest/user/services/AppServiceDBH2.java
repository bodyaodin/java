package com.rest.user.services;

import com.rest.user.dao.UserDao;
import com.rest.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class AppServiceDBH2 implements AppService {

    private final UserDao userDao;

    @Autowired
    public AppServiceDBH2(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }

    @Override
    public void putUser() {

    }
}
