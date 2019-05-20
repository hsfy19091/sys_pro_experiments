package com.hsfy.experiments.experiments.repository;

import com.hsfy.experiments.experiments.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {
    @Query(value = "select u from UserAddress u where u.user.name = ?1 and u.address.detail = ?2")
    UserAddress findByUserNameAndAddressDetail(String userName,String addressDetail);
}
