package com.test.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
