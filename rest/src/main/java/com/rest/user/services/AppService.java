package com.rest.user.services;

import com.rest.user.users.User;

import java.util.List;

public interface AppService {
    List<User> getUsers();
    User getUserID(long id);
    String addUser(User user);
    void deleteUser(long id);
    String updateUser(User newUser, long id);

}
