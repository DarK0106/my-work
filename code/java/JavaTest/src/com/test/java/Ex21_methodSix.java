package com.test.java;

public class Ex21_methodSix
{
	public static void main(String[] args)
	{
		// Ex21_methodSix.java
		
		/*
		 * 
		 * 재귀 메서드, Recursive Method
		 * - 재귀 구조를 가지는 메서드
		 * - 자기가 자기를 호출하는 구조를 가진 메서드
		 * - 어렵다. -> 머릿속으로 상상하기 힘들다.
		 * - 트리 구조 같은 자료구조에서 탐색 할 때 많이 씀
		 * 
		 */
		
		// m1();
		// 팩토리얼 구하는 예제
		// 4! = 4 * 3 * 2 * 1= 24
		// 4! = 24
		
		// 요구사항) 팩토리얼 값을 구하는 메서드를 구현하시오.
		int n = 4;
		int result = factorial(n); // factorial 메서드 안 만든 상태에서 factorial 에러창에 Create 누르면 이클립스가 알아서 만들어줌 
		
		System.out.printf("%d! = %d\r\n", n, result);
	} // main

	public static int factorial(int n)
	{
		return (n == 1) ? 1 : n * factorial(n-1);
	}
	
	public static void m1()
	{	
		// 재귀 메서드
		System.out.println("m1");
		m1(); // 재귀 호출
	}
	
//	public static void m2()
//	{
//		System.out.println("m2");
//		m1();
//	}
}

