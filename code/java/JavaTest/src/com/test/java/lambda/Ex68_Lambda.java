package com.test.java.lambda;

public class Ex68_Lambda
{
	public static void main(String[] args)
	{
		// Ex68_Lambda.java
		/*
		 * 람다식, Lambda Expression( 람다 표현식 )
		 * - 자바의 메서드를 함수형 프로그래밍 방식으로 표현하는 역할
		 * - 메서드를 짧고 알아보기 쉽게 작성할 수 있다
		 * 
		 * 람다식을 사용할 수 있는 조건
		 * 1. 익명 객체를 생성하는 경우
		 * 2. 이때 사용하는 인터페이스가 반드시 추상메서드를 딱 한개만 갖고 있어야 한다
		 * 
		 * 람다식 형식
		 * - 인터페이스 변수 = 람다식;
		 * ex) MyInterface m1 = () -> {};
		 * 
		 * () -> {}
		 * 익명 클래스의 추상 메서드를 구현한 것
		 * 
		 * (매개변수) -> {구현부}
		 * 
		 * a. (매개변수): 추상 메서드의 매개변수
		 * b. -> : 큰 의미 없다. 연결해주는 역할, 화살표(Arrow)라고 읽음
		 * c. {구현부}: 추상 메서드를 구현한 오버라이드한 메서드의 구현부
		 * 
		 * 
		 */
		
		// 요구사항) MyInterface가 하나 있는데, 이 인터페이스를 구현한 객체를 만들어라
		// Ex62와 비슷
		// 1. MyInterface 선언
		// 2. MyInterface를 상속받는 MyClass 선언
		// 3. 객체 생성
		
		// Case 1.
		// 인터페이스 선언 + 클래스 선언 + 객체 생성
//		MyClass m1 = new MyClass(); // 껍데기를 MyClass로 해도 되고
		MyInterface m1 = new MyClass(); // 껍데기를 부모인 MyInterface로 해도 된다
		m1.test();
		
		// Case 2.
		// 인터페이스는 선언을 했으나 클래스를 따로 안 만들었다
		// 인터페이스 선언 + 익명 클래스 + 익명 객체
		// 반드시 참조변수는 인터페이스로 했어야했음
		MyInterface m2 = new MyInterface()
		{
			@Override
			public void test()
			{
				System.out.println("익명 객체에서 구현한 메서드");
			}

//			@Override
//			public void aaa()
//			{
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void bbb()
//			{
//				// TODO Auto-generated method stub
//				
//			}
		};
		m2.test();
		
		// Case 3.
		// 인터페이스는 이미 만들어놨다
		// 클래스를 직접 만들거냐 아니면 익명으로 만들거냐 이게 주제
		// 람다식이란것도 일단 인터페이스는 있어야함
		// 통상적으로는 익명 함수라고 부름
//		MyInterface m3 = () -> {}; // () 가 Case2 에서의 test() 의 () 이고 {} 는 테스트 뒤에 오는 {} 이다
		MyInterface m3 = () -> // 이름이 없는 형식으로 메서드를 만들기 때문에 test인지 aaa인지 bbb인지 모름
		{
			System.out.println("람다식으로 구현한 객체의 메서드");
		};
		m3.test();
		
	} // main
}

@FunctionalInterface // 추상 메서드가 딱 1개 있어요 -> 람다식을 쓸 수 있어요
interface MyInterface
{
	void test();
//	void aaa();
//	void bbb();
}

class MyClass implements MyInterface
{
	@Override
	public void test()
	{
		System.out.println("실명 객체에서 구현한 메서드"); // 추상메서드는 반드시 구현, 알맹이는 내 마음대로
	}

//	@Override
//	public void aaa()
//	{
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void bbb()
//	{
//		// TODO Auto-generated method stub
//		
//	}
}