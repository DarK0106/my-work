package com.test.java.obj;

public class Ex32_classThree
{
	public static void main(String[] args)
	{
		// Ex32_classThree.java
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 15;
		s1.hello();
		
		Student s2 = new Student();
		s2.name = "강아지";
		s2.age = 14;
		s2.hello();
		
		Student s3 = new Student();
		s3.name = "고양이";
		s3.age = 14;
		s3.hello();
		
	}
}

// The type Member is already defined
//class Member
//{
//	
//}

class Student
{
	// 멤버 변수 -> 역할: 같은 자료형의 객체지만 서로 다른 개성을 부여하는 역할
	public String name;
	public int age;
	
	// 멤버 메서드 -> 역할: 멤버 변수를 활용한 행동을 하는 것이 좋다
	public void hello()
	{
		// 각 붕어빵들의 특성을 반영하지 않은 행동
		// System.out.println("안녕하세요.");
		
		System.out.printf("안녕하세요. 저는 %s입니다.\n", name);
	}
}