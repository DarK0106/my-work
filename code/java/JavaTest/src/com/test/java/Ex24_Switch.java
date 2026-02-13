package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex24_Switch
{
	public static void main(String[] args) throws IOException
	{	
		// Ex24_Switch.java
		/*
		 *
		 * switch문, switch case 문
		 * 조건문 중 하나
		 * switch의 조건에 들어갈 수 있는 조건 -> 정수, 문자열, 열거형
		 * 
		 * switch (조건)
		 * {
		 * 	case 값:
		 * 		실행할 코드;
		 * 		break;
		 * 	[case 값:
		 * 		실행할 코드;
		 * 		break;] * n번
		 * 	[default:
		 * 		실행할 코드;
		 * 		break;]
		 * }
		 */
		// m1();
		// m2();
		// m3();
		m4();
	}

	private static void m4()
	{
		// 형변환
		// 숫자형(6종 + 1종)끼리만 가능했다 ex) int -> double ..
		// char 도 사실은 숫자형이었다
		// 'A' -> 65
		System.out.printf("%c\r\n", 65);
		System.out.println((char)65);
		System.out.println((int)'A');
		
		char c1 = 'B'; // 크기가 2byte
		byte b1;
		short s1; // 2byte
		
		// short(2byte) = char(2byte)
		s1 = (short)c1; // 크기가 똑같으면 암시적으로 형변환 해야하는데, 명시적으로 형변환 (앞에 (short) 붙여서)
		
		System.out.println(s1); // 66
		
		char c2;
		short s2 = 67; // 'C'
		
		
		// char(2byte) = short(2byte)
		c2 = (char)s2;
		
		System.out.println(c2); // 'C'
		// 왜 명시적으로 형변환해야할까?
		// short랑 char랑 같은 2byte는 맞지만, 범위가 다름
		// short(-32768~32767) / char(0~65535)
		// 그래서 애초에 char 형변환할때 최소 short보단 큰 자료형인 int로 써야함
		// *** 문자 코드를 저장할 숫자형은 int 이다.
	}

	private static void m3()
	{
		// 달력 -> 마지막 날짜가 얼마인가?
		int month = 5;
		int lastDay = 0;
		
		if (month == 1 
				|| month == 3 
				|| month == 5 
				|| month == 7 
				|| month == 8 
				|| month == 10 
				|| month == 12)
		{
			lastDay = 31;
		}
		else if (month == 4 
				|| month == 6 
				|| month == 9 
				|| month == 11)
		{
			lastDay = 30;
		}
		else
		{
			lastDay = 28;
		}

		System.out.println(lastDay);
		
		// switchcase로 변경	
		switch(month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				lastDay = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				lastDay = 30;
				break;
			case 2:
				lastDay = 28;
				break;
		}
		System.out.println(lastDay);
	}

	private static void m2() throws IOException
	{
		// 요구사항) 자판기
		// 실행하면 메뉴 출력 -> 음료 선택 -> 그 음료가 얼마인지 가격을 출력
		// 메뉴의 가격 변동 -> 사이다가 700원 -> 앞으로 평생 콜라와 사이다는 가격을 동일하게 판매
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("=============");
		System.out.println("   자판기");
		System.out.println("=============");
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 박카스");
		System.out.println("-------------");
		System.out.println("번호 선택: ");
		
		String input = reader.readLine();
		
		if (input.equals("1") || input.equals("2"))
		{
			System.out.println("700원입니다.");
		}
		else if (input.equals("3"))
		{
			System.out.println("500원입니다.");
		}
		
		switch (input)
		{
			case "1":
			case "2":
				System.out.println("700원입니다.");
				break;
			case "3":
				System.out.println("500원입니다.");
				break;
		}
	}

	private static void m1()
	{
		// 사용자가 숫자 1개 입력 -> 입력받은 숫자를 한글로 출력
		// 1 -> 하나
		// 2 -> 둘
		// 3 -> 셋
		
		int num = 1;
		
		if (num == 1)
		{
			System.out.println("하나");
		}
		else if (num == 2)
		{
			System.out.println("둘");
		}
		else if (num == 3)
		{
			System.out.println("셋");
		}
		else
		{
			System.out.println("나머지 숫자");
		}
		
		switch (num)
		{
			case 1:
				System.out.println("하나");
				break; // break가 없으면 프린트문이 밑으로 흘러내려감
			case 2:
				System.out.println("둘");
				break;
			case 3:
				System.out.println("셋");
				break;
			default:
				System.out.println("나머지 숫자");
			break;
		}
		
		int score = 95;
		
		if (score >= 60 && score <= 100)
		{
			System.out.println("합격");
		}
		else if (score >= 0 && score <= 60)
		{
			System.out.println("불합격");
		}
		
		// *** switch문은 범위 조건에는 부적합하다.
//		switch (score)
//		{
//			case 100:
//				System.out.println();
//				break; <- 60점까지 case 40번 써야함 
//		}
	}
}
