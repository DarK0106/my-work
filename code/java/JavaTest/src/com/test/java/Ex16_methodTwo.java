package com.test.java;

public class Ex16_methodTwo
{
	public static void main(String[] args)
	{
		// Ex16_methodTwo
		
		// 메서드 인자 리스트
		// - 파라미터(Parameter)
		// - 매개변수
		// - 인수
		
		// 요구사항) '홍길동'에게 인사하는 메서드를 구현하시오.
		// 요구사항) '아무개'에게 인사하는 메서드를 구현하시오.
		// 요구사항) '강아지'에게 인사하는 메서드를 구현하시오.
		// 요구사항) 대한민국에 있는 모든 사람에게 인사하는 메서드를 구현하시오.
		hello();
		hello2();
		hello3();
		test(10);
		helloEveryone("엄준식");
		
		// 요구사항) 두 수를 입력받아 합을 구하는 메서드
		sum(10, 20);
		sum(5, 7);
		sum(100, 150);
		
		
		// 나이 검사
		checkAge(25, "홍길동");
		checkAge(10, "테스트");
		checkAge(22, "아무개");
		//checkAge("아무개", 22); <- 안 됨
		//checkAge(22); <- 안 됨
		//checkAge("아무개", 22, 남자); <- 안됨
		
		
		// 요구사항) 성적을 입력받아 총점과 평균을 출력하는 메서드 구현
		// checkScore(국어 점수, 영어 점수, 수학 점수)
		// 출력 결과 -> 총점: 270점 평균: 90.0점
		checkScore(100, 90, 80);
		
		// 메인이라는 메서드는 왜 호출을 안해도 무조건 실행이 될까?
		// 메인도 일단은 그냥 메서드인데 특이한 메서드이다
		// 특징1: main 이라는 이름이 예약어다. 자바랑 약속한 이름
		// 이 이름은 개발자가 호출하지 않고 프로그램이 실행되면 자바가 호출하는 메서드이다
		// 프로그램의 시작점(Entry Point)
		// 메인 메서드의 끝에 도달하면 전체 프로그램이 종료된다
		// 그래서 프로그램의 종착점(End Point)이기도 하다
		
	} // main
	
	public static void hello()
	{
		System.out.println("홍길동님. 안녕하세요.");
	}
	
	public static void hello2()
	{
		System.out.println("아무개님. 안녕하세요.");
	}
	
	public static void hello3()
	{
		System.out.println("강아지님. 안녕하세요.");
	}
	
	// 메서드 다형성
	public static void test(int a) // <- 괄호에 있는 a 는 선언만 할 수 있고 초기화는 할 수 없는 변수
	{
		System.out.println(a);
		// 아무것도 안 넣어도 에러는 안 남
		// a 에 값을 넣고 싶으면 메서드 호출할 때 test(10); 이런 식으로 괄호에 값 넣으면 가능
		// 값을 받아오기 때문에 괄호 안에 있는걸 매개변수라고 부름
		// 메서드 선언부에는 달라지는게 없는데 메서드 호출할 때 10 20 30 여러가지 변화를 줄 수 있음
	}
	
	public static void helloEveryone(String name)
	{
		System.out.println(name + "님. 안녕하세요.");
	}
	
	public static void sum(int a, int b)
	{
		System.out.println(a+b);
	}
	
	public static void checkAge(int age, String name)
	{
		// age 검사
		String result = age >= 18 ? "성인":"미성년자";
		
		System.out.printf("%s님은 %s입니다.\r\n", name, result);
	}
	
	public static void checkScore(int score1, int score2, int score3)
	{
		int totalScore = score1 + score2 + score3;
		float averageScore = totalScore / 3;
		
		System.out.printf("총점: %s\r\n평균: %.1f", totalScore, averageScore);
	}
}
