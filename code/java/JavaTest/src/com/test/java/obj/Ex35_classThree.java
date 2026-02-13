package com.test.java.obj;

public class Ex35_classThree
{	
	public static void main(String[] args)
	{
		// Ex35_classThree.java
	
		m1();
	} // main

	private static void m1()
	{
		Employee e1 = new Employee();
		e1.setName("홍길동");
		e1.setDepartment("영업부");
		
		Employee e2 = new Employee();
		e2.setName("아무개");
		e2.setDepartment("영업부");
		
		// Case 1.
		// 아무개의 상사 길동
//		e2.setBossName("홍길동");
//		e2.setBossDepartment("영업부");
		
		// Case 2.
		// e2.setBossName(e1.getName());
		// e2.setBossDepartment(e1.getDepartment());
		
		// Case 3.
		e2.setBoss(e1);
		
		// Case 1. 방법
		// com.test.java.obj.Employee <- 이 객체의 자료형 @ 이 객체가 있는 메모리 주소 비슷한거 -> 5305068a
//		System.out.println(e2);
//		System.out.println(e2.toString()); // <- 프린트에 매개변수를 넣으면 자바가 이렇게 코드를 바꿈
		
//		System.out.println(e2.getName());
//		System.out.println(e2.getDepartment());
//		System.out.println(e2.getBossName());
//		System.out.println(e2.getBossDepartment());
		
		System.out.println(e2.info());
		
	}
	
	
}

// 어떤 회사의 사원
class Employee
{
	private String name; // 직원의 이름
	private String department; // 부서명
	
	// private String bossName; // 상사의 이름
	// private String bossDepartment; // 상사의 부서 이름
	
	private Employee boss; // 또 다른 객체인 상사
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
//	public String getBossName()
//	{
//		return bossName;
//	}
//	
//	public void setBossName(String bossName)
//	{
//		this.bossName = bossName;
//	}
//	
//	public String getBossDepartment()
//	{
//		return bossDepartment;
//	}
//	
//	public void setBossDepartment(String bossDepartment)
//	{
//		this.bossDepartment = bossDepartment;
//	}
	
	public Employee getBoss()
	{
		return boss;
	}

	public void setBoss(Employee boss)
	{
		this.boss = boss;
	}
	
	// 개발용(디버깅용)
	public String info()
	{
		// return name + "," + department + "," + bossName + "," + bossDepartment;
		
		// System.out.printf("%s", name);
		// String.format("%s", name); <- 위에거랑 99% 똑같음, 위에거는 반환값이없고 화면에 찍고 끝나는데 얘는 반환값이 String임
		
		return String.format("직원명: %s\n부서명: %s\n상사명: %s\n상사부서명: %s\n", name, department, boss.getName(), boss.getDepartment());
	}
}