package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex25_For
{
	public static void main(String[] args) throws IOException
	{
		// Ex25_For.java
		/*
		 * 
		 * 반복문 - 특정 코드를 개발자가 원하는 횟수만큼 반복한다. for (초기식; 조건식; 증감식) { 코드; }
		 * 
		 */
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		// m10();
		// m11();
		// m12();
		// m13();
		// m14();
		// m15();
		m16();
	}
	
	private static void m16()
	{	
		// 프로그램 실행(Run): Ctrl + F11
		// 프로그램 실행(Debug): F11 -> F6
		// Breakpoint 찍기 -> F11
		System.out.println("시작");
		
		for (int i = 0; i < 10; i++)
		{
			if (i == 5)
			{
				continue;
			}
			System.out.println(i);
		}
		System.out.println("끝");
	}

	private static void m15()
	{
		// 다중 for + break / continue
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
//				if (i == 5)
//				if (j == 5)
//				if ( i == 5 && j == 5)
				if ( i == 5 || j == 5)
				{
					// break;
					continue;
				}
				System.out.printf("i: %d j: %d\n", i, j);
			}
		}
	}

	private static void m14()
	{
		// 구구단
		// 2단 ~ 9단을 모두 출력
		for (int j = 2; j <= 9; j++)
		{
			for (int i = 1; i <= 9; i++)
			{
				System.out.printf("%d * %d = %2d\n", j, i, j*i);
			}
			System.out.println(); // 단마다 한 칸 띄우기
		}
	}

	private static void m13()
	{
		// 이제까지 했던건 (단일) for문
		// for문의 중첩 -> 2중 for문, 3중 for문.. n중 for문
		
		// 단일 for문
		for (int x = 0; x < 10; x++)
		{
			System.out.printf("i: %d\n", x);
		}
		System.out.println();
		
		// 2중 for문
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				// System.out.println("출력문"); // 몇 번 실행? 100번 실행됨
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
		System.out.println();
		
		// 3중 for문
		for (int i = 0; i < 24; i++) // 대회전 -> 시침
		{
			for (int j = 0; j < 60; j++) // 중회전 -> 분침
			{
				for (int k = 0; k < 60; k++) // 소회전 -> 초침
				{
					// 하루 24시간을 출력해보자 -> 위에거가 출력이 되어있는데 짤렸음(이클립스가 짜름)
					// 콘솔 우클릭 -> preference -> 출력 버퍼 조정해서 모두 출력 가능
					System.out.printf("i: %d j: %d k: %d\n", i, j, k);
				}
			}
		}
		
		System.out.println();
		
		/*
		 * 학교
		 * for (학년)
		 * {
		 * 		for (반)
		 * 		{
		 * 			for (번호)
		 * 			{
		 * 
		 * 			}
		 * 		}
		 * }
		 * 
		 * for (단지)
		 * {
		 * 		for (동)
		 * 		{
		 * 				for (층)
		 * 				{
		 * 					for (호)
		 * 					{
		 * 
		 * 					}
		 * 				}
		 * 		}
		 * }
		 * 
		 */
	}

	private static void m12()
	{
		// 난수 만들기
		// - 임의의 수를 만드는 작업
		
		// 1. Math 클래스
		// 2. Random 클래스(Math를 감싼 클래스)
		
		// System.out.println(Math.PI); <- 원주율
		// Math.abs() <- 절대값
		// Math.ceil(0) <- 반올림
		// Math.round(0) <- 반올림
		// Math.floor(0)
		// Math.exp(0)
		// Math.random()
		// Math.sin(0)
		// Math.cos(0)
		// Math.tan(0)
		
		// System.out.println(Math.random()); <- 난수 생성, 0 이상 1 미만 의 값 중 하나
		
		for (int i = 0; i < 10; i++)
		{
			// System.out.println(Math.random());
			// 이 난수를 가공 -> 1 ~ 10 정수
			// System.out.println(Math.random()*10);
			// System.out.println((int)(Math.random()*10) + 1);
			
			// 주사위 -> 1~6
			// System.out.println((int)(Math.random()*6) + 1);
			
			// 3 ~ 8
			System.out.println((int)(Math.random()*6) + 3);
		}
	}

	private static void m11()
	{
		// 중학교 선생님이 학생 상담, 학생 수 30명
		for (int i = 1; i <= 30; i++)
		{
//			if ( i >= 16) <- 15번 학생까지만 상담하겠다
//			{
//				break;
//			}
			
			if (i == 10 || i == 15 || i == 19) // 10, 15, 19번 학생이 결석했다
			{
				continue; // 스킵하는 역할
			}
			System.out.println(i + "번 학생 상담 중..");
		}
	}

	private static void m10()
	{
		// 분기문
		// - break, continue
		// - switch문 반복문과 같이 사용
		// - if문은 제외(break가 인식을 못함)
		
		// 1. break
		// - 자신이 포함된 제어문을 탈출하는 역할
		// - 아예 중단하는 역할(Stop)
		
		// 2. continue
		// - 현재 자신이 포함된 제어문의 처음으로 돌아간다.
		// - 잠시 건너뛰는 역할(Skip)
		
//		for (int i = 1; i <= 10; i++)
//		{
//			if (i == 5) // 보통 5 자리에 사용자가 입력한 값이 들어감
//			{
//				break; // for 문을 탈출
//			}
//			
//			System.out.println(i);
//			
//		}
		
		for (int i = 1; i <= 10; i++)
		{
			if (i == 5) // 보통 5 자리에 사용자가 입력한 값이 들어감
			{
				continue; // for 문을 탈출
			}
			
			System.out.println(i);
			
		}
	}

	private static void m9() throws NumberFormatException, IOException
	{
		// 무한 루프, Infinite Loop
		// 1. 개발자 실수
		// 2. 의도적인 무한 루프
		// 	a. 반복 횟수 미정
		// 	b. 진짜로 무한 루프가 필요할 때
		
		// 21억바퀴, int 범위인 -21억~ 21억, - 범위를 벗어나면 언더플로우가 일어나면서 i가 양수(21억)로 바뀜. 그러면 루프 종료
//		for (int i = 0; i < 10; i--)
//		{
//			System.out.println("실행문");
//		}
		
		// 고의로 무한루프 만들기
		// for (int i = 0; true; i++)
		// 
		
		// 사용자 숫자 입력 * ?번 -> 입력받은 숫자의 합 구하기
		// 사용자 마음대로 입력하게 냅둔다 <- 반복 횟수 미정
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		
		for (;;)
		{
			// 숫자 0 은 누적에 영향을 안 미치기 때문에
			// 숫자 0 은 그만 입력하고 싶다는 뜻으로 받아들이겠다.
			System.out.print("숫자를 입력하세요: ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num == 0)
			{
				break;
			}
			
			sum = sum + num;
		}
		
		System.out.println(sum);
		
	}

	private static void m8() throws NumberFormatException, IOException
	{
		// 요구사항) 사용자가 보고 싶은 구구단 출력
		/*
		 *  보고 싶은 단 입력: 5
		 *  5 x 1 = 5
		 *  5 x 2 = 10
		 *  ...
		 *  5 x 9 = 45
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("보고 싶은 단(2~9) 입력: ");
		int dan = Integer.parseInt(reader.readLine());
		for (int i = 1; i < 10; i++)
		{
			System.out.printf("%d * %d = %2d\r\n", dan, i, dan*i);
		}
	}

	private static void m7() throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 요구사항) 사용자가 입력한 숫자 10개 -> 입력한 수를 모두 더하라
		int sum = 0;
		for (int i = 0; i < 10; i++)
		{
			System.out.println("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			sum = sum + num;
		}
		System.out.println(sum);
	}

	private static void m6() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 요구사항) 사용자 숫자 입력 -> 1~사용자 입력 숫자까지의 합
		System.out.println("숫자: ");
		
		// String input = reader.readLine();
		// int num = Integer.parseInt(input);
		
		int num = Integer.parseInt(reader.readLine());
		int sum = 0;
		
		for (int i=1; i<=num; i++)
		{
			// System.out.println(i);
			sum = sum + i;
		}
		System.out.printf("1~ %,d 까지의 합 = %d\r\n", num, sum);
	}

	private static void m5()
	{
		// 요구사항) 1~10까지의 합
		int sum = 0; // 누적 변수
		for (int i = 1; i <= 10; i++)
		{
			sum = sum + i;

			// i(1) -> 1 = 0 + 1
			// i(2) -> 3 = 0 + 1 + 2
			// i(3) -> 6 = 0 + 1 + 2 + 3
			// i(4) -> 10 = 0 + 1 + 2 + 3 + 4
			// ..
			// i(10) -> 55 = 0 + 1 + 2 + 3 + 4 + ... + 9 + 10

		}
		System.out.println(sum);
	}

	private static void m4()
	{
		// 요구사항) 숫자 1~10까지 출력
		int n = 1;

		for (int i = 0; i < 10; i++)
		{
			System.out.println(n);
			n++;
		}
		System.out.println();
//==========================================		
		for (int i = 1; i <= 10; i++)
		{
			System.out.println(i);
		}
		System.out.println();
//==========================================
		for (int i = 1; i <= 10; i += 2)
		{
			System.out.println(i);
		}
		System.out.println();
//==========================================
		for (int i = 2; i <= 10; i += 2)
		{
			System.out.println(i);
		}
		System.out.println();
	}

	private static void m3()
	{
		// 반복문
		// 반복문을 쓸 때 중요한거 2가지
		// 1. 반복 횟수 <- 중요도 10%
		// 2. 루프 변수 <- 중요도 90% <- ***루프 변수 값의 변화

		for (int i = 0; i < 5; i++) // <- 제일 많이 씀
		{
			// 1. 초기식에서 i 가 0으로 초기화
			// 2. 조건식에서 루프를 돌지 말지 검사
			// 3. 증감식이 i 를 1로 바꿈 -> 변화가 생김 -> 조건식에서 루프를 돌지 말지 검사
			// 4. 0 -> 1 -> 2 -> 3 -> 4
			// 5. i 가 5가 되면서 조건식에서 검사받으니 i < 5 만족 못해서 루프 종료
			System.out.println("실행문");
		}
		System.out.println();

		for (int i = 1; i <= 5; i++) // <- i <= 5 도 회전수긴 한데 = 한 번 더 쳐야해서 귀찮음
		{
			System.out.println("실행문");
		}
		System.out.println();

		for (int i = 1; i < 6; i++) // <- 틀린건 아닌데 i < 6 에서 머리속에서 1 빼야해서 귀찮음
		{
			System.out.println("실행문");
		}
		System.out.println();

		for (int i = 5; i > 0; i--)
		{
			System.out.println("실행문");
		}
		System.out.println();

		for (int i = 0; i < 25; i += 5)
		{
			System.out.println("실행문");
		}
		System.out.println();
	}

	private static void m2()
	{
		// 지역 변수
		// - 메서드 / 제어문 안에서 선언한 변수

		int a = 10; // 지역 변수(m2)
		int c = 0;
		System.out.println("a: " + a);

		if (a > 0)
		{
			int b = 20; // 지역 변수 (if)
			System.out.println("b: " + b);
			System.out.println("a: " + a);
			c = b;

		}

		// System.out.println("b: " + b); <- b cannot be resolved to a variable <- b는
		// if문이 자기 집이라 집 밖에 나가면 죽는다
		System.out.println("a: " + a);
		System.out.println("c: " + c);
	}

	private static void m1()
	{
		// 요구사항) "안녕하세요." 5회 출력
		// 수정사항) "반갑습니다." 로 수정
		// 추가사항) "반갑습니다." 100회 출력

		// Case A.
		System.out.println("안녕하세요."); // Ctrl + Alt + 방향키(아래 or 위)
		System.out.println("안녕하세요."); // Ctrl + D
		System.out.println("안녕하세요."); // Alt + 방향키
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");

		// Case B.
		hello();

		// Case C.
		// i = 루프(loop) 변수
		// 초기식: 루프 변수를 초기화 <- 처음 한번만 실행함
		// 조건식: 루프 반복을 위한 조건
		// 증감식:
		for (int i = 0; i < 100; i++)
		{
			System.out.println("안녕하세요.");
		}
	}

	private static void hello()
	{
		System.out.println("안녕하세요.");
	}
}
