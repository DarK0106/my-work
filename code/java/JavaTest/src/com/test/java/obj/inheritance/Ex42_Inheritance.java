package com.test.java.obj.inheritance;

public class Ex42_Inheritance
{
	public static void main(String[] args)
	{
		// Ex42_Inheritance.java
		/*
		 * 
		 * 상속, Inheritance
		 * - 부모가 가지는 재산을 자식에게 물려주는 행동
		 * - 부모(클래스)가 가지는 재산(멤버 변수, 멤버 메서드)을 자식(클래스)에게 물려주는 행동
		 * 
		 * 왜 할까?
		 * - 부모 클래스에서 이미 구현한 코드를 자식 클래스에서 코드를 재사용
		 */
		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		p1.ccc();
		
		Child c1 = new Child();
		
		c1.a = 10;
		c1.b = 20;
		c1.ccc();
		
		c1.d = 30;
		c1.e = 40;
		c1.fff();
		
	} // main
}

class Parent
{
	public int a;
	public int b;
	
	public void ccc()
	{
		System.out.println("ccc");
	}
}

// 클래스 상속
// class 자식클래스 extends 부모클래스 {}
class Child extends Parent
{
	public int d;
	public int e;
	
	public void fff()
	{
		System.out.println("fff");
	}
}

class AAA
{
	public int a;
}

class BBB extends AAA
{
	public int b;
}

class CCC extends BBB
{
	public int c;
}

class DDD extends BBB
{
	public int b;
}