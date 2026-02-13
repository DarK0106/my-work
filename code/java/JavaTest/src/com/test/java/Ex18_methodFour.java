package com.test.java;

public class Ex18_methodFour
{
	public static void main(String[] args)
	{
		// Ex18_methodFour.java
		
		// Type mismatch: cannot convert from int to String
		// String result = m1();
		
		m2();
	}
	
	public static int m1()
	{
		return 10;
	}
	
	public static int m2()
	{
		System.out.println("1");
		System.out.println("2");
		
		return 10; // return을 만나는 순간 10이라는 값을 들고 호출부로 돌아간다
		// return 은 반환값 + 메서드를 중지시킨다
		
		// Unreachable code
		// System.out.println("3");
		// 당분간은 return은 맨 밑에 적는다
		
		// return 10;
		
	}
}
