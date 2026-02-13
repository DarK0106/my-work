package com.test.java;

public class Ex26_While
{
	public static void main(String[] args)
	{
		// Ex26_While.java
		/*
		 * while 문
		 * while (조건식)
		 * {
		 * 코드;
		 * }
		 * 
		 * do while 문
		 * {
		 * 코드;
		 * } while(조건식); <- 조건에 false가 있더라도 최소 한번은 실행, 조건부 반복 실행
		 */
		// m1();
		m2();
	}

	private static void m2()
	{
		int num = 1;
		do
		{
			System.out.println(num);
			num++;
		} while (num <= 10);
	}

	private static void m1()
	{
		// 1에서 10까지 출력
		for (int i = 1; i <= 10; i++) // for 는 초기식 조건식 증감식
		{
			System.out.println(i);
		}
		System.out.println();
		
		int n = 1; // 초기식 역할
		while (n <= 10) // while 문은 조건식만 필요해서 상황에 따라 유연하게 사용할 수 잇음
		{
			System.out.println(n);
			n++; // 증감식 역할
		}
	}
}
