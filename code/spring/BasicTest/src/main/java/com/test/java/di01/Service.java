package com.test.java.di01;

public class Service {
	
	// DI 패턴 구현 -> 의존 객체를 담을 멤버 변수를 선언한다
	private Hong hong;
	private Lee lee;
	// 서비스 외부에서부터 건네받아야함
	
	// 2. DI 패턴 구현 -> 의존 객체를 주입받는다.
	//                 -> 의존 객체를 주입받는 의존 주입 도구(주사기)를 만든다.
	// 				   (생성자 or Setter를 만들라는 말)
	
	// 생성자
	public Service(Hong hong) {
		this.hong = hong;
	}
	public Service(Lee lee) {
		this.lee = lee;
	}
	
	// Setter
//	public void setHong(Hong hong) {
//		this.hong = hong;
//	}
	
	public void doSomething() {
		// Service 객체 자신의 업무
		System.out.println("Service 객체 자신의 업무");
		
		// DI, Dependency Injection
		// 의존성 주입
		// 디자인 패턴
		// 객체가 필요로 하는 의존성(객체)을 외부에서 주입해주는 패턴
		
		// 다른 객체(Hong)가 이미 구현해놓은 일부 업무
		// Hong을 부르자
		// Hong hong = new Hong();
	
		// hong.work();
		
		lee.work();
		
		System.out.println("Service 객체 자신의 업무");
	}
}
