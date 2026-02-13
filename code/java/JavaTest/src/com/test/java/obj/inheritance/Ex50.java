package com.test.java.obj.inheritance;

public class Ex50
{
	public static void main(String[] args)
	{
		// Ex50.java
		/*
		 * 
		 * 1. 추상 클래스 또는 인터페이스를 사용하는 상황 1-1. 지금은 추상 클래스만 사용함 2. 어떨 떄 참조형 캐스팅(업캐스팅,
		 * 다운캐스팅)을 하는가?
		 * 
		 * 상황) 난 프린터 판매를 하는 대리점을 운영중이다 
		 * 1. LG100이라는 프린터가 5대, HP200이라는 프린터가 3대 있다 
		 * 2. 날마다(자주 반복한다는게 핵심, 반복되는 작업에 대한 효율성) 제품을 점검하는데, 출력이 잘 되는지 확인하는 작업을 한다
		 * 
		 * 추가 상황) 1. 프린터 재고 증가 - LG100 -> 500대 - HP200 -> 300대
		 * 
		 * 2. 프린터 종류 증가 - Dell300 - BenQ400
		 * 
		 * 3. 브랜드별 고유 기능 점검 - LG1 -> selfTest() - HP200 -> ai() - Dell300 -> checkInk()
		 * 
		 */

		// m1();
		// m2();
		m3();

	} // main

	private static void m3()
	{
		// 프린터라는 추상 클래스와 lg100 hp200 dell300은 부모 자식 관계이다
		LG100 lg1 = new LG100();
		Printer p1;
		p1 = lg1;

		// 자식 개체를 온전하게 사용할 수 없다. 부모 껍데기로 들어갔기 때문(일부 기능 사용 불가)
		// 그럼에도 불구하고 부모 껍데기로 들어가야 하는 상황
		Printer p2 = new LG100(); // 자식객체를 만들자마자 부모타입으로 형변환해서 참조변수?
		Printer p3 = new HP200(); // 업캐스팅

		// 배열의 특성: 같은 자료형의 집합
		// 이것도 껍데기는 Printer 배열이지만, 다른 자료형(LG100, HP200)이 들어있다
		// 참조형의 형변환을 이용한 것
		// 이 때 주로 업캐스팅을 사용한다
		// 형제뻘 객체들의 집합을 만들기 위해 사용한다
		// 같은 타입의 변수 두개는 배열로 만들 수 있다
		Printer[] ps = new Printer[2];
		ps[0] = new LG100();
		ps[1] = new HP200();

		// --------------------------------------------
		Printer[] list = new Printer[10]; // LG 프린터 5대, HP 프린터 3대 + Dell 프린터 2대 추가 -> 조건문 수정
		// 부모 껍데기를 만드는 이유가 형제 그룹을 묶기 좋기 때문이다

		for (int i = 0; i < list.length; i++)
		{
			if (i < 5)
			{
				list[i] = new LG100();
			} else if (i < 8)
			{
				list[i] = new HP200();
			} else
			{
				list[i] = new Dell300();
			}
		}

		// 점검 시간
		// 1. 상속으로 인한 추상 메서드를 구현, 제품의 종류와 상관없이 동일한 제품 테스트 가능
		for (int i = 0; i < list.length; i++)
		{
			// LG도 아니고 HP도 아닌 Printer 배열 껍데기인 상황
			list[i].print("테스트");
			
			// 부모 배열에서 모든 형제를 관리하다가 가끔 필요에 따라 자식이 직접 구현한 멤버를 호출할 일이 생길 때(추가 상황 3)
			// 부모 껍데기에서 자식 타입으로 변경하는 것
			// 다운 캐스팅이라고 한다
//			if (i < 5)
//			{
//				((LG100)list[i]).selfTest(); // 형변환을 먼저 시키려면 괄호를 쳐 우선순위를 높여줘야 한다
//			}
//			else if ( i < 8)
//			{
//				((HP200)list[i]).ai();
//			}
//			else
//			{
//				((Dell300)list[i]).checkInk();
//			}
			// 형제끼리는 형변환이 절대 불가능해서 오류가 나기 시작함, 그래서 조건문 활용
			// 이 방식의 단점: 복잡해짐
			
			// 연산자
			// 2항 연산자
			// A(객체) instance of B(타입) <- A 객체가 B 타입이냐?
			// 아무거나 하나 꺼내서 너 누구의 인스턴스니? 라고 물어봄
			// System.out.println(list[i] instanceof LG100); // i 번째 방에 LG 타입일때는 true
			
			if (list[i] instanceof LG100)
			{
				((LG100)list[i]).selfTest();
			}
			else if (list[i] instanceof HP200)
			{
				((HP200)list[i]).ai();
			}
			else
			{
				((Dell300)list[i]).checkInk();
			}
			
		}

	} // m3

