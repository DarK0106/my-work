package com.test.java.di02;

public class Main {
	public static void main(String[] args) {
		/*
		 * 
		 * 객체를 생성하는 순서
		 * 
		 * 이전 방식 - 객체가 필요한 그 순간 의존 객체를 생성하고 사용하는 방식 - Main 생성 > Service 생성 > Hong 생성
		 * 
		 * DI 방식 - Main 생성 > Hong 생성 > Service 생성
		 * 
		 * IoC, Inversion of Controll, 제어의 역전 - 객체 생성 순서가 거꾸로 뒤바뀐 상황
		 * 
		 * - 애플리케이션 구현 > 객체 생성(+관리+소멸) 제어 흐름을 개발자가 아닌 프레임워크가 관리하기 위해서 > IoC 필수!! > DI 구현
		 * 
		 */
		
		// Main.java
		// Main(사장) -> Service(팀장) -> Hong, Lee(팀원)
		System.out.println("Main 자신의 업무");

		// Main이 자기 업무 중의 일부를 Service에게 위임
		// Service도 자기 업무 중의 일부를 Hong에게 위임
		// Spring은 이런 관계를 별로 좋아하지 않는다?

		// 의존 관계
		// - Main은 Service를 의존한다
		// Service를 Main의 의존 객체라고 부른다
		// Spring은 의존 객체를 의존성(Dependency)라고 부른다

		// 현재의 객체 생성 순서
		// 1. Main
		// 2. Service
		// 3. Hong

		// 이제 hong을 건네주면서 서비스를 실행시켜야함
		// Service 입장에선 현재 공간은 외부 공간이다
//		Hong hong = new Hong();
		Employee employee = new Lee();

		// 메인이 서비스 불러서
		Service service = new Service(employee); // hong 넣어놓은게 의존 주입(DI)
		// 서비스한테 일시킴
		service.doSomething();
		
		System.out.println("Main 자신의 업무");
	}
}
