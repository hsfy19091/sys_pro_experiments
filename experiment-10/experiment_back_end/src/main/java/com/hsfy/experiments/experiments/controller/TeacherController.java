package com.hsfy.experiments.experiments.controller;

import com.hsfy.experiments.experiments.entity.Course;
import com.hsfy.experiments.experiments.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin")
public class TeacherController {
    @Autowired
    UserService userService;
    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return userService.addCourse(course);
    }
}
