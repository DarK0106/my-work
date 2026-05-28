package com.test.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entitiy.User;

public interface UserRepository extends JpaRepository<User, String> {

}
