package com.test.java;

public class Ex19_localVariable
{
	int num; // 클래스 안에 선언되는 변수를 멤버 변수라고 한다
	public static void main(String[] args)
	{
		// Ex19_localVariable
		/*
		 * 
		 * 자바 변수의 종류
		 * - 변수가 선언된 위치나 역할에 따라서 나뉨
		 * 
		 * 1. 멤버 변수 Member Variables
		 * 
		 * 2. 지역 변수 Local Variables
		 * 	- 메서드 안에서 선언한 변수, 그냥 변수라고 불러도 되고 좀 더 정확한 이름은 지역 변수
		 * 	- 변수는 항상 자신의 영역(Scope)을 가진다 <- 변수를 사용할 수 있는 물리적인 영역
		 * 
		 * 메서드 끼리는 철저하게 영역이 분리되어 있음
		 * 지역 변수의 생명 주기, Life Cycle
		 * - 변수가 언제 태어나서(메모리에 생성이 되어서) ~ 언제 죽는지(언제 메모리에서 사라지는지(메모리 해제))
		 * - 생성: 변수 선언문이 실행되는 순간
		 * - 소멸: 변수 선언문이 포함된 자신의 영역을 제어가 벗어날 때
		 * 
		 */
		
		
		// The local variable a may not have been initialized
		// int a; <- 지역변수는 초기화 하지 않으면 사용할 수 없다
		// System.out.println(a);
		
		int a = 30; // <- 생성
		System.out.println(a);
		
		// Error: name cannot be resolved to a variable <- main에선 m1 에 있는 name 이 main은 뭔지 모름
		// System.out.println(name); <- main에서 호출도 불가
		
		m1();
		// m2();
		
		m2();
		m2(); // 20이 두번 찍히지만 두 20은 서로 다르다
		// 20 생성되고 메서드 끝나서 소멸되고 다시 생성되고 소멸됐기 때문
	} // main
	
	public static void m1()
	{	// {}: Scope, Block으로 부름
		int a = 10; // 지역 변수, m1 이라는 지역의 지역 변수 a
		System.out.println(a);
		
		String name = "홍길동";
		
		// int a = 20; <- 동일한 메서드 안에서 동일한 이름의 변수는 선언 불가
	} // <- 지역변수 a 소멸, 메서드가 끝나는 순간 지역 변수는 메모리에서 사라진다
	
	public static void m2()
	{
		int a = 20; // 이름은 같은 a 지만 사는 곳이 다름
		System.out.println(a);
	}
}
