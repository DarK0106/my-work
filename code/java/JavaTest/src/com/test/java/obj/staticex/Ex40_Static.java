package com.test.java.obj.staticex;

public class Ex40_Static
{
	// 1. 전처리 과정
	// 2. 클래스 로딩(Loading): 모든 클래스의 정의를 메모리에 올린다.
	//	- 로딩 중 발생하는 작업
	//		- static이 붙은 걸(변수 / 메서드) 메모리에 저장
	// 3. main() 호출
	
	public static void main(String[] args)
	{
		// Ex40_Static
		/*
		 * 
		 * static: 정적 이라는 키워드
		 * 어려워서 잘 안쓴다?
		 * - 지시자 중 하나, 접근지정자는 아님
		 * - 클래스에 붙일 수 있음 <- 모든 지시자가 다 그럼
		 * - 클래스 멤버(변수/메서드)에 다 붙일 수 있음 <- 모든 지시자가 다 그럼
		 * 
		 * static 변수의 생명주기 <- 생명 주기가 가장 길다, 메모리를 계속 차지하고 있다
		 * 1. 생성: main() 호출 전에 태어남
		 * 2. 소멸: main() 종료 후
		 * <- 공용 데이터라서 문제 생기면 범인 찾기가 힘들다.
		 * 객체 변수는 걔만 확인하면 되는데 공용 변수는 관리가 힘들다
		 * 
		 * 그럼 객체 변수(클래스 멤버 변수)의 생명 주기는?
		 * 1. 생성: 객체가 생성될 때(new가 실행될 때)
		 * 2. 소멸: 객체가 소멸할 때
		 * 
		 */
		
		// 홍길동의 학교 -> 대치 중학교
		// 모든 학생의 학교 -> 대치 중학교( 공용 / 집합 / 그룹 데이터 )
		// 학교 이름을 한 사람의 학교 이름으로 생각하지 않고
		// 모든 사람의 학교 이름으로 생각하자
		// 요구사항) 학생 관리 프로그램 -> 학생 3명
		// 의뢰 주체가 "대치 중학교"
		// 유지보수가 힘들다(같은 데이터를 여러번 저장해서) 
		// -> 만약에 학교 이름을 바꾼다하면
		// 학생 수만큼 바꿔야함
		
		// 집단으로서의 행동
		Student.setSchool("대치 중학교"); // 새로 만든 setSchool 호출해서 공용 데이터인 대치중학교를 넣음
		
		
		// 개인으로서의 행동
		Student s1 = new Student();
		s1.setName("홍길동"); // s1 이라는 학생의 이름을 설정하는 것 -> 개인 데이터를 설정하고 있음
		s1.setAge(15); // s1 이라는 학생의 나이를 설정하고 있음 -> 개인 데이터를 설정
		s1.setSchool("대치 중학교"); // 학교를 개인 데이터가 아닌 모든 사람의 학교로 설정 -> 공용 데이터 설정
		// 그런데 왜 이걸 s1이 해야 할까? -> 공용 데이터를 개인이 설정하고 있어서 s1.setSchool("대치 중학교"); 가 잘못됨
		// ex) 개인 황윤재가 혼자서 대한민국 이름을 중국으로 바꿔버림
		// setSchool getSchool도 잘못되서 다시 만들어야함
		
		
		Student s2 = new Student();
		s2.setName("강아지");
		s2.setAge(14);
		// s2.setSchool("대치 중학교"); <- 이미 s1에서 대치중학교 넣어놔서 할 필요 없음
		
		Student s3 = new Student();
		s3.setName("고양이");
		s3.setAge(15);
		// s3.setSchool("대치 중학교");
		
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(s3.info());
		
	} // main
}


// Ctrl + Shit + Alt + L : Quick Search
class Student
{
	// 객체 멤버 변수 -> 개인 데이터를 저장하는 역할 -> static 안 붙은 객체 메서드와 같이 사용한다 
	private String name;
	private int age;
	
	// 정적(공용) 멤버 변수 school -> 공용 데이터를 저장하는 역할 -> 정적 메서드와 같이 사용한다
	// private String school;
	// static 붙은 애들은 static 메모리 영역에서만 만들어진다
	private static String school;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

//	public String getSchool()
//	{
//		return school;
//	}
//
//	public void setSchool(String school)
//	{
//		// this.school = school;
//		// 클래스 영역에 있는 정적 변수 school 에 대치 를 넣어라
//		Student.school = school; // private static String school; 로 바꿔서 얘도 이렇게 바꿔야 함
//	}
	
	// 덤프 메서드
	public String info()
	{
		// Student.school 로 해야 정확한 메모리에 위치한 school
		// this.name : 제 이름은, this.age: 제 나이는
		// Student.school: 우리 학교는
		// 모든 사람이 쓰는 school을 공용으로 바꿔야 유지보수가 편하고 메모리도 덜 잡아먹는다
		// 이런 목적으로 쓰는게 static이 붙은 변수
		return String.format("%s(%d세) - %s", this.name, this.age, Student.getSchool());
	}

	// 새로 만든 getSchool과 setSchool
	public static String getSchool()
	{
		// Cannot use this in a static context
		// this.school = school; <- this(나) 못씀, school 은 '우리'를 가리키기 때문
		return Student.school;
	}

	public static void setSchool(String school)
	{
		Student.school = school;
	}
	
}
