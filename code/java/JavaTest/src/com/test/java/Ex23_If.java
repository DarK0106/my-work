package com.test.java;

// Package Explorer에서 클래스 클릭하고 F2 누르면 바로 이름 바꿀 수 있음
public class Ex23_If
{
	public static void main(String[] args)
	{
		// Ex23_If.java
		/*
		 * 제어문
		 * - 수많은 명령어 -> 명령어의 실행 순서 -> 위에서 아래로 ..
		 * - 제어의 흐름을 통제하는 도구
		 * - 조건 제어, 반복 제어, 분기 제어
		 * 
		 * 1. 조건문
		 * 	- 개발자가 조건을 제시한 후 결과에 따라 흐름을 제어
		 * 	a. if 
		 * 	b. switch
		 * 
		 * 2. 반복문
		 * 	- 특정 코드를 원하는 횟수만큼 반복 제어
		 * 	a. for
		 * 	b. while
		 * 	c. do while
		 * 	d. for (다르게 생긴)
		 * 
		 * 3. 분기문
		 * 	- 코드의 흐름을 원하는 곳으로 이동
		 * 	a. break
		 * 	b. continue
		 * 	c. goto(JDK 1.5 쯤에서 폐기)
		 */
		
		// m1();
		// m2();
		m3();
		
	} // main

	private static void m3()
	{
		// 성적(0~100) 입력 -> 유효성 검사 !! -> 합격인지 불합격인지 알려주는 프로그램, 60점 이상은 합격
		int score = 95;
		
//		if (score >= 60)
//		{
//			System.out.println("합격");
//		}
//		else
//		{
//			System.out.println("불합격");
//		}
		
		if (score >= 60 && score <= 100)
		{
			System.out.println("합격");
		}
		else if (score >= 0 && score < 60)
		{
			System.out.println("불합격");
		}
		else
		{
			System.out.println("점수는 0~100이내의 숫자로 입력하시오.");
		}
		
		// 더 좋은 코드, 중첩된 if문, nested if statement
		if (score >= 0 && score <= 100)
		{	
			// 올바른 성적이 입력됨 -> 합격 or 불합격 처리
			if (score >= 60)
			{
				System.out.println("합격");
			}
			else
			{
				System.out.println("불합격");
			}
		}
		else
		{
			System.out.println("점수는 0~100이내의 숫자로 입력하시오.");
		}
	}

	private static void m2()
	{
		// 출근을 하는 직장인 -> 기상은 몇시?
		int hour = 6;
		
		if (hour < 6)
		{
			System.out.println("지하철을 타고 출근한다.");
		}
		else if (hour >= 6 && hour < 7)
		{
			System.out.println("버스를 타고 출근한다.");
		}
		else if (hour >= 7 && hour < 8)
		{
			System.out.println("택시를 타고 출근한다.");
		}
		else
		{
			System.out.println("병가를 낸다.");
		}
		
		if (hour < 6)
		{
			System.out.println("지하철");
		}
		else if (hour < 7)
		{
			System.out.println("버스");
		}
		else if (hour < 8)
		{
			System.out.println("택시");
		}
		else
		{
			System.out.println("병가");
		}
		
	}

	private static void m1()
	{
		/*
		 * if문
		 * - 개발자가 조건을 제시하면 그 결과에 따라 흐름을 제어
		 * - 조건으로 사용하는 식인 조건식은 반드시 boolean 값을 가지는 표현식
		 * 
		 * if (조건식) 
		 * { 
		 * 실행할 코드; 
		 * }
		 * ========================
		 * if (조건식) 
		 * { 
		 * 실행할 코드; 
		 * }
		 * else
		 * {
		 * 실행할 코드;
		 * }
		 * ========================
		 * if (조건식) 
		 * { 
		 * 실행할 코드; 
		 * }
		 * else if ()
		 * {
		 * 실행할 코드;
		 * }
		 * else if ()
		 * {
		 * 실행할 코드;
		 * }
		 * else ()
		 * {
		 * 실행할 코드;
		 * }
		 * =======================
		 * if (조건식) 
		 * { 
		 * 실행할 코드; 
		 * }
		 * [else if ()
		 * {
		 * 실행할 코드;
		 * }] * N
		 * [else
		 * {
		 * 실행할 코드;
		 * }
		 * ]
		 * 
		 */
		
		// 사용자가 숫자를 입력 -> 조건
		// 제어도, 그림, mermaid, AI 활용
		int num = 5;
		
		String result = num > 0 ? "양수" : "양수아님"; // 삼항연산자
		System.out.printf("%d는 %s입니다.\n", num, result);
		
		System.out.println(1);
		if (num > 0)
		{
			System.out.println(2);
		}
		System.out.println(3);
		
		if (num > 0)
		{
			// 참일때 실행하는 블럭
			System.out.println("양수");
		}
		else
		{	
			// 거짓일때 실행하는 블럭
			System.out.println("양수아님");
		}
		
		num = 10;
		
		if (num > 0)
		{
			System.out.println("양수");
		}
		else if (num < 0)
		{
			System.out.println("음수");
		}
		else
		{
			System.out.println("0");
		}
	} // m1
	
	
}
