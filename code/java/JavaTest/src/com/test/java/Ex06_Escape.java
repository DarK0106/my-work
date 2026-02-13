package com.test.java;

public class Ex06_Escape {
	
	public static void main(String[] args) {
		
		//Ex06_Escape.java
		
		//특수 문자 > Escape Sequence
		//- 컴파일러가 번역을 할 때 소스 상의 문자를 그대로 출력하지 않고, 미리 약속된 표현으로 바꿔서 출력하는 요소
		
		//1. \n
		//- new line, line feed
		//- 개행문자(엔터)
		
		char c1 = '\n';
		String s1 = "\n";
		
		//요구사항] "안녕하세요. 홍길동입니다." > 출력하시오.
		//수정사항] "안녕하세요."와 "홍길동입니다." > 각각 다른 줄
		
		//** 문자열 리터럴("")내에서 개행을 할 수 없다.
		String msg = "안녕하세요.\n홍길동입니다.";
		System.out.println(msg);
		
		
		//2. \r
		//- carriage return
		
		//엔터 = \r + \n
		//- 윈도우즈: \r\n
		//- MacOS: \r > \n
		//- Linux: \n
		
		msg = "안녕하세요.\r홍길동";
		System.out.println(msg);
		
		
		System.out.println("하나\r\n둘\r\n셋");
		System.out.println("하나\n둘\n셋");
		
		
		//3. \t
		//- 탭문자
		//- 탭이 뭐에요? > 4칸씩 띄어쓰기하는거
		//- 열 맞추기(서식)
		
		msg = "하나	둘	셋"; //비권장
		System.out.println(msg);
		
		msg = "하나\t둘\t셋";
		System.out.println(msg);
		
		
		//4. \b
		//- 백스페이스
		msg = "홍길동\b입니다."; //홍길입니다.
		System.out.println(msg);
		
		
		//5. \", \', \\
		//- 이미 역할이 있는 문자들을 역할을 없애는 작업
		
		//요구사항] 홍길동: "안녕하세요." 라고 인사한다.
		msg = "홍길동: \"안녕하세요.\" 라고 인사한다.";
		System.out.println(msg);
		
		//요구사항] 수업 폴더의 경로를 출력하시오.
		//- C:\code\java
		
		//Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		System.out.println("C:\\code\\java");
				
	}

}
