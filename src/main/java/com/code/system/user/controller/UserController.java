package com.code.system.user.controller;

import com.code.system.user.model.User;
import com.code.system.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping()
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }


}
