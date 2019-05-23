package com.hsfy.experiments.experiments.dao;

import com.hsfy.experiments.experiments.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeworkDao extends JpaRepository<Homework, Integer> {
    @Override
    <S extends Homework> S save(S s);

    @Override
    Optional<Homework> findById(Integer integer);
}
