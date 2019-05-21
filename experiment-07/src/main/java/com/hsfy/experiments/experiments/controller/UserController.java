package com.hsfy.experiments.experiments.controller;

import com.hsfy.experiments.experiments.component.EncryptorComponent;
import com.hsfy.experiments.experiments.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    private Map<String, User> users = new HashMap<String, User>();
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EncryptorComponent encryptorComponent;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.put(user.getUserName(), user);
        return user;
    }
    //lambda 不太熟练
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        //获取用户密码 检查用户名是否存在
        String password = "";
        if(users.get(user.getUserName())==null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误!");
        if(users.get(user.getUserName()).getPassword().equals("")){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误!");
        }else{
            password = users.get(user.getUserName()).getPassword();
        }
        //检查密码是否正确
        if(passwordEncoder.matches(user.getPassword(), password)){
            Map<Object,String> map = new HashMap<Object,String>();
            map.put("userName", user.getUserName());
            String token = encryptorComponent.encrypt(map);
            map.clear();
            map.put("token", token);
            return map;
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名或密码错误");
        }
    }
    @GetMapping("/index")
    public String getindex(@RequestAttribute String userName) {
        return "用户姓名为"+userName;
    }

}
