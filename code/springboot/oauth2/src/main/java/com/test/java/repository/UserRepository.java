package com.test.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.User;

// DB CRUD 담당 (JpaRepository 가 메서드 자동 제공)
public interface UserRepository extends JpaRepository<User, Long>  {

	Optional<User> findByUsername(String username);
}
