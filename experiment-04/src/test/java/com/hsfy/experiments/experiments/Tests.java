package com.hsfy.experiments.experiments;

import com.hsfy.experiments.experiments.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        userService.addUser();
    }

}
