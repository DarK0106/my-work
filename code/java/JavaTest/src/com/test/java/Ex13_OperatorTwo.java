package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13_OperatorTwo
{
	
	public static void main(String[] args) throws IOException
	{
		// Ex13_OperatorTwo.java
		/*
		 * 비교 연산자
		 * -> >, >=, <, <=, ==(= 두개, equals), !=(느낌표=, not equals)
		 * - 2항 연산자
		 * - 피연산자들의 우위 / 동등 비교
		 * - 피연산자는 숫자형을 가진다.
		 * - 연산의 결과가 boolean 이다.
		 */
		
		int a = 10;
		int b = 3;
		
		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);
		
		// 요구사항) 사용자로부터 나이를 입력받고, 19세 이상이면 통과, 아니라면 거절
		// Ctrl + Shift + O
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("나이 입력: ");
		
		String input = "20"; // reader.readLine(); // "20"
		
		// System.out.println(input >= 18);
		
		int age = Integer.parseInt(input); // "20" -> 20 문자열을 진짜 integer로 바꿔줌
		
		System.out.println(age >= 18); // 가독성이 좋은 코드
		System.out.println(age <= 18); // 가독성이 나쁘고 나중에 수정하기도 불편한 나쁜 코드
		
		// 문자열 연산자
		// 2항 연산자
		// 문자열과 문자열을 합치는 일을 한다
		
		String s1 = "하나";
		String s2 = "둘";
		
		System.out.println(s1 + s2); // 사칙연산의 + 가 아니라 문자열 연산자인 + 이다
		System.out.println("문자열" + "문자열");
		System.out.println("문자열" + 123); // 앞에거가 문자열이니 사칙연산을 할 순 없으니까 123도 문자열로 취급함
		// 한놈이라도 문자열이면 나머지도 문자열로 취급한다
		System.out.println("문자열" + true);
		
		// ==, != 은 모든 자료형에서 사용가능
		// 문자열에서도 사용 가능
		
		s1 = "강아지";
		s2 = "고양이";
		
		// System.out.println(s1 > s2); 말이 안 됨
		System.out.println(s1 == s2); // 절대 이렇게 사용 금지 !!
		System.out.println(s1 != s2); // 절대 이렇게 사용 금지 !!
		
		String name1 = "홍길동";
		String name2 = "홍길동"; // 홍길동을 또 만들진 않고 이미 있는 홍길동을 재사용함 <- 참조형 특징
		String name3 = "홍"; // 홍은 새로 만듬, 당연히 주소값도 다름 name3 에 홍의 주소값이 저장됨
		name3 = name3 + "길동"; // 홍 이랑 길동 더한 홍길동은 또 다른 곳에 생김, name3에 저장되어있던 주소값은 새로 만들어진 홍길동의 주소값으로 바뀜
		
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(name3);
		
		System.out.println(name1 == name2); // 실제 데이터를 비교하는게 아니고 주소를 비교하는것, 주소는 똑같으니 true가 출력됨
		System.out.println(name1 == name3); // 그래서 보기엔 똑같은 홍길동인데 주소가 달라서 false로 나옴
		
		// *** 위의 이유 때문에 문자열의 비교는 == 과 != 는 절대 사용 금지
		// equals() 라는 메서드가 따로 있음 이걸 써야함
		
		System.out.println(name1.equals(name2)); // name1 == name2
		System.out.println(name1.equals(name3)); // name1 == name3
		
		// 값형
		// 값형은 메모리에 생성되는 공간의 크기가 정해져 있음 int a가 1이든 10000이든 똑같이 4byte
		// 값형은 stack에 생성됨
		int num1 = 10;
		boolean f1 = true;
		char c1 = 'A';
		
		// 참조형
		// 참조형은 공간의 크기가 정해져 있지 않음, 뭐가 들어가는가에 따라 다름
		// 참조형은 변수는 Stack에 값은 Heap에, Heap에도 주소값이 있음, 그래서 Stack에 있는 변수에 그 주소값이 저장됨
		// Stack에 있는 변수 d1 에 있는 주소값을 보고 Heap으로 가서 강아지 라는 문자열을 찾아냄 그래서 참조형이라고 부름
		String d1 = "강아지";
		// 값형이랑 참조형은 메모리에 생성되는 방식이 다름
		// 문자열은 크기라는게 정해져 있지 않다
		// 자바는 한 글자당 2byte
		String d2 = "안녕하세요";
	}

}
