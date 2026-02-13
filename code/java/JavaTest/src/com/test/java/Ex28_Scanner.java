package com.test.java;

import java.util.Scanner;

public class Ex28_Scanner
{
	public static void main(String[] args)
	{
		// Ex28_Scanner.java
		// 키보드 입력
		// 1. System.in.read()
		// 2. BufferedReader 클래스
		// 3. Scanner 클래스 <- Scanner 클래스가 BufferedReader 보다 할 수 있는 일이 조금 더 많음
		
		// m1();
		// m2();
		// m3();
		m4();
		
	}

	private static void m4()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름: ");
		// nextLine(); : 입력버퍼에서 엔터를 만나기 전까지 가져와라
		String name = scan.nextLine(); // 아무개
		System.out.println(name);
		
		System.out.print("나이: ");
		// 입력버퍼 안에 있는 숫자만 가져와, 엔터는 방치(안 버림)
		int age = scan.nextInt();
		System.out.println(age);
		
		// 엔터가 남아있다. -> 우리가 직접 버려야 한다
		// 첫 번째 방법: scan.nextLine();
		
		// 정확한 방법
		scan.skip("\r\n");
		
		System.out.println("주소: ");
		String adress = scan.nextLine(); // ""\r\n <- 앞에 안 버린 엔터가 있어 엔터를 만나기 전인 빈 문자열을 반환시켜 프로그램이 끝나버림
		System.out.println(adress);
	}

	private static void m3()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		System.out.println(age);
		
		System.out.println("몸무게: ");
		double weight = scan.nextDouble();
		System.out.println(weight);
		
		System.out.println("키: ");
		int height = scan.nextInt();
		System.out.println(height);
		
	}

	private static void m2()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("이름: ");
		String name = scan.nextLine();
		System.out.println(name);
		
		System.out.println("주소: ");
		String adress = scan.nextLine();
		System.out.println(adress);
		
		System.out.println("전화번호: " );
		String number = scan.nextLine();
		System.out.println(number);
	}

	private static void m1()
	{
		Scanner scan = new Scanner(System.in); // System.in 이 있으면 System.in.read()로 불러올 수 있다
		
//		System.out.println("문자열: ");
//		String line = scan.nextLine();
//		System.out.println(line);
		
		
		// 자료형별로 입력받는 전용 메서드를 제공(여기서는 nextInt();)
		System.out.println("숫자: ");
		int num = scan.nextInt();
		System.out.println(num*num);
		
	}
}
