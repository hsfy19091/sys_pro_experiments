package com.hsfy.experiments.experiments.controller;

import com.hsfy.experiments.experiments.components.EncryptorComponent;
import com.hsfy.experiments.experiments.dao.UserDao;
import com.hsfy.experiments.experiments.entity.User;
import com.hsfy.experiments.experiments.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    EncryptorComponent encryptorComponent;
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        User u = userService.login(user);
        Map<String,Object> map = new HashMap<>();
        map.put("uid", u.getId());
        map.put("aid",u.getAuthority() );
        return encryptorComponent.encrypt(map);
    }
    @GetMapping("/index")
    public String a(){
        return "@33";
    }
}
