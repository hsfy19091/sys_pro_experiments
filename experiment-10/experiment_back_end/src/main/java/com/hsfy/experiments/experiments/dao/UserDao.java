package com.hsfy.experiments.experiments.dao;

import com.hsfy.experiments.experiments.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Override
    <S extends User> S save(S s);

    Optional<User> findById(Integer integer);

    @Override
    List<User> findAll();

    Optional<User> findByName(String name);

    Optional<User> findByNameAndPassword(String name,String password);
}
