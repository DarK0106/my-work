package com.test.java;

import java.util.Scanner;

public class Ex29_String
{
	public static void main(String[] args)
	{
		// Ex29_String.java
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		// m10();
		// m11();
		// m12();
		m13();
	}

	private static void m13()
	{
		// 문자열 분리
		// 하나의 문자열을 쪼개서 여러개의 문자열로 만들 수 있다
		// - String[] split(String delimiter) <- 배열을 반환한다
		
		String txt = "홍길동,아무개,강아지,고양이,병아리";
		
		String [] list = txt.split(","); // 자르는 역할을 다 하고 구분자는 최종 결과물에선 사라진다
		
		for (int i = 0; i < list.length; i++)
		{
			System.out.println(i + ":" + list[i]);
		}
		
	}

	private static void m12()
	{
		// 문자열 치환(바꾸기)
		// - String replace(char old, char new)
		// - String replace(String old, String new)
		
		String txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 홍길동."; // 홍길동이 아니라 다른 사람 이름으로 바꿔야 한다면?
		
		System.out.println(txt.replace("홍길동", "호날두"));
		System.out.println(txt.replace("테스트", "호날두")); // 찾으려는 대상이 없으면 에러 안 나고 원본 그대로 출력
		System.out.println(txt.replace("홍길동", "크리스티아누 호날두"));
		System.out.println(txt.replace("홍길동", "메시"));
		System.out.println(txt.replace("홍길동", ""));
		
		// 금지어 필터
		String content = "게시판입니다. 안녕~ 바보";
		String stop = "바보";
		
		// System.out.println(content.indexOf(stop) > -1);
		// System.out.println(content.contains(stop));
		
		System.out.println(content.replace(stop,"**"));
		
		txt = "     하나     둘     셋     ";
		System.out.println(txt.trim()); // trim 으로는 공백을 다 제거할 수 없었음
		System.out.println(txt.replace(" ", "")); // 공백을 빈 문자열로 바꾼다
		
		content = "오늘은 메서드 수업을 진행합니다. 시작~";
		String word = " 메서드 수업"; // 검색하고 싶은 키워드
		
		// 메서드 수업을 메서드수업 으로 검색하면 안나오는 문제가 발생
		// 검색을 할 때 띄어쓰기를 무시하고 검색 -> 정확도가 약간 떨어지지만 훨씬 더 많은 검색 결과
		if (content.replace(" ", "").contains(word.replace(" ", "")))
		{
			System.out.println("결과O");
		}
		else
		{
			System.out.println("결과X");
		}
		
	}

	private static void m11()
	{
		// 문자열 검색
		// - indexOf()
		// - lastIndexOf()
		// - startsWith()
		// - endsWith()
		// - boolean contains(String s)
		
		String txt = "안녕하세요. 홍길동입니다.";
		System.out.println(txt.indexOf("홍길동") > -1);
		System.out.println(txt.contains("홍길동"));
	}

	private static void m10()
	{
		// 문자 추출
		// char charAt(int index)
		
		// 문자열 추출
		// String substring(int beginIndex, int endIndex)
		// 범위 추출
		//beginIndex <- inclusive(포함)
		// endIndex <- exclusive(미포함)
		
		String txt = "가나다라마바사아자차카타파하";
		System.out.println(txt.substring(4, 7));
		System.out.println(txt.substring(4));
		System.out.println(txt.substring(5, 6)); // "바"(String)
		System.out.println(txt.charAt(5)); // '바'(char) -> 문자코드값
		System.out.println();
		
		// 주민번호
		String jumin = "990108-1234567";
		
		// 성별이 뭘까?
		System.out.println(jumin.charAt(7) == '1' ? "남자" : "여자");
		System.out.println(jumin.substring(7, 8).equals("1") ? "남자" : "여자");
		
		// 몇년생인가 ?
		// charAt은 한글자 뽑아낼때만 좋다
		// System.out.println(jumin.charAt(0) + jumin.charAt(1)); // char + char 는 문자 코드값 끼리 더해버린다
		
		// 두 글자 이상으로 추출할 땐 substring이 좋다 
		System.out.println(jumin.substring(0, 2)); // "99"
		
		// 몇월생?
		System.out.println(jumin.substring(2, 4)); // 1월생
		
		// 몇일생?
		System.out.println(jumin.substring(4, 6)); // 8일생
		
		// 파일 경로
		String path = "C:\\code\\java\\JavaTest\\Ex29_String.java";
		
		// 1. 파일 이름만 알고싶다. 파일명 추출 -> Ex29_String.java
		int index = path.lastIndexOf("\\");
		String filename = path.substring(index + 1);
		System.out.println("파일명: " + filename);
		
		// 2. 파일명 추출 -> 확장자 없는 순수 파일명 -> Ex29_String
		index = filename.lastIndexOf(".");
		String filenameWithoutExtension = filename.substring(0, index);
		System.out.println("순수 파일명: " + filenameWithoutExtension);
		
		// 3. 확장자만 추출하고 싶다 -> .java
		String extension = filename.substring(index);
		System.out.println("확장자: " + extension);
		
	}

