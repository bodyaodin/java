package com.rest.user.controllers;

import com.rest.user.services.AppService;
import com.rest.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        return "/getUsers - Get all users from DB. /addUser - Add user to DB!";
    }

    /**
     * Return all users in database
     **/
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return appService.getUser();
    }

    /**
     * Return form for entering user information
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addUser() {
        return new ModelAndView("putUser", "command", new User());
    }

    /**
     * Put user in database
     **/
    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    @ResponseBody
    public String postUser(@ModelAttribute("dispatcher") User user, ModelMap model) {
        model.addAttribute("id", user.getId());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());

        return "user";
    }


}
