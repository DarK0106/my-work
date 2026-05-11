package com.test.java.repository;

import static com.test.java.entity.QUser.user;
import static com.test.java.entity.QUserInfo.userInfo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.java.entity.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserQueryDSLRepository {
	
	// Query DSL 쿼리를 만들고 실행하는 출발점인 factory
	// 없으면 Query DSL 자체를 쓸 수 없음
	private final JPAQueryFactory factory;

	public User m40() {
		
		/*
		 	조인
		 	- join()			: inner join
		 	- innerJoin()		: inner join
		 	- leftJoin()		: left outer join
		 	- rightJoin()		: right outer join
		*/
		
		return factory
					.selectFrom(user)
					// .join(부모 엔티티(user)의 멤버(userInfo)와, 자식 엔티티(userInfo))
					.join(user.userInfo, userInfo) // on 부모.멤버 = 자식
					.where(user.id.eq("hong"))
					.fetchOne()
					;
	}

	public List<User> m41() {
		
		return factory
				.selectFrom(user)
//				.join(user.userInfo, userInfo)
//				.innerJoin(user.userInfo, userInfo)
//				.rightJoin(user.userInfo, userInfo)
				.leftJoin(user.userInfo, userInfo)
				.fetch()
				;
	}
	
}
