package com.test.java;

public class Ex03_Variable {

	//개발툴 > 자동 완성, 코드 조각, 템플릿, 인텔리스, 코드 어스턴스
	
	//단축키: Ctrl + Space
	public static void main(String[] args) {
		
		/*

			자료형 + 변수
			
			변수, Variable
			- 변하는 수(숫자X, 값O)
			- 개발자가 명령어를 사용해서 메모리에 할당받은 공간
						
			상수, Constant
			- 변하지 않는 수
		
		
			1. 변수 생성하기, 선언하기
			- 자료형 변수명;
			
			2. 변수 초기화
			- 변수명 = 값;
			- =(대입,할당 연산자)
			
			3. 변수 사용(호출)
			- 출력, 연산, 조건, 기록, 전송 등..
			- 변수명
			
			4. 변수 치환
			- 변수명 = 값;
		
		*/
		
		//변수 생성
		byte 국어;
		
		//변수 초기화
		국어 = 100;
		
		//변수 호출 + 값 출력
		System.out.println(국어); //A > 100
		
		//정정 기간
		국어 = 97; //덮어쓰기
		
		System.out.println(국어); //B > 97
		
		
		System.out.println(100); //C
		System.out.println(100); //D
		
		

		//영어 점수
		byte 영어;
		영어 = 95;
		System.out.println(영어);
		
		//수학 점수
		byte a;
		a = 90;
		System.out.println(a);
		
		//과학 점수
		System.out.println(80); //비권장
		
		
		//변수명 만들 때 규칙(+ 앞으로 무언가의 식별자를 만들 때)
		//1. 영문자 + 숫자 + '_'를 사용한다. > 관습
		//2. 숫자로 시작 불가능
		//3. 예약어(키워드) 사용 불가능
		//4. 의미있게(*******************)
		
		byte eng;
		byte eng2;
		byte eng_3;
		//byte 4eng;
		byte _4eng;
		
		//byte byte;
		//byte if;
		
		
		byte english_score;
		byte eng_scr;
		byte e;
		
		
		//안녕하세요. 홍길동입니다.
		
		//문장(Statement)
		//- 명령어 1줄
		//- ; > 문장종결자
		System.out.println(영어);
		
		
		
		//변수 선언하는 방식 > 구체적
		byte b1; 	//변수 선언
		b1 = 100; 	//초기화
		
		//코드 재사용(***)
		byte b2 = 100;	//선언 + 초기화
		
		byte b3;
		byte b4;
		
		byte b5, b6; //그룹 선언
		
		byte b7, b8 = 100, b9 = 100, b10, b11 = 100;
		
		
		//지도 > 좌표(x,y)
		byte x; //우리집 x좌표
		byte y; //우리집 y좌표
		
		byte x2, y2; //친구집 x좌표, 친구집 y좌표		
		
		byte x3, //친구집 x좌표 
			 y3; //친구집 y좌표 
		
		
		byte m;
		
		m = 100;
		
		//*************************** 에러 메시지 보기(정독)
		//The local variable m may not have been initialized
		
		//** 변수는 초기화를 하지 않으면 호출(사용) 불가능
		System.out.println(m);
		
		
		//Duplicate local variable m
		//- 변수명은 같으면 안된다.
		//- 동일한 이름의 변수는 2개 이상 존재할 수 없다.
		
		//byte m;
		//m = 110;
		
		
		//식별자 명명법 패턴
		//1. 헝가리언 표기법
		//2. 파스칼 표기법
		//3. 캐멀 표기법
		//4. 스네이크 표기법
		//5. 케밥 표기법
		
		//1. 헝가리언 표기법
		//- 식별자를 만들 때 식별자의 접두어로 자료형을 표시하는 방법
		//- 사용) 인터페이스명
		byte age;
		byte byteAge;
		byte bAge;
		byte byte_age;
		int i_num;
		age = 100;
		
		//2. 파스칼 표기법
		//- 식별자의 첫문자를 대문자 표기 + 나머지 문자는 소문자 표기
		//- 합성어 > 각 단어의 첫문자를 대문자 표기
		//- 사용) 클래스명
		byte weight;
		byte Weight;
		
		byte myweight;
		byte MyWeight;
		
		//3. 캐멀 표기법
		//- 식별자의 첫문자를 소문자 표기 + 나머지 문자는 소문자 표기
		//- 합성어 > 나머지 단어의 첫문자를 대문자 표기
		//- 사용) 메서드명, 변수명
		byte myheight;
		byte myHeight;		
		
		//byte english_score;
		byte englishScore;
		
		
		//4. 스네이크 표기법
		//- 전부 소문자로 표기
		//- 합성어 > 각 단어를 '_'로 연결
		//- 사용) 마음대로
		//byte english_score;
		
		//5. 케밥 표기법
		//- 전부 소문자로 표기
		//- 합성어 > 각 단어를 '-'로 연결
		//- 사용) 자바에서는 사용 불가
		//- 사용) HTML, CSS
		//byte english-score;
		
	}
	
}