	private static void m9()
	{
		// 패턴 검색
		// 리턴값이 boolean 
		// boolean StartsWith(String Word)
		// boolean endsWith(String Word)
		
		String name = "홍길동";
		
		// 너 '홍'씨 맞아? -> 네 / 아니오
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf('홍') == 0);
		
		System.out.println(name.startsWith("홍"));
		System.out.println();
		
		// 이름이 '동'이라는 글자로 끝납니까?
		System.out.println(name.charAt(name.length()-1) == '동');
		System.out.println(name.indexOf("동") == name.length() - 1);
		
		System.out.println(name.endsWith("동"));
		System.out.println();
		
		// 사용자가 게시판에 파일 업로드를 하는 상황이다 -> 반드시 .java 파일만 가능
		String filename = "Ex03.JAVA";
		// String filename = "Ex02_Console.java";
		// System.out.println(filename.lastIndexOf(".java") == filename.length() - 5);
		System.out.println(filename.toLowerCase().endsWith(".java"));
	}

	private static void m8()
	{
		// 대소문자 변환
		// - String toUpperCase()
		// - String toLowerCase()
		
		String word = "java"; // 사용자가 입력한 단어
		System.out.println(word);
		System.out.println(word.toUpperCase());
		System.out.println(word.toLowerCase());
		
		
		//대소문자 구분
		// 구분하면 정확도 높음, 검색율이 낮음
		// 구분하지 않으면
		
		String content = "오늘 수업은 Java 입니다.";
		
		// 메서드 체이닝
		// 변수.메서드().메서드()
		
		if (content.toUpperCase().indexOf(word.toUpperCase()) > -1)
		{
			System.out.println("O");
		}
		else
		{
			System.out.println("X");
		}
		
	}

	private static void m7()
	{
		// 게시판에 글쓰기를 하는 사람 -> 금지어가 있다
		
		String stop = "바보"; // 금지어
		String content = "안녕하세요. 저는 자바를 배우는 학생입니다."; // 게시판에 쓴 글 내용
		
		System.out.println(content.indexOf(stop));
		
		if(content.indexOf(stop) > -1)
		{
			System.out.println("금지어 발견!!");
		}
		else
		{
			System.out.println("글쓰기 완료!!");
		}
		
		content = "안녕하세요. 저는 자바를 배우는 학생입니다."; // 게시판에 쓴 글 내용
		String[] stopWords = { "바보", "멍청이", "메롱" }; // 이번엔 금지어가 여러개다
		
		for (int i = 0; i < stopWords.length; i++)
		{
			if (content.indexOf(stopWords[i]) > -1)
			{
				System.out.println("금지어 발견 !!");
				break;
			}
		}
		
		String jumin = "990108-1234567";
		System.out.println(jumin.charAt(6) == '-');
		System.out.println(jumin.indexOf('-') == 6);
		
	}

	private static void m6()
	{
		// 검색해주는 기능
		// - int indexOf(char c)
		// - int indexOf(String s)
		// - int indexOf(char c, int beginIndex)
		// - int indexOf(String s,int beginIndex)
		// Ctrl + F 기능을 이걸로 만듬
		// 없는 문자는 -1로 반환하기로 정했음. 못찾았다는 의미. 만약에 양수로 반환하면 사용자가 헷갈림
		
		// - int lastindexOf(char c)
		// - int lastindexOf(String s)
		// - int lastindexOf(char c, int beginIndex)
		// - int lastindexOf(String s,int beginIndex)
		
		String txt = " 안녕하세요. 홍길동입니다.";
		int index = -1; // 대부분 -1로 초기화함
		
		txt.indexOf("홍길동"); // 7
		System.out.println(index);
		
		txt.indexOf("홍길동", index + 3); // 22
		System.out.println(index);
		
		txt.indexOf("홍길동", index + 3); // 38
		System.out.println(index);
		System.out.println();
		
		txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 안녕히계세요. 홍길동입니다.";
		
		// index = txt.indexOf("홍길동"); // indexOf는 처음부터 검사를 하다가 원하는 애를 만나면 끝남, 7 출력
		txt.indexOf("홍길동"); // 7
		System.out.println(index);
		
		txt.indexOf("홍길동", index + 3); // 22
		System.out.println(index);
		
		txt.indexOf("홍길동", index + 3); // 38
		System.out.println(index);
		System.out.println();
		
		index = txt.lastIndexOf("홍길동"); // lastIndexOf는 오른쪽에서 왼쪽으로 찾는다
		System.out.println(index);
		
		index = txt.lastIndexOf("홍길동", index - 1);
		System.out.println(index);
	}

	private static void m5()
	{
		// 공백(스페이스, 엔터, 탭) 제거
		// String trim()
		// 문자열의 시작과 끝에 존재하는 공백 문자를 제거한다
		// 사용자 실수 또는 불필요한 공백 제거 역할
		
		String txt = "     하나    둘     셋     ";
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
	}

	private static void m4()
	{
		// char c1 = 'A';
		// System.out.println((int)c1);
		// System.out.println((char)65);
		
		// *** 절대적으로 값형과 참조형간의 형변환은 지원하지 않는다
		// String s1 = "A";
		// System.out.println((int)s1);
		
		// System.out.println(Integer.parseInt("100")); // 이건 형변환이 아니다, 파싱한것
		// 앞에 소괄호 붙여서 명시적으로 형변환한것만 형변환이라고 부름
		
		
		// 영단어 입력(소문자로만 입력)
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단어(소문자)를 입력해주세요");
		String word = scan.nextLine();
		
		// java, JAVA, Java, javA .. 난 java 만 원한다
		
		// java 라고 입력했을 때
		// j 만 뽑아냄 -> 형변환해서 문자코드값을 알아냄(106)
		// 영어 소문자 a(문자코드값 97) ~ z(122)
		
		// Java 라고 입력했을 때
		// J(74) -> a(문자코드값 97) ~ z(122) 에 속하지 않음 -> 잘못 입력했구나
		// 이런식으로 첫 글자부터 하나씩 검사함, 하나라도 범위를 벗어나면 잘못 입력했다고 판단
		
		//javA
		boolean flag = true;
		
		for (int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			// System.out.println((int)c);
			
//			if ((int)c >= 97 && (int)c <= 122)
//			{
//				// 소문자로 제대로 입력했구나
//				// System.out.println("소문자");
//			}
//			else
//			{
//				// 잘못된 문자다
//				// System.out.println("잘못된 문자");
//				flag = false;
//				break;
//			}
			
			// *모든 유효성 검사는 올바른걸 찾지 말고 잘못된 것만 찾으면 된다*
			// char 비교는 자동으로 문자 코드값 비교로 이어진다
			// if((int)c < 97 || (int)c > 122) // || <- or
			// if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) 대소문자 다 가능으로 바꿔보자
			// if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) 대소문자에 숫자까지 가능으로
			// if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && (c != '_')) 기존 규칙 + 특수문자 _ 만 통과
			if(c < '가' || c > '힣') // 한글만 통과
			{
				flag = false;
				break;
			}
		}
		
		// System.out.println(flag);
		if (flag)
		{
			System.out.println("올바른 단어");
		}
		else
		{
			System.out.println("잘못된 단어");
		}
	}

	private static void m3()
	{
		// 주민등록번호 입력
		// ex) 990108-1234567
		
		String jumin = "990108-1234567";
		
		if (jumin.charAt(6) == '-')
		{
			System.out.println("올바른 주민번호입니다.");
		}
		else
		{
			System.out.println("잘못된 주민번호입니다.");
		}
	}

	private static void m2()
	{
		// 문자열 추출
		// char charAt(int idex)
		// 문자열에서 원하는 위치의 문자 1개를 추출
		// Zero based Index를 사용한다.
		
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		char c = txt.charAt(3);
		System.out.println(c);
		
		// 10번째 문자(절대적인 위치)를 추출하고 싶다
		c = txt.charAt(10);
		System.out.println(c);
		
		
		// StringIndexOutOfBoundsException: Index 15 out of bounds for length 14
		// <- 없는 숫자를 달라고 하니 런타임 에러 발생
		// c = txt.charAt(15);
		// System.out.println(c);
		
		
		// 마지막 문자(상대적인 위치)를 추출하고 싶다
		c = txt.charAt(txt.length() - 1); // txt.length() - 1
		System.out.println(c);
	}

	private static void m1()
	{
		// 문자열 생성
		// 1. 리터럴 -> "홍길동";
		// 2. 객체 생성
		
		// String 자료형은 일종의 클래스
		
		// 문자열 리터럴
		String s1 = "홍길동"; // <- 정식으로 말하자면 스트링이라는 이름으로 선언된 클래스
		String s2 = new String("홍길동"); // <- 원랜 이렇게 써야함
		
		System.out.println(s1);
		System.out.println(s2);
		
		// 문자열의 길이를 알아내야 할 때
		// -int length()
		// 문자열은 char 배열(char[])
		
		// 배열의 길이
		// arr.length
		
		String txt = "홍길동";
		System.out.println(txt.length()); // 글자 수 3 출력
		System.out.println("자바".length()); // 2 출력
		System.out.println("ABC한글123456#$%".length()); // 14 출력
		
		// 유효성 검사 할 때 사용
		// 회원 가입 -> 이름 입력
		// 이름을 2자~5자 이내로 작성하세요 <- 이런 용도로 사용
		// 한글 기준 성을 제외한 순수 이름은 5글자
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.println(name.length());
		
		if (name.length() >= 2 && name.length() <= 5)
		{
			System.out.println("올바른 이름");
		}
		else
		{
			System.out.println("이름을 2~5자 이내로 입력하세요.");
		}
	}
}
