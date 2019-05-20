package com.hsfy.experiments.experiments.repository;

import com.hsfy.experiments.experiments.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByDetail(String detail);
}
