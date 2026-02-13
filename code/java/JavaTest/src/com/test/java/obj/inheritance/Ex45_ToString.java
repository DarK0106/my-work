package com.test.java.obj.inheritance;

import java.util.Date;

public class Ex45_ToString
{
	public static void main(String[] args)
	{
		// Ex45_ToString.java
		
		// 클래스 상속 + 메서드 오버라이딩에 대한 복습
		// *toString() 메서드 오버라이딩*
		// 모든 개발자들이 어떤 객체에 toString()을 호출하면 덤프값이 반환될거라고 기대하고 있음
		Time t1 = new Time();
//		System.out.println(t1.info());
		System.out.println(t1);
//		System.out.println(t1.toString());
		
		Time t2 = new Time(2,30);
//		System.out.println(t2.info());
		System.out.println(t2);
//		System.out.println(t2.toString());
		
		Time t3 = new Time(5,10);
//		System.out.println(t3.info());
		System.out.println(t3);
//		System.out.println(t3.toString()); // Object는 똑같은 toString을 갖게 하기 위해 물려준 것 
		
		// toString은 다른 클래스가 커스텀할 수 있다
		
		Date d1 = new Date(); // util 에 있는 Date를 임포트
		System.out.println(d1); // Mon Jan 12 09:10:48 GMT+09:00 2026 출력됨
		System.out.println(d1.toString()); // 덤프 / Object 에 있는 toString과는 다른 Date에서 오버라이드된 toString
		
		
	}
}

class Time
{
	private int hour;
	private int min;
	
	public Time()
	{
		this.hour = 0;
		this.min = 0;
	}

	public Time(int hour, int min)
	{
		this.hour = hour;
		this.min = min;
	}

	// 덤프 메서드
//	public String info()
//	{
//		
//		return String.format("%d:%d", this.hour, this.min);
//	} <- 이제 안 만들어도 된다 ?
	
//	@Override
//	public String toString()
//	{
//		// TODO Auto-generated method stub
//		return String.format("%d:%d", this.hour, this.min); // Object에 있던 toString을 내가 커스텀한 것
//		// 원래는 출력하면 해쉬코드가 나왔는데 커스텀하니 개발자들이 기대한 덤프값으로 출력됨
	
	@Override
	public String toString()
	{
		return "Time [hour=" + hour + ", min=" + min + "]";
	} // <- 우클릭으로 toString 만드는게 있음
	
}