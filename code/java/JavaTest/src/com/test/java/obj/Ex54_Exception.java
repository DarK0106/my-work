package com.test.java.obj;

import java.util.Random;
import java.util.Scanner;

public class Ex54_Exception
{
	public static void main(String[] args) throws Exception
	{
		// Ex54_Exception.java
		/*
		 * 예외, Exception
		 * 런타임 오류
		 * 컴파일 중에 발생하는 오류가 아닌 실행중에 발생
		 * 테스터 or 개발자가 경험을 근거로 예측해서 사전에 조치함
		 * 이런 조치를 취하는 행위를 예외 처리, Exception Handling이라고 함
		 * 1. 제어문 사용
		 * 2. 전용 문장 사용
		 * 
		 */
		
		// m1();
		// m2(); <- 가독성이 너무 떨어지는 단점이 있음
		// m3();
		// m4();
		
		// throws Exception 쓰면 본사도 어디다 던져버림
		// 그래서 적어도 메인 메서드에서는 try catch를 적어야 함
		try
		{
			// m5();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		m6();
		
	}

	private static void m6()
	{
		// 예외 던지기
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자(짝수만): ");
		int n = scan.nextInt();
		
		if (n % 2 == 0) // 예외 조건
		{
			System.out.println("짝수: " + n); // 비즈니스 코드
		}
		else
		{
			System.out.println("홀수 입력 불가 !!"); // 예외 처리 코드
		}
		
		try
		{
			
			if ( n % 2 == 1)
			{
				throw new Exception(); // 예외 던지기, 억지로 에러를 만든 것
			}
			
			System.out.println("짝수: " + n);
		} 
		catch (Exception e) // 에러가 나야 튕기는데 조건 없는 try catch에 홀수 넣는다고 에러 안 나니까 문제가 생김
		// 문법적인 오류에나 try catch가 적합하지 논리적인 오류에는 잘 안쓰인다
		{
			System.out.println("홀수 입력 불가 !!");
		}
		
	}

	private static void m5() throws Exception
	{
		// 예외 미루기
		// 특정 메서드 내에서 발생한 예외를 해당 메서드 내에서 직접 처리하지 않고, 
		// 그 예외 처리에 대한 책임을 이 메서드를 호출한 쪽으로 넘기는 기술
		int n = 0; // 사용자가 입력한 0
		System.out.println(100 / n); // throws new ArithmeticException() 에러가 나는 순간 자바가 이런 예외 객체를 던짐
		// 근데 이번엔 받아줄 애가 없음
		// 그래서 이번엔 메서드 밖에다 던져버림
		// 사고는 부산점에서 터졌는데 처리는 서울본점에서 함
	}

	private static void m4()
	{	
		
		int n = 10; // 사용자 입력 
		try
		{	
			// 엑셀로 파일을 하나 열었다고 친다면
			System.out.println(100 / n);
			// 엑셀 파일을 여기서 닫아야함
			// 근데 여기서 에러나면 파일을 안 닫고 붙잡고있음
			
			return; // 빈 리턴문, return;의 역할 1. 값을 돌려주는 일 2. 메서드 종료
			// 메서드를 탈출할때 쓰는 return
		}	 
		catch (Exception e)
		{
			System.out.println("예외처리");
			// 엑셀 파일을 여기서 닫아야함 <- 이 코드를 코드마다 계속 쓰기가 힘드니까 finally를 쓰는 것
		} 
		finally // 성공하던 실패하던 무조건 실행하는 블럭, 앞에서 썼던 자원을 해제, 청소하는 역할이라 클린 코드라고 함
		{
			System.out.println("finally");
			// 엑셀 파일을 닫는다.
		}
		
		System.out.println("종료");
	}

	private static void m3()
	{
		try // 보통 이렇게 씀
		{
			int num = 10; // 여기서 에러 나면 뒤에 애들은 실행도 안 하고 catch로 넘어감
			// throw new ArithmeticException() 에러가 나는 순간 자바가 이런 예외 객체를 던짐
			System.out.println(100 / num); // ArithmeticException: / by zero
			
			int[] nums = { 10, 20, 30 };
			// 에러 나면 throw new ArrayIndexOutOfBoundsException()
			System.out.println(nums[1]); // ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 3
			
			Random rnd = new Random(); 
			// 에러 나면 throw new NullPointerException() 
			System.out.println(rnd.nextInt()); // NullPointerException: Cannot invoke "java.util.Random.nextInt()" because "rnd" is null
		} 
		catch (ArithmeticException e) // 자바가 던진 코드 잡는게 catch
		{
			System.out.println("0으로 나누기 -> 김대리에게 연락하세요.");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("배열 첨자 오류 -> 박과장에게 연락하세요.");
		}
		catch (NullPointerException e)
		{
			System.out.println("널 참조 오류 -> 최부장에게 연락하세요.");
		}
		catch (Exception e)
		{
			System.out.println("예외 발생.");
		}
	}

	private static void m2()
	{
		int num = 10;
		try
		{
			System.out.println(100 / num);
		}
		catch (Exception e)
		{
			System.out.println("0으로 나누기 -> 김대리에게 연락하세요");
		}
		
		int[] nums = { 10, 20, 30 };
		try
		{
			System.out.println(nums[1]);
		}
		catch (Exception e)
		{
			System.out.println("배열 첨자 오류 -> 박과장에게 연락하세요");
		}
	
		Random rnd = new Random();
		try
		{
			System.out.println(rnd.nextInt());
		}
		catch (Exception e)
		{
			System.out.println("널 참조 오류 -> 최부장에게 연락하세요");
		}
	}

	private static void m1()
	{
		// 요구사항) 숫자를 입력받아 산술 연산을 하시오.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int num = scan.nextInt();
		
		// if 문의 특징 선조건, 일단 검사부터 함
		// 선조건 -> 후처리
		if (num != 0) // 예외 조건
		{
			System.out.println(111);
			// 비즈니스 코드(업무 코드) <- 원래 하려던 코드
			System.out.printf(" 100 / %d = %d\r\n", num, 100 / num);
			System.out.println(222);
		}
		else
		{
			// 예외 처리 코드
			System.out.println("0을 입력하지 마시오.");
		}
		
//		if (num == 0) // 예외 조건
//		{
//			// 예외 처리 코드
//			System.out.println("0을 입력하지 마시오."); // <- if를 예외처리 코드로 쓰지 말자
//		// 가독성이 떨어짐
//		// 안 좋은 코드
//			
//		}
//		else
//		{
//			// 비즈니스 코드(업무 코드) <- 원래 하려던 코드
//			System.out.printf(" 100 / %d = %d\r\n", num, 100 / num);
//		}
		
		
		// System.out.println(100 / 0); // ArithmeticException / by zero
//		System.out.println(100 / 0.0); // Infinity 출력
//		System.out.println(100 / -0.0); // -Infinity 출력
		
		// 선실행 -> (에러 발생) -> 후조치
		// try catch에서 에러가 발생하는 순간 java는 하던 모든걸 멈추고 제어를 catch로 넘김
		// catch절 실행하고 끝남 사고가 터지는 순간 catch 출동
		// try catch 문을 써보자
		// 또는 try catch finally
		try
		{	
			System.out.println(111);
			// 비즈니스 코드(업무 코드) <- 원래 하려던 코드
			System.out.printf(" 100 / %d = %d\r\n", num, 100 / num); // 0을 넣었니 안 넣었니가 없다? 알아서 걸러준다?
			System.out.println(222);
		}
		catch (Exception e) // Exception e는 매개변수
		// Exception e : 예외 발생 상황에 대한 정보 객체 <- 상황을 알려주는 녀석
		{
			// 예외 처리 코드
			System.out.println("0을 입력하지 마시오.");
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace(); // 진짜 에러가 난게 아니라 에러 메세지를 출력해줌
			
		}
		
		System.out.println("종료");
		
	}
}
