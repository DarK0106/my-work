package com.test.java.obj;

public class Ex36_classFour
{
	public static void main(String[] args)
	{
		// Ex36_classFour.java
		Parent f1 = new Parent();
		f1.setName("홍길동");
		f1.setAge(45);
		
		Parent m1 = new Parent();
		m1.setName("김영희");
		m1.setAge(42);
		
		Child c1 = new Child();
		c1.setName("홍철수");
		c1.setAge(18);
		
		c1.setFather(f1); // 자식 c1의 아버지 f1
		c1.setMother(m1); // 엄마
		
		System.out.println("자식: " + c1.getName());
		
		// *개념이 중요한 부분*
		// 길동이가 철수 아빠인지 모르고 길동이한테 당신 이름이 뭡니까 라고 물어본 것
		System.out.println("아빠: " + f1.getName());
		System.out.println("엄마: " + m1.getName());
		
		// 철수의 아빠 길동이의 이름을 원한다면
		System.out.println("아빠: " + c1.getFather().getName());
		// 엄마이름
		System.out.println("엄마: " + c1.getMother().getName());
	}
}

// 부모
class Parent
{
	
	private String name;
	private int age;
	
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
	
}

// 자식
class Child
{
	private String name;
	private int age;
	
	private Parent father;
	private Parent mother; // 어떤 하나의 클래스가 또 다른 클래스를 멤버로 받아들일 수 있다
	
	public Parent getFather()
	{
		return father;
	}

	public void setFather(Parent father)
	{
		this.father = father;
	}

	public Parent getMother()
	{
		return mother;
	}

	public void setMother(Parent mother)
	{
		this.mother = mother;
	}

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
}