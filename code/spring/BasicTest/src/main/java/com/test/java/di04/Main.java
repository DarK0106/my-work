package com.test.java.di04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Main -> Service -> Hong, Lee
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/java/di04/di04.xml");
		
		// Employee employee = (Employee)context.getBean("hong");
		
//		Service service = new Service(employee);
//		service.doSomething();
		
		// new Service()로 실행됨, 우리가 만든 Service는 ()안에
		// employee를 넣어야만 실행됨
		Service service = (Service)context.getBean("service");
		service.doSomething();
	}
}
