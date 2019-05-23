package com.hsfy.experiments.experiments.controller;

import com.hsfy.experiments.experiments.entity.Course;
import com.hsfy.experiments.experiments.entity.Homework;
import com.hsfy.experiments.experiments.entity.HomeworkDetail;
import com.hsfy.experiments.experiments.entity.User;
import com.hsfy.experiments.experiments.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getHomeWorks")
    public List<HomeworkDetail> getHomeWorks( HttpServletRequest request){
        Integer id = (Integer) request.getAttribute("uid");
        User user = new User(id);
        return userService.findHomeworksByStudent(user);
//        log.info(request.getAttribute("uid").toString());
//        return null;
    }

    @GetMapping("/getCourses")
    public List<Course> getCourses(){
        return userService.findAllCourse();
    }

    @GetMapping("/getCourseByCourseId")
    public Course getCourseByCourseId(@RequestParam Integer courseId){
        return userService.findCourseById(courseId).orElse(null);
    }
}
