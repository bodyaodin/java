package com.rest.user.services;

import com.rest.user.users.User;

import java.util.List;

public interface AppService {
    List<User> getUser();
    void putUser();
}
