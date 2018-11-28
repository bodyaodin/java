package com.rest.user.services;

import com.rest.user.exception.UserNotFoundException;
import com.rest.user.repository.UserRepository;
import com.rest.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class AppServiceJpaRep implements AppService{

    private UserRepository repository;

    @Autowired
    public AppServiceJpaRep(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserID(long id) {
        Optional<User> user = repository.findById(id);

        if (!user.isPresent()) throw new UserNotFoundException(id);

        return user.get();
    }

    @Override
    public String addUser(User user) {
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(savedUser.getId()).toUri();

        return "User - " + user.toString() + " was added to DB! Info: " +
                ResponseEntity.created(location).build().toString();
    }

    @Override
    public void deleteUser(long id) {
        repository.deleteById(id);
    }

    @Override
    public String updateUser(User newUser, long id) {
        Optional<User> oldUser = repository.findById(id);

        if (!oldUser.isPresent()) throw new UserNotFoundException(id);

        newUser.setId(id);
        repository.save(newUser);

        return "User with id " + id + " was updated!";
    }
}
