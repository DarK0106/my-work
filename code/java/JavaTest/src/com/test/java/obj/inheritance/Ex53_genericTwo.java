package com.test.java.obj.inheritance;

public class Ex53_genericTwo
{
	public static void main(String[] args)
	{
		// Ex53_genericTwo
		// m1();
		// m2();
		m3();
	} // main

	private static void m3()
	{
		// Item item1 = new Item(); <- 타입변수라는걸 무시하고 만든것
		// item1.c = 10; // c가 Object 라고 나온다
		
		Item<String> item2 = new Item<String>();
		// 객체를 생성할때 정확한 타입을 정해준다
		Item<Integer> item3 = new Item<Integer>();
		item3.c = 100; // c가 int로 바뀜
		
		Pen<String> p1 = new Pen<String>();
		p1.a = "문자열";
		p1.b = "문자열";
		p1.c = "문자열";
		
		Pen<Boolean> p2 = new Pen<Boolean>();
		p2.a = true;
		p2.a = true;
		p2.a = true;
		
		Desk<String> d1 = new Desk<String>();
		d1.setData("문자열");
		System.out.println(d1.getData());
		
		Laptop<String, Integer> l1 = new Laptop<String, Integer>("문자열", 10);
		System.out.println(l1.getA());
		System.out.println(l1.getB());
		
	}

	private static void m2()
	{
		// 값형 데이터
		int n1 = 10;
		
		// Object 클래스에 참조형 데이터를 넣을 때
		Object o1 = new Object();
		Object o2 = new LG100();
		
		// Object 클래스에 값형 데이터를 넣을 때 <- 이상한 상황
		// 클래스인 Object에 데이터를 넣을 수 없다고 생각했는데
		// Boxing 발생
		Object o3 = 10; // 중간에 개입해서 Integer.valueOf(10) = new Integer(10) <- 클래스 객체를 만듦
		// int를 Integer 클래스 객체로 만들었음
		// o3에는 10이 있는 Integer 객체의 주소값이 들어가있다
		// Integer 는 클래스임에도 불구하고 산술연산이 가능하다 ?
		Object o4 = true; // Boolean.valueOf(true)
		
		System.out.println(n1 * 2);
		// 주소값은 연산의 대상이 될 수 없다
		System.out.println((Integer)o3 *3);
		System.out.println((int)o3 *3); // <- 이렇게 써도 됨, Integer 클래스를 실제 값 타입인 int로 형변환하면 java에선 박스 안에 있던 10을 꺼냄
		// 언박싱(Unboxing) 이 발생한다고 표현
		// 넣을 때 박싱, 뺄 때 언박싱 <- 프로그램이 느려짐
		
	}

	private static void m1()
	{
		int a = 10;
		Integer b = new Integer(20); // deprecated <- 오래되서 사라질 문법이라는 뜻, 하위호환성
		Integer c = Integer.valueOf(30);
		Integer d = 40;
		
		System.out.println(a*2);
		System.out.println(b*2);
		System.out.println(c*2);
		System.out.println(d*2);
	}

}

// 제네릭 클래스
// <> : 인자 리스트, 메서드의 test(int a) 와 역할이 같다
// T : 매개변수, 변수는 반드시 앞에 자료형이 와야하지만 T는 타입변수이기 때문에
// 맘대로 써도 되지만, 보통 알파벳 1~2글자, 대문자로 씀
// 타입변수는 변수에 값을 저장하지 않고 자료형 그 자체를 저장한다
// 자료형 중에서도 참조형만 가능하다(값형은 못 넣음)
// String 타입을 T 라는 타입변수에 대입
// LG100 타입을 T 라는 타입변수에 대입
// HP200 타입을 T 라는 타입변수에 대입
// Integer 클래스를 T 라는 타입변수에 대입
// Boolean 클래스 T 라는 타입변수에 대입

class Item<T>
{
	public int a;
	public String b;
	public T c;
	
	public void ccc()
	{
		
	}
}

class Pen<T>
{
	public T a;
	public T b;
	public T c;
	
}

class Desk<T>
{
	private T data;

	public T getData()
	{
		// 지역변수에도 적용은 가능하지만 절대 하지말것
		// 메서드는 블랙박스 <- 밖에서 안 보임
		T a;
		
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}
	
}

class Laptop<T,U>
{
	private T a;
	private U b;
	
	public Laptop(T a, U b)
	{
		this.setA(a);
		this.setB(b);
	}

	public T getA()
	{
		return a;
	}

	public void setA(T a)
	{
		this.a = a;
	}

	public U getB()
	{
		return b;
	}

	public void setB(U b)
	{
		this.b = b;
	}
}