	private static void m2()
	{
		// Case 2.
		// 배열 사용
		LG100[] lg = new LG100[5];
		/*
		 * LG100 lg1; LG100 lg2; LG100 lg3; LG100 lg4; LG100 lg5; <- 이거랑 똑같은거임
		 */

		// lg[0].print("테스트"); / NullPointerException <- 아무 주소값도 없어서 포인터가 어디로 가야하는지 모름

		HP200[] hp = new HP200[3];

		// 새로 매입한 Dell300 프린터의 배열 먼저 만들기
		Dell300[] dell = new Dell300[3];

		// 프린터기 만드는 과정
		for (int i = 0; i < lg.length; i++)
		{
			lg[i] = new LG100();
		}

		for (int i = 0; i < hp.length; i++)
		{
			hp[i] = new HP200();
		}

		for (int i = 0; i < dell.length; i++)
		{
			dell[i] = new Dell300();
		}

		// 프린터 점검 시간
		for (int i = 0; i < lg.length; i++)
		{
			lg[i].print("테스트");
			lg[i].selfTest();
		}

		for (int i = 0; i < hp.length; i++)
		{
			hp[i].print("테스트");
			hp[i].ai();
		}

		for (int i = 0; i < dell.length; i++)
		{
			dell[i].print("테스트");
			dell[i].checkInk();
		}
	}

	private static void m1()
	{
		// Case 1.
		// 비효율적

		LG100 lg1 = new LG100();
		LG100 lg2 = new LG100();
		LG100 lg3 = new LG100();
		LG100 lg4 = new LG100();
		LG100 lg5 = new LG100();

		HP200 hp1 = new HP200();
		HP200 hp2 = new HP200();
		HP200 hp3 = new HP200();

		// 점검 시간
		lg1.print("테스트");
		lg2.print("테스트");
		lg3.print("테스트");
		lg4.print("테스트");
		lg5.print("테스트");

		hp1.print("테스트");
		hp2.print("테스트");
		hp3.print("테스트");
	}
}

abstract class Printer // 어쩔 수 없이 추상 클래스를 써야한다
{
	private String color;
	private int price; // 공통으로 구현된걸 부모에 올려서 코드를 재사용해 코드 길이를 줄였다

	// 모든 프린터 기기가 출력을 할 때 꼭 이 사용법으로 출력하도록 만들어주세요
	public abstract void print(String txt); // 행동을 표준화해서 강제력 부여
}

class LG100 extends Printer
{

	private int width; // 가로
	private int height; // 세로

	// 출력 기능
//	public void output(String txt)
//	{
//		System.out.println("LG100 출력: " + txt);
//	}

	// 프린터가 고장이 나면 AS 센터를 가지 않고, 프린터에 있는 버튼을 누르면 자가 진단을 진행함
	public void selfTest()
	{
		System.out.println("자가 진단을 합니다.");
	}

	// 부모가 시키는대로, 공식적으로 인증받은 출력 방법만 사용하도록 변경(공통된 사용법)
	@Override
	public void print(String txt)
	{
		System.out.println("LG100 출력: " + txt); // 안에 내용물은 알아서 고쳐서 쓰되, 이름에 벗어나지 않는 기능으로
	}
}

class HP200 extends Printer
{
	private String description;
	private String sizes;

	// 출력 기능
//	public void printing(String msg) // LG 프린터와 HP 프린터가 출력 방식을 통일하지 않았다
//	{
//		System.out.println("HP200 출력: " + msg);
//	}

	// AI 기능이 탑재된 프린터기
	public void ai()
	{
		System.out.println("출력 내용을 편집합니다.");
	}

	// 부모가 시키는대로, 공식적으로 인증받은 출력 방법만 사용하도록 변경(공통된 사용법)
	@Override
	public void print(String txt)
	{
		System.out.println("HP200 출력: " + txt);
	}
}

// 새로운 Dell300 프린터
class Dell300 extends Printer
{
	private String type;

	@Override
	public void print(String txt)
	{
		System.out.println("Dell300 출력: " + txt);
	}

	public void checkInk()
	{
		System.out.println("잉크량 점검");
	}
}