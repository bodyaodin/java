package com.rest.user.controllers;

import com.rest.user.services.AppService;
import com.rest.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {

    private final AppService appService;


    @Autowired
    public RestController(AppService appService) {
        this.appService = appService;
    }

    /**
     * Get Index page
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getIndex() {
        return "/getUsers - Get all users from DB (GET). " +
                "/getUser/{id} - Get user from DB using ID (GET). " +
                "/addUser - Add user to DB (POST)! " +
                "/deleteUser/{id} - Delete user from DB using ID (DELETE). " +
                "/updateUser/{id} - Update old user in DB using ID (PUT).";
    }

    /**
     * Return all users from database
     **/
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return appService.getUsers();
    }

    /**
     * Get user from DB using ID
     **/
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserID(@PathVariable long id) {
        return appService.getUserID(id);
    }

    /**
     * Add user to database
     **/
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String postUser(@RequestBody User newUser) {
        return appService.addUser(newUser);
    }

    /**
     * Delete user from DB using ID
     **/
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable long id) {
        appService.deleteUser(id);
        return "User with id " + id + " was deleted from database!";
    }

    /**
     * Update user in DB using ID
     **/
    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User newUser, @PathVariable long id) {
        return appService.updateUser(newUser, id);
    }
}
