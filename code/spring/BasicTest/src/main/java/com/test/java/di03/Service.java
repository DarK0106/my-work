package com.test.java.di03;

public class Service {
	
	private Employee employee;
	
	public Service(Employee employee) {
		this.employee = employee;
	}
	
	public void doSomething() {
		this.employee.work();
	}
}
