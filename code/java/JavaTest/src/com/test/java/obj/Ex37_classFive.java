package com.test.java.obj;

public class Ex37_classFive
{
	public static void main(String[] args)
	{
		// Ex37_classFive.java
		Person p1 = new Person();
		
		p1.setName("홍길동");
		p1.setAge(20);
		
		String[] nick = { "천재", "고집불통", "멍멍이" }; // 별명들
		
		p1.setNick(nick);
		
		p1.getNick();
		System.out.println(p1.getNick()[0]); // 0번째 별명
		System.out.println(p1.getNick()[1]); // 1번째 별명
		System.out.println(p1.getNick()[2]); // 2번째 별명
		
		
	} // main
}

class Address
{
	private String sido;
	private String gugun;
	private String dong;
	private String bunji;
	
	public String getSido()
	{
		return sido;
	}
	
	public void setSido(String sido)
	{
		this.sido = sido;
	}
	
	public String getGugun()
	{
		return gugun;
	}
	
	public void setGugun(String gugun)
	{
		this.gugun = gugun;
	}
	
	public String getDong()
	{
		return dong;
	}
	
	public void setDong(String dong)
	{
		this.dong = dong;
	}
	
	public String getBunji()
	{
		return bunji;
	}
	
	public void setBunji(String bunji)
	{
		this.bunji = bunji;
	}
	
	
	
}

class Person
{
	private String name;
	private int age;
	
	// 주소
	// private String address; // 서울시 강남구 대치동 10번지
//	private String sido;
//	private String gugun;
//	private String dong;
//	private String bunji;
	private Address address;
	
	// 별명
	// private String nick;
	private String[] nick = new String[3]; // 별명이 많을 수도 있으니까 배열로 저장
	
	
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

	public String[] getNick()
	{
		return nick;
	}

	public void setNick(String[] nick)
	{
		this.nick = nick;
	}

}