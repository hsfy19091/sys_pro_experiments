package com.hsfy.experiments.experiments.dao;

import com.hsfy.experiments.experiments.entity.CourseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseDetailDao extends JpaRepository<CourseDetail,Integer> {
    @Override
    <S extends CourseDetail> S save(S s);

    @Override
    Optional<CourseDetail> findById(Integer integer);
}
