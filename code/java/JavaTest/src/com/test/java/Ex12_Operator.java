package com.test.java;

public class Ex12_Operator
{
	
	public static void main(String[] args)
	{
		
		// Ex12_Operator.java
		/*
		 * 
		 * 연산자, Operator
		 *  - 수학 연산자 -> 프로그래밍 연산자도 여기서 유래됨. 거의 똑같음
		 *  - 피연산자를 대상으로 미리 정해진 연산(행동)을 한 후에 그 연산의 결과를 반환하는 역할
		 *  - 주로 기호를 사용 + 단어도 사용
		 *  
		 *  1. 문장, Statement
		 *  2. 표현식, Expression
		 *  3. 연산자, Operator
		 *  4. 피연산자, Operand
		 *  5. 연산자 우선순위
		 *  6. 연산자 연산방향
		 *  
		 *  1. 문장, Statement
		 *   - 1개 이상의 표현식이 모여서 문장을 만든다.
		 *   ex) int sum = 10 + 20;
		 *   
		 *  2. 표현식, Expression
		 *  - 문장을 구성하는 최소 단위
		 *  - 값을 나타내는 의미
		 *  ex) int sum
		 *  	10 + 20
		 *  	sum = 30
		 *  	10
		 *  	20 
		 *  어떤 구문을 툭 떼어냈는데 그 자체로 의미가 되면 표현식
		 *  
		 *  3. 연산자, Operator
		 *  ex) int sum = 10 + 20;
		 *  	- =
		 *  	- +
		 *  
		 *  4. 피연산자, Operand
		 *  ex) int sum = 10 + 20;
		 *  	- +: 10, 20 이 +의 피연산자
		 *  	- =: sum, 30 이 =의 피연산자
		 *  
		 *  5. 연산자 우선순위
		 *  - 하나의 문장 속에 속해있는 모든 연산자들 중 누구를 먼저 실행해야 하는지 정해져 있는 순서
		 *  ex) 1 + 2 * 3 = ?
		 *  
		 *  6. 연산자 연산방향 
		 *  - 하나의 문장에 속해있는 연산자들 중 같은 우선순위를 가지는 연산자들끼리의 실행 순서
		 *  ex) 1 + 2 + 3 = ?
		 *  // 컴퓨터는 앞에걸 먼저 해야하냐 뒤에걸 먼저 해야하냐 그걸 명확하게 지정해줘야함
		 *  // 예시에선 무조건 앞에거 먼저함
		 *  // 대부분의 연산방향은 왼쪽에서 오른쪽
		 *  // 피연산자가 두개인 + 같은 애들을 이항연산자
		 *  // + 가 연산을 끝내고 나면 결과값을 반환하고 사라짐
		 *  
		 *  int sum = 1+ 2+ 3;
		 *  int sum = 3 + 3; 실제로 이렇게 동작한다는건 아니고 절차가 대충 이렇다는거
		 *  int sum = 6;
		 *  int sum -> sum 생성
		 *  sum = 6;
		 *  ; = 도 sum에 6 넣었으니까 사라짐 그래서 ; 로 끝남
		 *  
		 *  연산자 종류
		 *  1. 행동(목적)
		 *  	a. 산술 연산자
		 *  	b. 비교 연산자
		 *  	c. 논리 연산자
		 *  	d. 대입 연산자
		 *  	e. 증감 연산자
		 *  	f. 조건 연산자
		 *  	g. 비트 연산자
		 *  	i. 문자열 연산자
		 *  
		 *  2. 형태(피연산자 개수)
		 *  	a. 1항 연산자, 또는 단항 연산자
		 *  	b. 2항 연산자
		 *  	c. 3항 연산자
		 *  
		 *  // a. 산술 연산자
		 *  // +, -, *, /, %(mod(modulo), 나머지 연산자. 나머지 구해주는 연산자) 5개
		 *  // 2항 연산자
		 *  // 피연산자는 반드시 숫자형(정수, 실수)
		 *  
		 */
		
		int a = 10;
		int b = 3;
		
		// 10 + 3 = 13
		System.out.printf("%d + %d = %d\r\n", a, b, a + b);
		System.out.printf("%d - %d = %d\r\n", a, b, a - b);
		System.out.printf("%d * %d = %d\r\n", a, b, a * b);
		System.out.printf("%d / %d = %d\r\n", a, b, a / b);
		// System.out.printf("%d % %d = %d\r\n", a, b, a % b); 이렇게 하면 오류남 %가 의미 있는 형식문자라고 생각하기 때문
		System.out.printf("%d %% %d = %d\r\n", a, b, a % b); // 그래서 %% 이렇게 써야함
		
		/*
		 * Exception in thread "main" java.util.IllegalFormatFlagsException: Flags = ' '
	at java.base/java.util.Formatter$FormatSpecifier.checkText(Formatter.java:3317)
	at java.base/java.util.Formatter$FormatSpecifier.<init>(Formatter.java:3007)
	at java.base/java.util.Formatter.parse(Formatter.java:2849)
	at java.base/java.util.Formatter.format(Formatter.java:2774)
	at java.base/java.io.PrintStream.implFormat(PrintStream.java:1367)
	at java.base/java.io.PrintStream.format(PrintStream.java:1346)
	at java.base/java.io.PrintStream.printf(PrintStream.java:1245)
	at com.test.java.Ex12_Operator.main(Ex12_Operator.java:98) <- 내가 작업하고 있는 파일의 98번째 줄에서 오류가 발생했구나

		 */
		
		double c = 10;
		double d= 3;
		
		System.out.printf("%f + %f = %f\r\n", c, d, c + d);
		System.out.printf("%f - %f = %f\r\n", c, d, c - d);
		System.out.printf("%f * %f = %f\r\n", c, d, c * d);
		System.out.printf("%f / %f = %f\r\n", c, d, c / d);
		System.out.printf("%f %% %f = %f\r\n", c, d, c % d);
		
		System.out.println(10); // 정수
		System.out.println(3.14); // 실수
		System.out.println(10F); // 생긴건 정순데 나는 실수타입으로 쓰고 싶어요
		System.out.println(10D); // 실수 (double)
		System.out.println(10.0); // 실수 (double)
		System.out.println(10 / 3); // 3 
		System.out.println(10.0 / 3.0); // 3.3333..
		
		// 정수 / 정수 = 정수
		// 실수 / 실수 = 실수
		// 정수 / 실수 = 실수
		// 실수 / 정수 = 실수
		
		// *중요* 모든 산술연산자에서의 결과값의 자료형은 두개의 피연산자 자료형 중 크기가 더 큰 자료형으로 반환된다.
		// *예외* int 보다 작은 형으로만 되어 있는 연산의 결과는 무조건 int로 반환한다
		// byte + byte = int
		// short + short = int
		// byte + short = int
		
		System.out.println(10 / 3); // int / int = int
		System.out.println(10.0 / 3.0); // double / double = double
		System.out.println(10 / 3.0); // int / double = double
		System.out.println(10.0 / 3); // double / int = double
		
		int e = 1000;
		byte f = 10;
		
		System.out.println(e + f); // 이 결과값에 대한 자료형은 뭘까? int + byte = int
		// byte엔 127 넘는 값을 못 담아서 결과값의 자료형은 int가 된다
		// 일단 더 큰 자료형으로 담아야 문제가 생길 일이 줄어들기 때문임
		
		int g = 1000000000;
		int h = 2000000000;
		
		System.out.println(g + h); // int + int = int <- 둘 중에 큰 자료형이 되기 때문에 결과값의 자료형은 int가 됨
		// 30억 됐는데 int는 30억 못 담아서 이상한 값이 나옴 에러도 안 나서 왜 그런지 찾기 힘듬
		// 위로도 오버플로우 나고 아래(음수)로도 언더플로우 발생 가능
		
		System.out.println((long)g + h); // long + int = long <- 명시적으로 형변환해주면 30억 제대로 나옴
		
		byte j = 10;
		byte k = 20;
		
		// byte + byte = byte (X)
		// byte + byte = int (O)
		System.out.println(j + k); // byte + byte = byte <- 사실 이 전제가 틀림
		
		
		// Type mismatch: cannot convert from int to byte
		// byte l = j + k;
		
		// byte + byte = int 가 된다
		// 이건 그냥 특별한 경우임
		
		byte l = (byte)(j + k); // byte 로 형변환 하려면 이렇게 써야함
		System.out.println(l);
		
		// int m = j + k; // 127 넘어가면 오버플로우 발생하니까 미리 int로 선언해두는게 좋음
		
		// % 나머지
		System.out.println(100 % 3);
		System.out.println(100 % 4);
		System.out.println(100 % 5);
		System.out.println(100 % 6);
		
		// 달력 만들기 -> 2025년 12월 달력을 만들어본다고 치면
		// 1. 그 달의 마지막 날짜가 언제인지
		// 2. 그 달의 1일이 무슨 요일인지 알아야 함 2025년 12월 1일은 월요일
	}

}
