package com.hsfy.experiments.experiments.dao;

import com.hsfy.experiments.experiments.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {
    @Override
    <S extends Course> S save(S s);

    @Override
    Optional<Course> findById(Integer integer);

    @Override
    List<Course> findAll();
}
