package com.test.java.obj.inheritance.cast;

public class Ex47_Casting
{
	public static void main(String[] args)
	{
		// Ex47_Casting.java
		/*
		 * 형변환, Type Casting
		 * *값형과 참조형간에는 형변환 절대(********) 불가능*
		 * 
		 * 
		 * 1. 예전에 했던 값형끼리의 형변환
		 * 	- 숫자끼리만 형변환 가능(boolean은 안됨)
		 * 	- byte, short, int, long, float, double, char
		 * 	- (): 형변환 연산자를 사용해서 형변환
		 * 	- 문제가 발생하는 경우? -> 큰 자료형에서 작은 자료형으로 형변환할때 발생하는 오버플로우
		 * 
		 * 2. 오늘 할건 참조형끼리의 형변환
		 * 	- 클래스끼리 형변환
		 * 
		 * *참조형 형변환은 상속 관계에 있는 클래스끼리만 가능하다*
		 *  - 직계만 가능, 방계는 불가능
		 *  
		 *  1. 방향에 따라 두가지로 분류됨
		 *  
		 *  1. 업캐스팅 Up Casting
		 *   - 암시적인 형변환
		 *   - 자식 클래스 타입을 부모 클래스 타입으로 형변환
		 *   
		 *  2. 다운캐스팅 Down Casting
		 *   - 명시적인 형변환 <- 우리가 직접 적어야하는 형변환
		 *   - 부모 클래스를 자식 클래스로 형변환
		 */
		
		short s1 = 10; // 원본
		int n1;
		
		n1 = s1;
		
		// 형변환이 성공했는지? -> 복사본 출력
		System.out.println(n1);
		
		Parent p1;
		Child c1;
		
		c1 = new Child(); // 원본 역할
		
		// 참조형 변수끼리의 복사 = 주소값 복사
		
		
		// Parent = Child
		// 자식을 부모 타입으로 바꾼다
		// 업캐스팅 -> 100% 안전 -> 안전하다는 의미가 뭘까 ?
		p1 = c1;
		// p1 = (Parent)c1;
		
		// p1이 문제가 없는지 검증? -> p1 을 가지고 할 수 있는 모든 행동을 해본다
		p1.a = 10;
		p1.b = 20;
		
		System.out.println(p1.a);
		System.out.println(p1.b);
		
		
		Parent p2;
		Child c2;
		
		p2 =new Parent(); // 원본
		
		// Child = Parent
		// 자식 = 부모
		// 다운 캐스팅 -> 불완전함 -> 명시적으로 형변환
		// 진정한 의미의 다운캐스팅은 불가능하다
		// 100%로는 불가능하다는 뜻
		// 복사 자체는 문제가 없지만 자식이 가진 c와 d를 부모가 쓰지 못하기 때문에 불가능하다.
		
//		c2 = (Child)p2;
//		
//		// 검증 -> c2를 써먹었을 때 문제가 없을까?
//		c2.a = 10;
//		c2.b = 20;
//		c2.c = 30;
//		c2.d = 40; // <- 런타임 오류, 클래스 형변환 오류, 부모 타입을 자식으로 바꿀 수 없습니다
		
		// 실제 다운 캐스팅
		Parent p3;
		Child c3;
		
		c3 = new Child();
		p3 = c3; // 형변환
		
		Child c4;
		
		c4 = (Child)p3; // 부모를 자식으로 완전히 바꾼게 아니고 
		// 원래 child 객체를 원래 child 변수로 바꾼 것 뿐인 눈속임과 같은 다운캐스팅이다
		// 껍데기는 부모지만 알맹이는 자식
		
		c4.a = 10;
		c4.b = 20;
		c4.c = 30;
		c4.d = 40;
		
		A aa1;
		C cc1;
		
		cc1 = new C(); // 원본(숫자)
		
		aa1 = cc1;
		
		aa1.a = 10;
		
		B bb1;
		D dd1;
		
		dd1 = new D();
		// bb1 = (B)dd1; // Cannot cast from D to B 방계는 형변환 불가
		
	}
}

class Parent
{
	public int a;
	public int b;
}

class Child extends Parent
{
	public int c;
	public int d;
	
}

class A
{
	public int a;
}

class B extends A
{
	public int b;
}

class D extends A // A의 자식, B와 D는 형제
{
	public int d;
}

class C extends B
{
	public int c;
}