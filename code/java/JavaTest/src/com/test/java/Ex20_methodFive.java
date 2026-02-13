package com.test.java;

public class Ex20_methodFive
{
	public static void main(String[] args)
	{
		// Ex20_methodFive.java
		
		/*
		 * 
		 * 메서드 오버로딩, Method Overloading
		 * - 같은 이름의 메서드를 여러개 만드는 기술
		 * - 왜 쓰는가? 성능이 아닌 철저히 사람을 위한 기술
		 * - 성능에는 1도 도움 안 됨
		 * 메서드 오버로딩 구현 조건
		 * 1. 매개변수의 개수가 다르다
		 * 2. 매개변수의 자료형이 다르다
		 * 
		 * 메서드 오버로딩 구현이 안 되는 경우
		 * 1. 매개변수의 이름(변수명)만 다른 경우
		 * 2. 반환값의 자료형만 다른 경우
		 * 
		 * 메서드 선언
		 * 1. public static void test() {} <- 선언 성공
		 * 2. public static void test() {} <- 선언 실패, 1번과 똑같기 때문
		 * 3. public static void test(int n) {} <- 선언 성공, 매개변수가 없는 1번과 달리 3번은 매개변수가 1개, 매개변수의 개수가 다르기 때문에 선언할 수 있음
		 * 4. public static void test(int m) {} <- 선언 실패, 3번과 매개변수의 이름만 다르기 때문에 3번과 4번을 구분하지 못함
		 * 5. public static void test(int n, int m) {} <- 선언 성공, 매개변수의 개수가 달라서 호출 가능
		 * 6. public static void test(String s) {} <- 선언 성공, 3번과 매개변수의 자료형이 다름
		 * 7. public static void test(byte n) {} <- 선언은 되지만 상위 타입의 자료형이 있으면 하위 타입 자료형은 굳이 안 만든다
		 * 8. public static int test() {} <- 선언 실패
		 * 
		 * 
		 * **메서드 호출하기**
		 * 호출할 때 구분이 되는지를 잘 봐야함
		 * test(); <- 1번 호출
		 * test(10); <- 3번 호출, 이름은 같지만 각각 서로 다른 메서드를 부른 것이다
		 * test(10, 20); <- 5번
		 * test("문자열") <- 6번
		 * test(10); <- 7번(X) -> 3번(O)
		 * test(byte(10)) <- 7번 부르고 싶으면 이렇게 불러야 함
		 * int result = test(); <- 8번을 부르지 않고 1번을 부름 =는 오른쪽 부터 읽어서 test(); 만 읽음 그래서 int result를 못 봄
		 * 
		 * void는 메서드 반환값에 아무것도 안 적고 싶은데 키워드는 적어야 하니 만들어낸 키워드
		 */
		
		// 요구사항) 화면에 선을 긋는 메서드를 구현하시오.
		// 요구사항) 선 모양을 **********로 그려라
		drawLine();
		System.out.println("   성적표");
		drawLine2();
		
		drawLine("@");
		
		/*
		System.out.println(10);
		System.out.println("문자열");
		System.out.println(true);
		<- 셋 다 다른 메서드이다
		*/
		
		System.out.println(10);
		System.out.println("문자열");
		System.out.println(true);
		
	} // main
	
	public static void drawLine()
	{
		System.out.println("==========");
	}
	
	public static void drawLine2()
	{
		System.out.println("**********");
	}
	
	public static void drawLine(String s)
	{
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.println(s);
	}
	
	public static void m1()
	{
		
	}
	
	// Duplicate method m1() in type Ex20_methodFive
	/*
	public static void m1()
	{
		
	}
	*/
}
