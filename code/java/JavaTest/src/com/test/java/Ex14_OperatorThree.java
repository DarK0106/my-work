package com.test.java;

public class Ex14_OperatorThree
{
	
	public static void main(String[] args)
	{
		
		// Ex14_OperatorThree.java
		/*
		 * 
		 * 논리 연산자
		 * - &&(and), ||(or), !(not)
		 * - 2항 연산자(&&, ||)
		 * - 1항 연산자(!)
		 * - 피연산자의 자료형은 boolean이다.
		 * - 연산의 결과는 boolean이다.
		 * 
		 * 논리곱(*)
		 * A && B = ?
		 * 
		 * True && True = T
		 * True && False = F
		 * F && T = F
		 * F && F = F
		 * 
		 * 논리합(+)
		 * A || B = ?
		 * 
		 * True || True = T
		 * True || False = T
		 * F || T = T
		 * F || F = F
		 * 
		 * boolean이 옛날엔 없었음
		 * 조건 -> 참(1), 거짓(0)
		 * 
		 * !A = ?
		 * 
		 * !T = F
		 * !F = T
		 * 
		 * 베타적 논리합(xor, exclusive or)
		 * A ^ B = ? <- 서로 다르면 T, 똑같으면 F
		 * 
		 * T ^ T = F
		 * T ^ F = T
		 * F ^ T = T
		 * F ^ F = F
		 * 
		 * ~(tilde), ^(xor, caret), |(pipe, vertical bar), /(slash), \(back slash)
		 * ;(semi colon), :(colon), ,(period), .(dot)
		 * (), [], {}, < >(화살표괄호)
		 * 
		 */
		
		boolean f1 = true;
		boolean f2 = false;
		boolean f3 = true;
		
		System.out.println(f1 && f2 && f3); // f1 && f2 먼저 하고 -> false && f3 이런 식임
		System.out.println(f1 || f2 || f3);
		System.out.println(f1 && f2 || f3);
		System.out.println(!f2);
		System.out.println(f1 ^ f2);
		System.out.println(f1 ^ f3);
		
		// 요구사항) 나이를 입력해서 18세 이상이면서 60세 미만
		int age = 20;
		
		// 연산자 우선 순위
		// -(1등)산술 연산자 > (2)비교 연산자 > (3)논리 연산자
		System.out.println(18 <= age && age < 60);
		System.out.println((18 <= age) && (age < 60)); // 알아보기 쉽게 소괄호 써도 됨
		
		/*
		 * 
		 *  대입 연산자, 할당 연산자
		 *  	=
		 *  	+=, -=, *=, /=, %= (복합 대입 연산자)
		 *  	LValue(변수) = RValue(변수, 상수)
		 *  	LValue와 RValue의 자료형이 동일해야한다. -> 다르다면 형변환을 해야 함
		 *  	대입 연산자는 모든 연산자들 중 우선 순위가 가장 낮다.
		 *  	
		 *  	대입 연산자는 연산 방향이 오른쪽에서 왼쪽 순이다.
		 * 
		 */
		
		int sum = 1 + 2 + 3;
		
		int a1 = 100;
		int a2;
		int a3;
		
		a2 = a1;
		a3 = a1;
		
		a3 = a2 = a1; // 이렇게 해도 똑같음
		
		// 복합 대입 연산자 <- 한번이라도 타이핑 덜 하려고 만들어진 연산자
		int n = 10;
		
		// n에 1을 추가하시오 -> n의 값에 1을 더해서 n에 다시 넣어라
		// 이걸 누적이라고 부른다 <- 엄청 많이 씀
		
		n = n + 1;
		System.out.println(n); // 11
		
		// n = n + 1; 이걸 줄여놓은게
		n += 1;
		System.out.println(n); // 12
		
		n += 5;
		System.out.println(n); // 17
		
		n = n - 2;
		System.out.println(n); // 15
		
		n -= 2;
		System.out.println(n); // 13
		
		n = n * 3;
		System.out.println(n); //39
		
		n *= 3;
		System.out.println(n); // 117
		
		n = n / 7;
		System.out.println(n); // 16
		
		n /= 4;
		System.out.println(n); // 4
		
		n = n % 3;
		System.out.println(n); // 1
		
		n %= 3;
		System.out.println(n); // 1
		
		/*
		 * 
		 * 증감 연산자
		 * 	++(증가), --(감소)
		 * 	둘 다 1항 연산자
		 * 	피연산자는 숫자형을 가진다
		 * 	누적 연산을 한다
		 * 	기존의 값에 1을 더하거나 1을 뺀다
		 * 
		 * 	*** 증감 연산자는 피연산자의 위치를 바꿀 수 있다
		 * 	- 피연산자 위치에 따라서 연산자 우선 순위가 바뀐다
		 * 	1. ++n : 전위배치 또는 전치연산 이라고 부름 -> 연산자 우선 순위가 가장 높다
		 * 	2. n++ : 후위배치, 후치연산 이라고 부름 -> 연산자 우선 순위가 가장 낮다
		 * 	*** 결론: 증감 연산는 되도록 같은 문장에 다른 연산자와 같이 사용하지 말자 !!
		 * 
		 */
		
		n = 10;
		n = n + 1;
		n += 1;
		++n;
		n++;
		System.out.println(n); // 14
		
		n = n - 1;
		n -= 1;
		--n;
		n--;
		System.out.println(n); // 10
		
		System.out.println();
		
		n = 10;
		int result = 0;
		
		// result = 10 + ++n; 
		// ++n은 11을 반환하는게 아니라 11로 바뀐 n을 반환한다
		
		++n;
		result = 10 + n; // 가독성 때문에 증감 연산자는 아예 다른 줄에 쓴다
		
		System.out.println("result: " + result);
		
		n = 10;
		result = 0;
		
		// 후위배치 ++가 = 보다도 후순위임
		// result = 10 + n++;
		
		result = 10 + n;
		++n;
		System.out.println("result: " + result);
		System.out.println("n: " + n);
		
		/*
		 * 
		 * 조건 연산자
		 * 	?:
		 * 	3항 연산자
		 * 	피연산자 A ? 피연산자 B : 피연산자 C
		 * 	A에 들어가는 피연산자는 boolean <- 조건으로 사용
		 * 	B, C 에는 값이 들어감(상수, 변수) <- 연산의 결과값으로 사용
		 * 	A가 참이면 B를 반환, A가 거짓이면 C를 반환
		 */
		n = 10;
		
		System.out.println(n > 0 ? "양수" : "양수아님");
		
		// 나이 입력 -> 18세 이상 ~ 60세 미만
		age = 20;
		
		System.out.println((age >= 18 && age <=60) ? "합격" : "불합격"); // 조건문으로 대체될 때가 많음
		
		// *반환값 B, C 는 항상 동일한 자료형으로*
		// String message = (age >= 18 && age <=60) ? "합격" : "100"; <- 이렇게 쓰면 안됨
		
		// 연산자 우선순위
		// () > 증감 > 산술 > 비교 > 논리 > 대입
		
		// 연산자 연산방향
		// 왼쪽 -> 오른쪽 : 대부분의 연산자
		// 오른쪽 -> 왼쪽 : 대입, 증감
		// 증감연산자는 되도록이면 별도의 문장으로 쓸 것
	}

}
