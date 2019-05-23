package com.hsfy.experiments.experiments;

import com.hsfy.experiments.experiments.dao.CourseDao;
import com.hsfy.experiments.experiments.dao.UserDao;
import com.hsfy.experiments.experiments.entity.User;
import com.hsfy.experiments.experiments.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class experiment_10_test {

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    CourseDao courseDao;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(2);
        user.setName("hsfy");
        user.setNumber("2334");
        user.setPassword("hsfy");
        user.setAuthority(3);
        userService.addUser(user).ifPresent(u->{
            System.out.println(u.getName());
        });
    }
    @Test
    public void loginTest(){
        System.out.println(userService.findHomeworksByStudent(new User(2)).get(0).getHomework().getTitle());
    }

}
