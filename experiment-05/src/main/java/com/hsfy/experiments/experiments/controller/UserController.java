package com.hsfy.experiments.experiments.controller;

import com.hsfy.experiments.experiments.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    private List<User> list = new ArrayList<>();

    private void addUser() {
        for (int i = 0; i < 6; i++) {
            list.add(new User(i, String.valueOf("用户名" + i + 1), String.valueOf("密码" + i + 2)));
        }
    }

    @GetMapping("/getData")
    public Object getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "value");
        return map;
    }

    @GetMapping("/users")
    public List getUsers(){
        addUser();
        return list;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        addUser();
        for (User u : list) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @PostMapping("/users")
    public List addUser(@RequestBody User user){
        list.add(user);
        return list;
    }
}
