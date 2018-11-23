package com.rest.user.services;

import com.rest.user.users.User;
import org.springframework.context.annotation.Primary;
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
    public List<User> getUser() {
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
    public void putUser() {

    }
}
