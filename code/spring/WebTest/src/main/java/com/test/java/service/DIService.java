package com.test.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.java.model.DIDAO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// 중간 관리자인 서비스
// @Component 어노테이션을 붙여서 빈으로 만들어야함
// 그냥 @Component 붙여도 상관없는데 기왕에 붙이는거
// @Component에 역할까지 명시한 어노테이션을 사용
// 이건 서비스 객체니까 @Component 대신 @Service 사용
// 이건 평범한 빈이 아니라 서비스 객체라고 사람한테 표시하기 위해
// @Service를 사용, @Component랑 @Service는 사실상 똑같음
//@NoArgsConstructor // 인자값이 없는 기본 생성자를 만들어라
// 지금은 필요없음
//@AllArgsConstructor // 모든 멤버 변수를 인수로 가지는 생성자를 만들어라
// 쓰면 안됨, 멤버 변수가 늘어날 수 있는 가능성 때문에 매우 위험함

// @RequiredArgsConstructor ?
// 반드시 초기화가 필요한 멤버 변수를 인수로 가지는 생성자를 만들어라
@Service
@RequiredArgsConstructor // 요구하는 argument를 가진 컨스트럭터?
public class DIService {
	// 서비스 객체가 DAO를 의존
	// 이때 스프링에서 의존 주입하는 방법이 여러가지가 있음
	
	// 방법 1. @Autowired라는 어노테이션과 생성자 주입 도구를 활용하는 방법
	// 가장 많이 사용되고 추천되는 방법
	
	// 방법 2. @Autowired라는 어노테이션과 setter 주입 도구를 활용하는 방법
	// 생성자 주입 vs setter 주입
	// 생성자: 1회만 호출 가능
	// Setter: N회 호출 가능
	
	// 방법 3. 멤버 변수에 직접 @Autowired를 선언하는 방법
	
	// 방법 4. 생성자 주입을 하지만 @Autowired를 생략하는 방법
	
	// 방법 5. Setter를 쓰는데 여기에 Lombok을 활용함(2번과 거의 동일)
	
	// 방법 6. 생성자를 쓰는데 여기에 Lombok을 활용함(1번과 거의 동일)
	
	// 결론: 1, 6을 제일 많이 쓰고 4번은 가끔 사용
	
	// 방법 1. @Autowired라는 어노테이션과 생성자 주입 도구를 활용하는 방법
	// 멤버 변수로 승격
//	private DIDAO dao;
	
	// 생성자
//	@Autowired
//	public DIService(DIDAO dao) {
//		this.dao = dao;
//	}
	
	// 방법 2. @Autowired라는 어노테이션과 setter 주입 도구를 활용하는 방법
	// 새로운 객체를 기존의 변수에 덮어 쓰는 경우가 없기 때문에
	// = DAO 객체를 한번 만들면 바꿀 일이 없기 때문에
	// setter를 통한 의존 주입은 잘 쓰지 않는다
	// 설계 문제이자 가독성 문제 때문에 사용하지 않음
//	private DIDAO dao;
	
//	@Autowired
//	public void setDao(DIDAO dao) {
//		this.dao = dao;
//	}
	
	// 방법 3. 멤버 변수에 직접 @Autowired를 선언하는 방법
	// 의존 주입 도구(생성자, setter)가 필요 없다
	// 가장 쉬운 방법
	// 단위 테스트나 유지보수가 어려운 방식
	// 급한게 아니라면 사용하지 않음
//	@Autowired
//	private DIDAO dao;
	
	// 방법 4. 생성자 주입을 하지만 @Autowired를 생략하는 방법
	// 생성자가 딱 1개일때만 사용가능함
	// 생성자가 필요에 따라 오버로딩 되어있을 경우 에러 발생
	// 의존 주입을 하려고 의존 주입 도구를 찾는데 스프링이 뭘 써야할지 모름
	// 이때 @Autowired를 붙여서 지정해주면 스프링이 찾을 수 있음
//	private DIDAO dao;
	
//	public DIService(DIDAO dao) {
//		this.dao = dao;
//	}
	
	// 이런 식으로 생성자가 필요에 따라 오버로딩 되어있을 경우 에러 발생
//	public DIService(DIDAO dao, int num) {
//		this.dao = dao;
//	}
	
	// 방법 5. Setter를 쓰는데 여기에 Lombok을 활용함
	// Lombok한테 Setter를 대신 만들라고 시키는 것
	// 스프링 어노테이션이 아닌 Lombok의 어노테이션임
	// (onMethod_ = @Autowired)를 쓰면 Lombok이 Setter에
	// @Autowired도 붙여줌
//	@Setter(onMethod_ = @Autowired)
//	private DIDAO dao;
	
	// 방법 6. 생성자를 쓰는데 여기에 Lombok을 활용함(1번과 거의 동일)
	private final DIDAO dao;
	
	// 멤버 변수를 final로 만들고 생성자에서 초기화 할 수 있음
//	public DIService() {
//		this.dao = new DIDAO();
//	}
	
//	final int a = 10;
//	a = 20; // 10에서 못 고침
	
//	final int b;
//	b = 20; // 여기까진 됨
//	b = 30; // 여기서부터 안됨
	
	public String get() {
		
		// DAO 객체 생성
		// DIDAO dao = new DIDAO();
	
		// DAO에게 업무 위임
		String data = dao.get();
		
		return data;
	}

}
