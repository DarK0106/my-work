package com.test.java;

import java.io.IOException;

public class Ex08_Input {

	public static void main(String[] args) throws IOException {
		
		//Ex08_Input.java
		/*
		
			콘솔 입력
			
			1. System.in.read();
				- System.out.print()
				- 바이트 단위 입력도구
				- 1바이트씩 읽는다.
			
			2. BufferedReader 클래스
			
			3. Scanner 클래스
			
		*/
		
		//요구사항] 사용자에게 문자 1개를 입력받아 화면에 출력하시오.
		
		//제어의 흐름
		//1. 입력 안내 메시지 출력
		//2. 문자 입력
		//3. 문자를 화면에 출력
		
		//1.
		System.out.print("문자 입력: "); //Label
		
		//2. 키보드 입력
		//- 모든 입력값을 숫자로 받는다. > 문자코드값
		int input = System.in.read(); //블럭 > 입력 대기 중
		
		//3. 출력
		System.out.println(input);
		//System.out.printf("%d\r\n", input);
		//System.out.printf("%c\r\n", input);
		
		
		//abc
		//a
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		//win+r > cmd
		//$ taskkill /f /im javaw.exe
		
		
	}
	
}
