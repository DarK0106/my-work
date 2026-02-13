package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09_BufferedReader {
	
	public static void main(String[] args) throws IOException {
		
		//Ex09_BufferedReader.java
		
		//BufferedReader 클래스
		//- 문자 단위 입력 도구(한글 가능)
		//- 문장 입력 도구
		
		//요구사항] 사용자로부터 문자 1개 입력 > 출력
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
//		System.out.print("입력: ");
		
		//int code = System.in.read();
//		int code = reader.read();
//		
//		System.out.println(code);
//		System.out.printf("%c\r\n", code);
		
		//- A(65) ~ Z(90)
		//- a(97) ~ z(122)
		//- 0(48) ~ 9(57)
		//- \r(13), \n(10), 스페이스(32), 탭(9)
		//- 가(44032) ~ 힣(55203)
		
		
		//- reader.read(): 문자 1개를 읽어온다.
		//- reader.readLine(): 문장을 읽어온다.(엔터를 만나기전까지)
		
		//"abc"
		//String input = reader.readLine();
		//System.out.println(input);
		
		
			
		//요구사항] 숫자 2개 입력 > 두 수의 합을 구하시오.
		//- 첫번째 숫자: 10
		System.out.print("첫번째 숫자: ");
		String input1 = reader.readLine(); //10 > "10"
		
		System.out.print("두번째 숫자: ");
		String input2 = reader.readLine(); //20 > "20"
		
		//10 > "10" > 10
		//문자열 > (변환) > 숫자
		//- Integer.parseInt("10") > 10  *****
		//- Byte.parseByte("10")
		//- Short.parseShort("10")
		//- Long.parseLong("10")
		//- Float.parseFloat("3.14")
		//- Double.parseDouble("3.14")  *****
		//- Boolean.parseBoolean("true")
		
		int num1 = Integer.parseInt(input1); //"10" > 10
		int num2 = Integer.parseInt(input2); //"20" > 20
		
		System.out.println(input1 + input2);
		System.out.println(num1 + num2);
		
		
		
		
		
	}

}
