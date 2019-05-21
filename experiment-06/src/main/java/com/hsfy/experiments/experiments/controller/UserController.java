package com.hsfy.experiments.experiments.controller;

import com.hsfy.experiments.experiments.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@Validated
@RequestMapping("/api")
public class UserController {
    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user){
        return user;
    }
    @PostMapping("/api/users/{username}")
    public User checkUserName(@Valid @PathVariable String username){
        User user = new User(username);
        return user;
    }
}
