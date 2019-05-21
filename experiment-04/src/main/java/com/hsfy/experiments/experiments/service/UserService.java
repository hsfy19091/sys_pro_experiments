package com.hsfy.experiments.experiments.service;

import com.hsfy.experiments.experiments.aspect.MyInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserService {
    public void buyCar(){
        System.out.println("Buy a car.");
    }
    @MyInterceptor(MyInterceptor.AuthorType.ADMIN)
    public void addUser() {
        log.info("addUser()");
    }
}
