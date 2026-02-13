package com.test.java;

public class Ex17_methodThree
{
	public static void main(String[] args)
	{
		// Ex17_methodThree
		
		// 메서드 반환타입
		
		m1();
		int result = m2();
		System.out.println(result);
		
		String result2 = m3(10);
		System.out.println(result2);
	} // main
	
	public static void m1()
	{
		System.out.println("m1");
	}
	
	// This method must return a result of type int
	public static int m2()
	{
		System.out.println("m2");
		
		// return 문
		// - return 값(상수/ 변수);
		// - 현재 메서드를 호출한 곳으로 값을 돌려준다
		// - 현재 메서드를 중지한다.
		return 10;
	}
	
	public static String m3(int num)
	{
		String result = num > 0 ? "양수" : "양수 아님";
		
		return result;
	}
}
