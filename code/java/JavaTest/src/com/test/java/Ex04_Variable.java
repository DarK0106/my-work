package com.test.java;

public class Ex04_Variable {
	
	public static void main(String[] args) {
		
		//Ex04_Variable.java
		
		//자료형(8가지) + 변수 생성하기
		
		//정수
		byte b1;
		b1 = 100; //100>상수 > 정수형 상수 > 정수형 리터럴(Literal)
		System.out.println(b1);
		
		//Type mismatch: cannot convert from int to byte
		//b1 = 128;
		//b1 = -129;
		
		/*
		
			Wrapper 클래스, 유틸리티 클래스
			- byte 	  > Byte 클래스
			- short   > Short 클래스
			- int 	  > Integer 클래스
			- long    > Long 클래스
			- float   > Float 클래스
			- double  > Double 클래스
			- boolean > Boolean 클래스
			- char 	  > Character 클래스
		
		*/
		
		System.out.println(Byte.MAX_VALUE); //127
		System.out.println(Byte.MIN_VALUE); //-128
		
		
		short s1;
		s1 = 100;
		System.out.println(s1);
		
		s1 = 128;
		System.out.println(s1);
		
		s1 = Short.MAX_VALUE;
		System.out.println(s1);
		
		int n1;
		n1 = 100;
		System.out.println(n1);
		
		n1 = 1000000000;
		n1 = 1_000_000_000;
		System.out.println(n1);
		
		n1 = Integer.MAX_VALUE;
		System.out.println(n1);
		
		long l1;
		l1 = 100;
		System.out.println(l1);
		
		l1 = 1000000000;
		System.out.println(l1);
		
		//The literal 3000000000 of type int is out of range 
		//l1 = 3000000000;
		//System.out.println(l1);
		
		l1 = 3000000000L; //컴파일러
		System.out.println(l1);
		
		
		//CPU가 한번에 가져오는 크기의 정수 > int 라고 부르자
		//*** 정수형 리터럴(100)은 무조건 int이다.
		
		//- b1의 자료형? byte
		//- n1의 자료형? int
		b1 = 100;
		s1 = 100; //- 두번째 100의 자료형? 
		n1 = 100;
		l1 = 100;
		
		System.out.println(100);
		
		
		
		//실수형
		//*** 실수형 리터럴은 double이다.
		
		float f1;
		f1 = 3.14F; //Type mismatch: cannot convert from double to float
		
		double d1;
		d1 = 6.28; //실수형 리터럴
		
		f1 = 123.123456789012345678901234567890123456789F;
		d1 = 123.123456789012345678901234567890123456789D;
		
		System.out.println(f1); //123.12346
		System.out.println(d1); //123.12345678901235
		
		f1 = 123456789012345678901234567890123456789F;
		d1 = 123456789012345678901234567890123456789D;
		
		//1.2345679E38
		//12345679000000000000000000000000000000
		System.out.println(f1); 
		
		//1.2345678901234568E38
		//12345678901234568000000000000000000000
		System.out.println(d1); 
		
		
		//문자형
		char c1;
		c1 = 'A'; //문자 리터럴
		System.out.println(c1); //A
		
		c1 = '가';
		System.out.println(c1);
		
		c1 = '@';
		System.out.println(c1);
		
		c1 = '1';
		System.out.println(c1);
		
		n1 = 1;
		System.out.println(n1);
		
		//c1 = '홍길동';
		char c2 = '홍';
		char c3 = '길';
		char c4 = '동';
				
		//논리형
		boolean flag;
		flag = true; //논리형 리터럴
		flag = false;
		
		System.out.println(flag);
		
		
		//추가 자료형
		//String, 문자열
		//- 문자 열 > 문자들이 열을 지어 있는 형태 > 문자 집합 > char 값들을 모아놓은 것
		
		//홍길동
		//String 클래스
		String name;
		name = "홍길동"; //문자열 리터럴
		System.out.println(name);
		
		name = ""; //빈문자열, Empty String > 초기화 용도
		
		//c4 = ''; //빈문자(X)
		//c4 = '\0';
		
		
		//주민등록번호 > 숫자?
		//ex) 991230
		int jumin = 991230;
		System.out.println(jumin);
		
		jumin = 030701; //12737
		System.out.println(jumin);
		
		String jumin2;
		jumin2 = "030701";
		System.out.println(jumin2);
		
		//자바 기수법
		//- 10진수
		//- 8진수
		//- 16진수
		//- 2진수
		System.out.println(10); 	//10진수
		System.out.println(010);	//8진수
		System.out.println(0x10); 	//16진수
		System.out.println(0b10);	//2진수
		
		d1 = 1200;
		d1 = 1.2e+3; //1.2 x 10^3
		
		d1 = 0.012;
		d1 = 1.2e-2;
		
	}

}
