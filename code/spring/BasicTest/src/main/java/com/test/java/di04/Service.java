package com.test.java.di04;

public class Service {

	private Employee employee;

	// Default Constructor
//	public Service() {
//
//	}

//	public Service(Employee employee) {
//		this.employee = employee;
//	}
	
	// Setter 생성
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void doSomething() {
		this.employee.work();
	}
}
