package com.test.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.java.model.SpringDAO;

// 스프링을 통한 의존 주입
// 객체를 스프링 빈으로 만들어야함

// 스프링 빈을 만드는 방법은
// 1. XML 방식
// 	<bean class="">
// 2. 어노테이션 방식
// 	@Component를 클래스에 붙이기만 하면
//	스프링 빈이 됨
//	@Controller <- 이미 이놈 붙였던 순간부터 빈이 된거였음
//	<- 어노테이션에 들어있는 정의 중 하나가 빈으로 만들어라 라는게 있음
//	@Service
//	@Repository
//	@Component 하나만 써도 되는데 이것만 쓰니까 가독성이 너무 안좋아서
//	추가로 만든 애들이 @Controller @Service @Repository
//	따라서 다 똑같은 애들인데 기능을 부여한게 아니라 역할을 부여한 @Component임
//	컨트롤러 역할을 하는 @Component가 @Controller
//	서비스 역할을 하는 @Component가 @Service
//	DAO 역할을 하는 @Component가 @Repository

// @Component
@Service
public class SpringService {

	private SpringDAO dao;
	
	// 생성자
	@Autowired // 의존 주입 하라는 어노테이션
	public SpringService(SpringDAO dao) {
		this.dao = dao;
	}
	
	public String doSomething() {
		SpringDAO dao = new SpringDAO();
		
		String data = dao.work();
		
		return data;
	}
}
