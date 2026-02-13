package com.test.java.obj;

public class Ex38_Constructor
{
	public static void main(String[] args)
	{
		// Ex38_Constructor
		/*
		 * 
		 * 생성자, Constructor
		 * - 특수한 목적을 가지고 만들어진 메서드
		 * - 객체의 멤버를 초기화하는 전용 메서드
		 * 
		 * 생성자 특징
		 * 1. 반환 타입이 아예 없음 void도 아님, 기재 안함
		 * 2. 생성자명 = 클래스명
		 * 3. 접근지정자가 public
		 * 4. 객체의 생애를 통틀어 처음 딱 1회만 호출이 가능함
		 * 
		 */
		
		// m1();
		// m2();
		m3();
		
		
	} // main

	private static void m3()
	{
		// 박스 대량 생산
		// 1. 대형 50개
		// 2. 소형 50개
		Box b1 = new Box(); // 대형
		Box b2 = new Box("대형", 5000); // 생성자 오버로딩한 대형 박스
		
		// 원래 대형 박스 만드는 틀에서 소형 박스 만들던 방식
		// 일일히 setter 써서 바꿨어야했음
		Box s1 = new Box();
		s1.setSize("소형");
		s1.setPrice(500);
		
		// 새로 배운 방식
		Box s2 = new Box("소형", 500); // 생성자 오버로딩한 소형 박스
		// 여기서 Setter 또 불러서 수정도 할 수 있음
		s2.setPrice(600);
		
		// *역할*
		// 1. 생성자: 객체의 초기화만 가능, 수정은 Setter만 할 수 있음
		// 2. Setter: 객체의 초기화(Setter로 귀찮아서, 헷갈려서 잘 안함) 또는 객체의 수정
		
	}

	private static void m1()
	{
		// 1. new 실행
		// - new 는 객체 생성 연산자
		// 2. Box() 실행 -> 생김새가 메서드 호출하는 구문처럼 생김 -> 실제로 호출하는거 맞음
		Box b1 = new Box();
		b1.setSize("소형");
		b1.setPrice(500);
				
		System.out.println(b1.info());
	}

	private static void m2()
	{
		// 박스 대량 생산
		// 1. 대형 박스 100개 생산
		// 2. 소형 박스 5개 생산
		
		Box b1 = new Box();
		// b1.setSize("대형");
		// b1.setPrice(5000);
		
		Box b2 = new Box();
		// b1.setSize("대형");
		// b1.setPrice(5000);
		
		Box b3 = new Box();
		// b1.setSize("대형");
		// b1.setPrice(5000);
		
		System.out.println(b3.info());
		
		Box s1 = new Box(); // 박스 만드는 틀이 대형으로 맞춰져있어서 틀을 소형으로 바꿔야함
		s1.setSize("소형");
		s1.setPrice(500);
		
		System.out.println(s1.info());
	}
}

class Box
{
	private String size;
	private int price;
	
	// 기본 생성자, Default Constructor
	// - 개발자가 구현을 안해도 컴파일러가 자동으로 만든다
	// 직접 만들면 컴파일러가 안만들어주고 안 만들면 컴파일러가 만들어줌
//	public Box() // 반드시 클래스 이름과 같아야 함
//	{
//		
//		// 멤버 변수를 초기화 <- 생성자의 역할임
//		// 자동으로 초기화되는 초깃값
//		this.size = null;
//		this.price = 0;
//	}
	
	
	// 기본 생성자
	public Box() // 생성자로 초기화 가능
	{
		this.size = "대형";
		this.price = 5000;
	}
	
	// 메서드 오버로딩
	public Box(String size, int price) // 생성자 오버로딩 가능
	{
		this.size = size;
		this.price = price;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public void setSize(String size)
	{
		this.size = size;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String info() // 여러개의 정보를 한번에 확인하기 위해 만든 메서드
	{
		return String.format("%s(%,d)", size, price);
	}
}