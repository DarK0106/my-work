package com.test.java.collection;

public class Ex62_Anonymous
{
	public static void main(String[] args)
	{
		// Ex62_Anonymous.java
		/*
		 * 익명 클래스, Anonymous Class
		 * - 익명 객체, Anonymous Object
		 * - 이름 없는 클래스
		 * 
		 * BBB 클래스는 이름이 있기 때문에 실명 클래스라고 하자
		 * - 객체를 여러개 만들 때 사용
		 * - 이 클래스는 영구적으로 지속된다 <- 클래스를 계속 관리해야한다
		 * 
		 * 익명 클래스
		 * - 객체를 딱 1개만 만들 때 사용
		 * - 익명 클래스는 구현과 동시에 객체를 만든다
		 * - 익명 클래스는 내 인생에 붕어빵을 딱 1개만 먹고 싶을 때 사용하는 붕어빵틀
		 * - 관리가 필요없다 <- 이게 중요
		 * 
		 * 요구사항) 인터페이스를 구현하는 클래스를 선언하기 -> 객체를 생성 -> 사용
		 * 
		 * BBB b1 = new BBB();
		 * b1.test();
		 * 
		 * 
		 * 
		 */
		
		// 1. 본인 타입의 참조 변수를 만들기
		BBB b1 = new BBB();
		b1.test();
		
		// 2. 부모 타입의 참조 변수를 만들기
		AAA b2 = new BBB();
		b2.test();
		
		// 
//		AAA b3 = new AAA();
		
		// The type new AAA(){} must implement the inherited abstract method AAA.test()
		AAA b3 = new AAA() // 이게 이름없는 클래스이다 ? new AAA()는 있어도 신경쓰지말라?
		// 머리통(헤더)은 없고 몸통(바디)만 있는 클래스?
		{

			@Override
			public void test()
			{
				System.out.println("익명 객체의 메서드");
			}
			
		}; // <- 이게 BBB b1 = new BBB(); b1.test(); 랑 똑같은 역할을한다?
		b3.test();
		
		AAA b4 = new BBB();
		b4.test();
		
		AAA b5 = new BBB();
		b5.test();
		
		AAA b6 = new BBB();
		b6.test();
		
//===========================================================
		
		// b7 이랑 b8이랑 하는일이 똑같냐고 물어본다면 아니다
		// 익명클래스는 설계도를 한번쓰자마자 버린다
		// HashMap과 비슷하다?
		AAA b7 = new AAA()
		{
			@Override
			public void test()
			{
				System.out.println("익명 객체 구현");
			}
		};
		b7.test();
		
		AAA b8 = new AAA()
		{
			@Override
			public void test()
			{
				System.out.println("익명 객체를 구현");
			}
		};
		b8.test();
		
		AAA b9 = new AAA()
		{
			@Override
			public void test()
			{
				System.out.println("익명객체구현");
			}
		};
		b9.test();
		
		
		
		
	} // main
	
}

interface AAA
{
	void test();
}

// The type BBB must implement the inherited abstract method AAA.test() 
// <- 인터페이스를 클래스가 상속받으면 반드시 인터페이스가 물려준 추상메서드를 오버라이드 해야한다
// 붕어빵틀로 붕어빵을 여러개 만들어내려고 클래스를 만드는건데
// 일반적인 클래스
class BBB implements AAA
{

	// 본인만의 멤버 구현했다고 가정
	
	@Override
	public void test()
	{
		System.out.println("추상 메서드를 구현");
	}
	
}