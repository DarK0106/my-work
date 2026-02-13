package com.test.java;

public class Ex15_Method
{

	public static void main(String[] args) // <- 메서드
	{
		// Ex15_Method.java
		/*
		 * 
		 * 메서드, Method <- 자바에서 이렇게 불림
		 * - 함수(Function), 프로시저(Procedure), 서브루틴(SubRoutine) 등으로도 불림
		 * 
		 * - 메서드는 코드의 집합 <- 같은 목적을 가진 코드의 집합
		 * - *중요* 코드 재사용의 기본 단위중의 하나
		 * 메서드와 메서드 끼리는 형제 관계
		 * 메서드 안에 메서드를 선언하면 안됨
		 * 클래스 밖에 메서드를 선언하면 안됨
		 * 클래스와 메서드는 부모 자식 관계
		 * 
		 * 메서드 사용
		 * 1. 메서드 선언(정의)
		 * 2. 메서드 호출(사용)
		 */
		
		// 요구사항) 유저가 "안녕하세요."라는 문장을 화면에 5번 출력해달라는 요청
		// 수정사항) "반갑습니다." 로 수정
		
		// Case A
		// 가장 단순한 방법
		// 하면 안되긴 하는데 할때도 있긴함(귀찮아서)
		// 하드 코딩
		// 재사용성 0%
		
		printHello();
		
		// 메서드 찾기 쉬운 방법, printNumber(); 의 printNumber 클릭하고 F3
		// 오른쪽 Outline 창, 없으면 Window -> show view, 실수로 창을 닫아버리면 저기서 다시 열면 됨
		// Outline 에서 메서드 누르면 바로 이동함
		// Ctrl + 메서드 이름 클릭 -> Open Declaration, F3이랑 똑같은거
		
		printNumber();
		
		// 메서드 호출 <- 이름을 부르면 된다, 즉 실행하라는 뜻
		hello();
		hello();
		hello();
		hello();
		hello();
	}

	// 드래그로 코드 지정해서 우클릭, Refactor -> Extract Method 해보기
	public static void printHello()
	{
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
	}
	
	
	// Case B
			// -메서드 사용
			//  메서드 호출 <- 이름을 부르면 된다, 즉 실행하라는 뜻
			/*
			 *
			 * 메서드 선언 구문
			 * public: 접근지정자
			 * static: 정적키워드
			 * void: 반환타입
			 * hello: 메서드의 이름
			 * (): 인자(인수) 리스트
			 * 
			 * 1. 메서드 헤더(header), 서명(Signature) 로 불림
			 * public static void hello()
			 * 
			 * 2. 메서드 몸통(Body), 구현부(= 실행부)
			 * {
			 * 		코드;
			 * }
			 * 
			 * 메서드의 사용 이유(목적)
			 * 1. 코드 재사용(생산성 향상, 유지보수성 향상)
			 */
	
	public static void hello()
	{
		System.out.println("반갑습니다.");
		
		// 메서드는 선언을 한 다음에 호출을 하지 않으면 실행되지 않음
	}
	
	// 변수 이름이나 메서드 이름은 캐멀표기법을 사용
	// 합성어일때 첫글자는 소문자 ~ 다음은 대문자
	public static void printNumber()
	{
		System.out.println("하나");
		System.out.println("둘");
		System.out.println("셋");
		System.out.println("넷");
		System.out.println("다섯");
		System.out.println("여섯");
		System.out.println("일곱");
		System.out.println("여덟");
		System.out.println("아홉");
		System.out.println("열");
	}
	
}
