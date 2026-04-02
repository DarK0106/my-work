package com.test.java.di02;

public class Service {
	
	// 강한 결합
	// 부모클래스 <- (관계: 클래스) -> 자식클래스
	
	// 약한 결합
	// 부모클래스 <- (관계: 인터페이스) -> 자식클래스
	
	// 의존 주입
	private Employee employee;
	
	public Service(Employee employee) {
		this.employee = employee;
	}
	
	public void doSomething() {
		this.employee.work();
	}
}
