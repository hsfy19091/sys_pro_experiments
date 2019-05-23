package com.hsfy.experiments.experiments.serivce;

import com.hsfy.experiments.experiments.entity.Course;
import com.hsfy.experiments.experiments.entity.HomeworkDetail;
import com.hsfy.experiments.experiments.entity.User;

import java.util.List;
import java.util.Optional;
public interface UserService {
    Optional<User> addUser(User user);
    User login(User user);
    List<HomeworkDetail> findHomeworksByStudent(User user);
    Course addCourse(Course course);
    List<Course> findAllCourse();
    Optional<Course> findCourseById(Integer id);
}
