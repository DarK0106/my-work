package com.test.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entitiy.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
