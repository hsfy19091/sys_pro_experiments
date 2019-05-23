package com.hsfy.experiments.experiments.serivce.impl;

import com.hsfy.experiments.experiments.components.EncryptorComponent;
import com.hsfy.experiments.experiments.dao.CourseDao;
import com.hsfy.experiments.experiments.dao.HomeworkDetailDao;
import com.hsfy.experiments.experiments.dao.UserDao;
import com.hsfy.experiments.experiments.entity.Course;
import com.hsfy.experiments.experiments.entity.HomeworkDetail;
import com.hsfy.experiments.experiments.entity.User;
import com.hsfy.experiments.experiments.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    EncryptorComponent encryptorComponent;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    HomeworkDetailDao homeworkDetailDao;
    @Autowired
    CourseDao courseDao;

    @Override
    public Optional<User> addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return Optional.ofNullable(userDao.save(user));
    }

    @Override
    public User login(User user) {
        User user1 = userDao.findByName(user.getName()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误")
        );
        if (passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
            return user1;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名密码错误");
        }
    }

    @Override
    public List<HomeworkDetail> findHomeworksByStudent(User user) {
        return homeworkDetailDao.findByStudent(user);
    }

    @Override
    public Course addCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAll();
    }

    @Override
    public Optional<Course> findCourseById(Integer id) {
        return courseDao.findById(id);
    }
}
