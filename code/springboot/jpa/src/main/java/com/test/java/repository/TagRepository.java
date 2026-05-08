package com.test.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.Tag;

// 특정 테이블에 select 할 일이 없으면
// 그 테이블은 리포지토리 안 만들어도 됨
// 그래서 TaggingRepository 이런거 안만들어도 됨
// tblTagging 을 insert update delete 할 일 있으면
// 그땐 만들어야됨
public interface TagRepository extends JpaRepository<Tag, Long> {

}
