package com.rest.user.users;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;


public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String firstName;
    private String lastName;


    public User() {
    }

    public User(long id, String username, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return username + ": " + firstName + " " + lastName;
    }
}
