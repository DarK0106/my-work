package com.test.java.obj.inheritance;

public class Ex52_Generic
{
	public static void main(String[] args)
	{
		// Ex52_Generic.java
		/*
		 * 제네릭, Generic - Object 클래스의 업무 일부를 대신하기 위해서 1. 제네릭 클래스 2. 제네릭 메서드
		 * 
		 * 요구사항) 클래스를 설계해주세요 1. 멤버 변수 1개 -> int 2. 멤버 변수를 중심으로 여러가지 행동을 하는 메서드를 구현
		 * 
		 * 추가 요구사항) String 중심으로 하는 클래스 설계 추가 요구사항) boolean 중심으로 하는 클래스 설계 추가 요구사항)
		 * double 중심으로 하는 클래스 설계 다른 자료형을 만들 때 마다 똑같이 생긴 클래스를 무한대로 만들어야 하는 문제 발생 팥붕어빵 만드는
		 * 틀 따로 슈크림 붕어빵 만드는 틀 따로 있는 상황
		 */

		WrapperInteger n1 = new WrapperInteger(10);
		System.out.println(n1.getData());
		System.out.println(n1.getData() * 2);
		System.out.println();

		WrapperObject n2 = new WrapperObject(20);
		System.out.println(n2.getData());
		// The operator * is undefined for the argument type(s) Object, int <- Object랑
		// int 어떻게 곱하는지 몰라요
		System.out.println((int) n2.getData() * 3); // 그래서 앞에 (int) 붙여줘야함
		// Object엔 아무거나 넣을 수 있지만 꺼낼때마다 내가 뭘 넣었는지 기억을 못하면 무슨 자료형인지 찾기 힘듬
		
		// Generic
		Wrapper<Integer> n3 = new Wrapper<Integer>(30);
		System.out.println(n3.getData());
		System.out.println(n3.getData() * 2); // Generic은 형변환 없이 바로 연산이 가능하다
		// Object 처럼 모든걸 넣을 수 있으면서 Object는 못하는 형변환 없이 바로 꺼내서 쓰기가 가능하다
		System.out.println();
		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1.getData());
		System.out.println(s1.getData().length());
		System.out.println();

		WrapperObject s2 = new WrapperObject("대한민국");
		System.out.println(s2.getData());
		System.out.println(((String) s2.getData()).length());
		System.out.println();
		
		// Generic
		Wrapper<String> s3 = new Wrapper<String>("미국");
		System.out.println(s3.getData());
		System.out.println(s3.getData().length());
		System.out.println();

		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.getData());
		System.out.println(b1.getData() ? "참" : "거짓");
		System.out.println();

		WrapperObject b2 = new WrapperObject(false);
		System.out.println(b2.getData());
		System.out.println((boolean) b2.getData() ? "참" : "거짓");
		System.out.println();
		
		// Generic
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3.getData());
		System.out.println((boolean) b3.getData() ? "참" : "거짓");
		System.out.println();
		
	} // main
}

class Wrapper<T>
{
	private T data;
	
	public Wrapper(T data)
	{
		this.data = data;
		
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}
	
	@Override
	public String toString()
	{
		return "[data= " + data + "]";
	}
}

class WrapperObject
{
	// 1. 핵심 데이터
	private Object data;

	// 2. 데이터를 중심으로 조작하는 메서드
	public WrapperObject(Object data)
	{
		this.data = data;
	}

	public Object getData()
	{
		return data; // 실제로는 n2에 숫자가 들어있지만 Object 라는 클래스를 반환한것
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "[data= " + data + "]";
	}
}

class WrapperBoolean
{
	// 1. 핵심 데이터
	private boolean data;

	// 2. 데이터를 중심으로 조작하는 메서드
	public WrapperBoolean(boolean data)
	{
		this.data = data;
	}

	public boolean getData()
	{
		return data;
	}

	public void setData(boolean data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "[data= " + data + "]";
	}
}

class WrapperString
{
	// 1. 핵심 데이터
	private String data;

	// 2. 데이터를 중심으로 조작하는 메서드
	public WrapperString(String data)
	{
		this.data = data;
		// this.setData(data); <- 이렇게 하면 유효성 검사를 Setter에서만 해도 되기 때문에 이클립스가 자동으로 바꿔줌
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "[data= " + data + "]";
	}
}

class WrapperInteger
{
	private int data;

	// 2. 데이터를 중심으로 조작하는 메서드
	public WrapperInteger(int data)
	{
		this.setData(data);
	}

	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "[data= " + data + "]";
	}
}