package com.test.java.obj;

import java.util.ArrayList;
import java.util.List;

public class Ex72_Record
{
	public static void main(String[] args)
	{
		// Ex72_Record.java
		/*
		 * Record 라는 자료형
		 * - 데이터를 저장하기 위한 목적으로 만든 특별한 클래스
		 * - 불변(Immutable) 객체를 생성하는 것이 목적
		 * - 생성자, Getter, equals(), hashCode, toString 을 컴파일러가 자동으로 생성해서 간편함
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		// m1();
		m2();
		
	} // main

	private static void m2()
	{
		// 성적 관리 Record 활용
		// 1. 학생 Record 설계
		// 2. 집합 -> ArrayList
		// 3. 성적순으로 정렬해서 출력
		List<StudentRecord> list = new ArrayList<StudentRecord>();
		
		list.add(new StudentRecord("홍길동", 100, 90, 80));
		list.add(new StudentRecord("김메시", 86, 75, 85));
		list.add(new StudentRecord("호날두", 86, 95, 76));
		list.add(new StudentRecord("엄준식", 98, 74, 84));
		list.add(new StudentRecord("조강현", 75, 85, 82));
		
		System.out.println(list);
		System.out.println();
		list.sort((a, b) -> b.getTotal() - a.getTotal());
		
		System.out.println(list);
		System.out.println();
	}

	private static void m1()
	{
		// 유저 정보를 저장하는 클래스를 만들어달라
		UserClass u1 = new UserClass("hong", "홍길동", 20);
		System.out.println(u1);
		
		UserRecord u2 = new UserRecord("hong", "홍길동", 20); // 생성자
		System.out.println(u2); // toString
		
		
		System.out.println(u2.id());
		System.out.println(u2.name());
		System.out.println(u2.age()); // 이게 Getter
		
		UserRecord u3 = new UserRecord("hong", "홍길동", 20);
		
		System.out.println(u2.hashCode()); // 오버라이딩 되었다
		System.out.println(u3.hashCode());
		
		System.out.println(u2.equals(u3)); // 동일인
		
	}
}


// 읽기 전용
// 생성자로 초기화
// Getter 만 구현
class UserClass
{
	private final String id;
	private final String name;
	private final int age;
	
	public UserClass(String id, String name, int age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	
	public String getId()
	{
		return id;
	}



	public String getName()
	{
		return name;
	}



	public int getAge()
	{
		return age;
	}



	@Override
	public String toString()
	{
		return "UserClass [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}

// 읽기 전용 객체
// Record 사용 -> 컴파일러가 대신 구현해준다
// private final 멤버 구현
// 생성자 이미 구현됨
// getter 구현됨
// toString 구현됨
// 상속은 못한다
// 기본적인 클래스가 하는 작업은 일부 불가능하다
// 멤버 변수는 읽기 전용으로만 만들 수 있다
record UserRecord(String id, String name, int age) {}

// 학생 레코드
record StudentRecord(String name, int kor, int eng, int math) 
{
	// 생성자에서 유효성 검사를 하고싶다?
	public StudentRecord
	// 컴팩트 생성자라고 부른다(Compact Constructor)
	{
		if (name == null)
		{
			name = "익명";
		}
		if (kor < 0 && kor >= 100)
		{
			kor = 0;
		}
	}
	
	// 일반 메서드
	public int getTotal()
	{
		return this.kor + this.eng + this.math;
	}
}

