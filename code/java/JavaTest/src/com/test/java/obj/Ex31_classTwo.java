package com.test.java.obj;

public class Ex31_classTwo
{
	public static void main(String[] args)
	{
		// Ex31_classTwo.java
		/*
		 * 
		 * 클래스 선언할 때 권장 사항
		 * - 클래스 1개 당 파일을 1개 만든다
		 * - 클래스 찾는게 매우 쉬움 
		 * - Package Explorer에 바로 보이기 때문
		 * 
		 * 클래스 선언할 때 필수 사항
		 * - 파일의 이름과 클래스의 이름은 반드시 동일해야 한다. -> 다르면 컴파일 에러 발생
		 * - 하나의 파일에 2개 이상의 클래스를 만들 수 밖에 없는 상황이 생겼다
		 * 	- 파일 내에 모든 클래스들 중 public 이라는 키워드를 가지는 클래스는 유일하다.
		 * 	- public 클래스가 파일을 대표하는 클래스이다 -> public 클래스(대표 클래스)의 이름이 파일명이 된다
		 */
		
		User Hong = new User();
		Hong.name = "홍길동";
		Hong.id = "hong";
		
		Member test = new Member();
		test.email = "testEmail";
		test.id = "testId";
		test.name = "testKim";
		
	} // Main
}

class User
{
	public String name;
	public String id;
}
