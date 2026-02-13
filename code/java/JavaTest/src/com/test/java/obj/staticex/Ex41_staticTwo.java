package com.test.java.obj.staticex;

public class Ex41_staticTwo
{
	public static void main(String[] args)
	{
		// Ex41_staticTwo.java
		// 1. 펜을 만드시오
		// 2. 생산된 펜의 개수를 세시오

		// Case 1.
		// - 간단함
		// - 펜이라는 객체와 count 라는 변수간의 관계가 모호하다
		// - 사람이 실수를 할 수 있다 count++ 누락 위험(에러 안 떠서 찾기 힘듬)
//		int count = 0; // 개수를 세기 위한 누적 변수
//		Pen p1 = new Pen("MonAmi 153", "black");
//		count++;
//		
//		Pen p2 = new Pen("MonAmi 153", "black");
//		count++;
//		
//		Pen p3 = new Pen("MonAmi 153", "black");
//		count++;
//		
//		System.out.println("펜 개수: " + count);

		// Case 2.
		// - Pen 객체와 count 변수간의 관계 강화
		// - count가 객체 변수로 만들어진게 문제임 -> 객체(펜)마다 count가 생성됨 -> count가 개인 데이터가 되어버림 -> 공용
		// 데이터가 되어야함

//		Pen p1 = new Pen("MonAmi 153", "black");
//		p1.count++;
//		
//		Pen p2 = new Pen("MonAmi 153", "black");
//		p2.count++;
//		
//		Pen p3 = new Pen("MonAmi 153", "black");
//		p3.count++;
//		
//		System.out.println("펜 개수: " + p1.count);

		// Case 3.
		// - Pen 객체와 count 변수간의 관계 강화
		// - 개인 데이터와 공용 데이터를 잘 분리시켰다.
		// - 여전히 count를 누락할 수 있음

		/*
		 * Pen p1 = new Pen("MonAmi 153", "black"); 
		 * Pen.count++;
		 * 
		 * Pen p2 = new Pen("MonAmi 153", "black"); 
		 * Pen.count++;
		 * 
		 * Pen p3 = new Pen("MonAmi 153", "black"); 
		 * Pen.count++;
		 * 
		 * System.out.println("펜 개수: " + Pen.count);
		 */

		// Case 4.
		Pen p1 = new Pen("MonAmi 153", "black");
		Pen p2 = new Pen("MonAmi 153", "black");
		Pen p3 = new Pen("MonAmi 153", "black");
		
		System.out.println("펜 개수: " + Pen.count);

	} // main
}

//Case 4 에서 쓰는 클래스
class Pen
{
	// 객체 변수
	private String model;
	private String color;

	// 정적 변수
	public static int count; // 개수를 세기 위한 누적 변수, 공용 변수

	// 기본 생성자는 개발자가 아무것도 안하면 자동으로 만들어줌
	// 객체 생성자 -> 객체 변수들을 초기화하는 역할 -> 펜을 만들었다 !!
	public Pen(String model, String color) // 오버로딩된 생성자를 만들었다 -> 기본 생성자는 자동으로 안 만들어짐
	{
		this.model = model;
		this.color = color;
		Pen.count++; // 생성자도 메서드니까 펜 세는 기능도 여기 넣어버림
	}

	// 정적 생성자 -> 정적 변수를 초기화하는 역할
	static
	{
		Pen.count = 0;
	}

	public String info()
	{
		return this.model + ":" + this.color;
	}
}

// Case 3 에서 쓰는 클래스
/*
 * class Pen { // 객체 변수 private String model; private String color;
 * 
 * // 기본 생성자는 개발자가 아무것도 안하면 자동으로 만들어줌 // 객체 생성자 -> 객체 변수들을 초기화하는 역할 public
 * Pen(String model, String color) // 오버로딩된 생성자를 만들었다 -> 기본 생성자는 자동으로 안 만들어짐 {
 * this.model = model; this.color = color; // The static field Pen.count should
 * be accessed in a static way -> this 쓰지 마라 // Pen.count = 0; // 누적 변수니까 0으로
 * 초기화 }
 * 
 * // 정적 변수 public static int count; // 개수를 세기 위한 누적 변수, 공용 변수
 * 
 * // 정적 생성자 -> 정적 변수를 초기화하는 역할 static { Pen.count = 0; }
 * 
 * public String info() { return this.model + ":" + this.color; } }
 */

// Case 2 에서 쓰는 클래스
//class Pen 
//{
//	private String model;
//	private String color;
//	
//	public int count; // 개수를 세기 위한 누적 변수, 저마다 각자 갖고 있는 객체 변수
//	// 누적 변수를 펜마다 만들어버림
//
//	// 기본 생성자는 개발자가 아무것도 안하면 자동으로 만들어줌
//	public Pen(String model, String color) // 오버로딩된 생성자를 만들었다 -> 기본 생성자는 자동으로 안 만들어짐
//	{
//		this.model = model;
//		this.color = color;
//		this.count = 0; // 누적 변수니까 0으로 초기화
//	}
//	
//	public String info()
//	{
//		return this.model + ":" + this.color;
//	}
//}

/*
 * // Case 1 에서 쓰는 클래스 class Pen { private String model; private String color;
 * 
 * // 기본 생성자는 개발자가 아무것도 안하면 자동으로 만들어줌 public Pen(String model, String color) //
 * 오버로딩된 생성자를 만들었다 -> 기본 생성자는 자동으로 안 만들어짐 { this.model = model; this.color =
 * color; }
 * 
 * public String info() { return this.model + ":" + this.color; } }
 */