package com.hsfy.experiments.experiments.repository;

import com.hsfy.experiments.experiments.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int uid);
}