package com.test.java.obj.inheritance;

public class Ex49_Interface
{

	public static void main(String[] args)
	{

		// Ex49_Interface.java
		/*
		 * 
		 * 추상화 기술 1. 추상 클래스 2. 인터페이스
		 * 
		 * 인터페이스, interface - 추상 메서드의 집합 - 객체를 생성할 수 없다. - 상속에서 부모 클래스 역할을 한다. - 구현 멤버를
		 * 가질 수 없다.(추상 클래스와 차이)
		 * 
		 * 일반클래스: 구현 멤버 추상클래스: 구현 멤버 + 추상 멤버 인터페이스: 추상 멤버
		 * 
		 * 일반클래스 + 인터페이스 > 보편적
		 * 
		 */

		S25 p1 = new S25();
		p1.on();
		p1.call();
		p1.off();

		Iphone16 p2 = new Iphone16();
		p2.on();
		p2.call();
		p2.off();
		System.out.println();

		// 사람으로서의 길동이
		Person hong = new Person("홍길동", 40);
		System.out.println(hong);

		// 장소/위치/상황에 따른 역할 차이

		// 가정 > 아빠로서의 행동 > 메서드
		// hong.아이와놀아주기();
		// hong.가족여행을한다();

		// 직장 > 부장로서의 행동 > 메서드
		// hong.결재를한다();
		// hong.프로젝트를진행한다();

		// 집
		hong.아이와놀아주기();
		// hong.결재를한다();
		hong.아이와놀아주기();

		// Person hong
		아빠 hong2 = new Person("홍길동", 40);

		hong2.아이와놀아주기();
		hong2.가족여행을한다();
		// hong2.결재를한다();

		부장 hong3 = new Person("홍길동", 40);

		hong3.결재를한다();
		hong3.프로젝트를진행한다();

		// 인터페이스 적용 > 객체 자체를 보는 것이 아니라. 그 객체가 하는 역할이 중요할 때.
		
		// 가정집에서 보일러가 고장나서 수리기사를 호출했다. 그사람이 lee.
		lee a1 = new lee();
		
		// a1.달리기();
		// a1.술을마신다(); <- 우리 집에서 할 행동들은 아니다
		
		// a1.보일러점검하기();
		// a1.배수관교체하기();
		// a1.술을마신다(); // 보일러가 너무 잘 고쳐져서 기사님과 술 한잔 했다
		
		// 또 고장나서 보일러 수리기사를 또 불렀다
		// 한 번 불러본 경험이 있어서 이젠 익숙해졌다
		Park a2 = new Park();
		
		// a2.보일러오류를점검한다(); // 똑같은 보일러점검하기를 할 줄 알았는데 비슷하긴 하지만 행동이 좀 달랐다
		// a2.배수관교체를진행합니다(); // 이것도 뭔가 조금 달랐다
		// a2.술을마신다(); <- lee 랑은 술도 마셨는데 park은 술을 마신다는 행동 자체가 없다
		// 보일러가 수리된건 맞는데 사람이 다르니까 비슷한 행동에도 차이를 보였다 <- 내 입장에선 불편했다
		// 나는 수리기사로서 lee와 park을 불렀는데 사람으로서의 lee와 park을 원한게 아니었다
		// 그사람들의 행동이 통일되어있지 않았다
		// 하지만 행동을 똑같이 하도록 강요할수는 없다. lee와 park은 서로 다른 클래스이기 때문이다.
		// 메서드가 통일이 안되서 발생한 문제
		// 이걸 해결할 수 있는게 interface이다
		
		// 보일러가 또 고장나서 기사님이 왔다
		lee a3 = new lee(); // 참조변수를 클래스로 받음
		a3.보일러를점검한다();
		a3.배수관을교체한다();
		// lee는 달리기도 하고 술도마심
		// 기사로서의 역할도 하면서 사람으로서의 lee도 여전히 남아있다
		// 개인으로서의 행동을 할 수 있는 여지가 남아있다
		// 난 기사로서의 lee만 원한다
		
		// 또 고장나서 이번엔 park이 왔다
		Park a4 = new Park();
		a4.보일러를점검한다();
		a4.배수관을교체한다();
		// park은 고기도 먹고 축구도 한다
		// 기사로서의 역할도 하면서 사람으로서의 park도 여전히 남아있다
		// 개인으로서의 행동을 할 수 있는 여지가 남아있다
		// 난 기사로서의 park만 원한다
		
		기사 a5 = new lee(); // 참조변수를 인터페이스로 받음
		a5.보일러를점검한다();
		a5.배수관을교체한다();
		// 이제 사람으로서의 lee는 볼 수 없음
		
		기사 a6 = new Park();
		a6.보일러를점검한다();
		a6.배수관을교체한다();
		
		// 똑같은 객체여도 참조변수가 뭐냐에따라 상황이 다르다
		// class로 참조변수를 받을때는 그 클래스의 특성 모두가 필요할때
		// 참조변수를 인터페이스로 받을때는 내가 원하는 특정 역할만 필요할때
		
	}// main

}

