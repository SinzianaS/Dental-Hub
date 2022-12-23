package com.expensetracker.app.controller;

import com.expensetracker.app.model.User;
import com.expensetracker.app.repository.UserRepository;
import com.expensetracker.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository categoryRepository;
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    Collection<User> users() {
        return userService.getAllUsers();
    }

    @RequestMapping("users/{id}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long userId) {
        userService.updateUser(userId, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}

