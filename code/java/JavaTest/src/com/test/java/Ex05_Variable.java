package com.test.java;

public class Ex05_Variable {
	
	public static void main(String[] args) {
		
		//Ex05_Variable.java
		
		//각 자료형(9가지) 별 x 10번씩
		//1. 변수 생성
		//2. 값 대입
		//3. 출력
		
		//예시
		//1. 데이터 선정
		//- 나의 몸무게
		
		//2. 1의 데이터를 저장할 자료형 선택
		//- 형태: 정수
		//- 길이: 60kg ~ 80kg
		//- 결정: byte
		
		//3. 변수 생성(의미있는 변수명) + 값 대입(리터럴) + 출력
		byte myWeight;
		myWeight = 72;
		
		//"제 몸무게는 72kg입니다."
		System.out.println("제 몸무게는 myWeightkg입니다.");
		System.out.println("제 몸무게는 kg입니다." + myWeight);
		System.out.println("제 몸무게는 " + myWeight + "kg입니다.");
		
	}

}
