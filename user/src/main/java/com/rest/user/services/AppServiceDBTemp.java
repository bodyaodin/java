package com.rest.user.services;

import com.rest.user.users.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Using for testing
 */
//@Primary
@Service
public class AppServiceDBTemp implements AppService {

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            User user = new User();

            user.setId(i);
            user.setUsername("user" + i);
            user.setFirstName("name" + i);
            user.setLastName("surname" + i);

            users.add(user);
        }
        return users;
    }

    @Override
    public User getUserID(long id) {
        return null;
    }

    @Override
    public String addUser(User user) {

        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public String updateUser(User newUser, long id) {
        return null;
    }
}