// 보일러 수리기사로서의 역할을 규정한다 <- 보일러 수리기사 자격증 같은 interface, 권장이 아닌 강요
interface 기사
{
	void 보일러를점검한다();

	void 배수관을교체한다();
}

class lee implements 기사
{
	// 이순신만의 개성
	private String name;
	private int age;
	private String adress;
	
	public void 달리기()
	{
		System.out.println("이순신이 달리기를 합니다.");
	}
	
	public void 술을마신다()
	{
		System.out.println("이순신이 술을 마십니다.");
	}
	
//	public void 보일러점검하기()
//	{
//		System.out.println("보일러점검하기");
//	}
//	
//	public void 배수관교체하기()
//	{
//		System.out.println("배수관교체하기");
//	}

	// 인터페이스가 쓰라는걸 쓰도록 교체
	@Override
	public void 보일러를점검한다()
	{
		// TODO Auto-generated method stub
		System.out.println("보일러점검하기");
	}

	@Override
	public void 배수관을교체한다()
	{
		// TODO Auto-generated method stub
		System.out.println("배수관교체하기"); // 이제 lee는 자격증을 딴 수리기사가 되었다
	}
	
}

class Park implements 기사
{
	private String name;
	private int weight;
	private int height;
	
	public void 축구를잘한다()
	{
		System.out.println("축구를 잘한다.");
	}
	
	public void 고기를잘먹는다()
	{
		System.out.println("고기를 잘 먹는다.");
	}
	
	// lee와 비슷한 시기에 park도 보일러 수리기사가 되고싶어서 교육을 받았다
//	public void 보일러오류를점검한다()
//	{
//		System.out.println("보일러 오류 점검");
//	}
//	
//	public void 배수관교체를진행합니다()
//	{
//		System.out.println("배수관 교체를 진행합니다.");
//	}

	// 인터페이스가 쓰라는걸 쓰도록 교체
	@Override
	public void 보일러를점검한다()
	{
		// TODO Auto-generated method stub
		System.out.println("보일러점검하기");
	}

	@Override
	public void 배수관을교체한다()
	{
		// TODO Auto-generated method stub
			System.out.println("배수관교체하기"); // 이제 park은 자격증을 딴 수리기사가 되었다
	}
}

//***********************
//홍길동 객체 생성 + 사용

//아빠로서의 행동
interface 아빠
{
	void 아이와놀아주기();

	void 가족여행을한다();
}

//부장로서의 행동
interface 부장
{
	void 결재를한다();

	void 프로젝트를진행한다();
}

//인터페이스는 다중상속이 가능하다.(***)
class Person implements 아빠, 부장
{

	private String name;
	private int age;

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString()
	{
		return String.format("%s(%d)", this.name, this.age);
	}

	// 아빠로서의 행동
	public void 아이와놀아주기()
	{
		System.out.println("아이와 놀아준다.");
	}

	public void 가족여행을한다()
	{
		System.out.println("가족들과 여행을 간다.");
	}

	// 부장으로서의 행동
	public void 결재를한다()
	{
		System.out.println("결재를 한다.");
	}

	public void 프로젝트를진행한다()
	{
		System.out.println("프로젝트를 진행한다.");
	}

}

//인터페이스 선언
interface Phone
{

	// public int price;
	// public String color;

	// public final static int a = 10;

	// 구현 멤버
	// public int a;
	// public void test() { //Abstract methods do not specify a body
	// }

	// 추상 멤버만..
	void on();

	void off();

	void call();

}

class S25 implements Phone
{

	public int price;
	public String color;

	@Override
	public void on()
	{
		System.out.println("삼성 기술 > 전원 On");
	}

	@Override
	public void off()
	{
		System.out.println("삼성 기술 > 전원 Off");
	}

	@Override
	public void call()
	{
		System.out.println("삼성 기술 > 통화");
	}

}

class Iphone16 implements Phone
{

	public int price;
	public String color;

	@Override
	public void on()
	{
		System.out.println("애플 기술 > 전원 On");
	}

	@Override
	public void off()
	{
		System.out.println("애플 기술 > 전원 Off");
	}

	@Override
	public void call()
	{
		System.out.println("애플 기술 > 통화");
	}

}
