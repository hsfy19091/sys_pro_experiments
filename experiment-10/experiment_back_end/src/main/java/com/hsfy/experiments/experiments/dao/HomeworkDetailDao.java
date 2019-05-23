package com.hsfy.experiments.experiments.dao;

import com.hsfy.experiments.experiments.entity.HomeworkDetail;
import com.hsfy.experiments.experiments.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HomeworkDetailDao extends JpaRepository<HomeworkDetail,Integer> {
    @Override
    <S extends HomeworkDetail> S save(S s);

    @Override
    Optional<HomeworkDetail> findById(Integer integer);

    List<HomeworkDetail> findByStudent(User student);
}
