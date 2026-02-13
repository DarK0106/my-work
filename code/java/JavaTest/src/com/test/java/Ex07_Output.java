package com.test.java;

public class Ex07_Output {
	
	public static void main(String[] args) {
		
		//Ex07_Output.java
		/*
			
			콘솔 입출력, Console Input Ouput > IO
			- 기본 입력 장치: 키보드
			- 기본 출력 장치: 모니터
			
			
			콘솔 출력
			- 클래스.필드.메서드(인수);
			
			1. System.out.println(값);
				- println 메서드
				- print line > 줄단위로 출력한다.
				             > 값을 출력한 뒤 엔터를 친다.
				
			2. System.out.print(값);
				- print 메서드
				- 값을 출력한 뒤 엔터를 안친다.
			
			3. System.out.printf(값);
				- printf 메서드
				- 형식 문자
					a. %s > String
					b. %d > Decimal(byte, short, int, long)
					c. %f > Float(float, double)
					d. %b > Boolean
					e. %c > Character
					
		*/
		
//		System.out.println(100);
//		System.out.println(200);
//		System.out.println(300);
		
//		System.out.print(100);
//		System.out.print(200);
//		System.out.print(300);
		
		
//		System.out.println(100);
//		System.out.println(3.14);
//		System.out.println('A');
//		System.out.println(true);
//		System.out.println("홍길동");
		
		
		//성적표 출력하기
		String name1 = "홍길동";
		int kor1 = 100;
		int eng1 = 90;
		int math1 = 80;
		
		String name2 = "아무개";
		int kor2 = 95;
		int eng2 = 88;
		int math2 = 79;
		
		//Win + .
		System.out.println("==============================");
		System.out.println("           🏫성적표");
		System.out.println("==============================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		
//		System.out.print(name1);
//		System.out.print("\t");
//		System.out.print(kor1 + "\t");
//		System.out.print(eng1 + "\t");
//		//System.out.print(math1 + "\r\n");
//		System.out.println(math1);
//		
//		System.out.println(name2 + "\t" + kor2 + "\t" + eng2 + "\t" + math2);
		
		System.out.printf("%s\t%6d\t%6d\t%6d\r\n"
							, name1, kor1, eng1, math1);
		System.out.printf("%s\t%6d\t%6d\t%6d\r\n"
							, name2, kor2, eng2, math2);
		
		//System.out.print();
		System.out.println(); //아무것도 안찍고 + 엔터 친다.
		System.out.println(); //빈줄
		System.out.println(); //엔터치기
		
		
 		
		//printf()
		//- print format
		//- 가독성 높음
		//- 조작성 용이
		
		//요구사항] "안녕하세요. ?님" > 출력하시오.
		String name = "홍길동"; //사용자 입력
		
		System.out.println("안녕하세요. " + name + "님");
		System.out.printf("안녕하세요. %s님\r\n", name);
		
		//요구사항] "안녕하세요. 홍길동님. 안녕히가세요. 홍길동님. 또오세요. 홍길동님"
		System.out.println("안녕하세요. " + name + "님. 안녕히가세요. " + name + "님. 또오세요. " + name + "님");
		
		System.out.printf("안녕하세요. %s님. 안녕히가세요. %s님. 또오세요. %s님\r\n", name, name, name);
		
		
		
		//printf 확장 기능
		//1. %숫자s, %숫자d, %숫자f, %숫자b, %숫자c
		//- 출력할 너비를 지정
		//- 탭문자와 같이 사용
		//- +: 우측 정렬
		//- -: 좌측 정렬
		
		int num = 123;
		
		System.out.printf("[%d]\r\n", num);
		System.out.printf("[%5d]\r\n", num);
		System.out.printf("[%-5d]\r\n", num);
		System.out.println();
		
		//2. %.숫자f
		//- 소수점 이하 자릿수 지정
		//- %f: 소수이하 6자리 출력
		double num2 = 3.15;
		
		System.out.println(num2);
		System.out.printf("%f\r\n", num2);
		System.out.printf("%.2f\r\n", num2);
		System.out.printf("%.1f\r\n", num2);
		System.out.printf("%.0f\r\n", num2);
		System.out.println();
		
		//3. %,d, %,f
		//- 숫자 + ,
		//- 자릿수 표기(천단위 표기 - 3자리)
		int price = 1234567;
		System.out.printf("금액: %d원\r\n", price);
		System.out.printf("금액: %,d원\r\n", price);
		System.out.println();
		
		
		//천단위 + 출력너비지정(20자리,우측) + 소수이하자릿수(2자리)
		double num3 = 1234567.890123;
		
		System.out.printf("[%f]\r\n", num3);
		System.out.printf("[%,20.2f]\r\n", num3);
		
		
	}

}
