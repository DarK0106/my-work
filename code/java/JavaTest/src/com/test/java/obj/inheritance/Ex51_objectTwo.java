package com.test.java.obj.inheritance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex51_objectTwo
{
	public static void main(String[] args)
	{
		// Ex51_objectTwo.java
		
		// Object 클래스의 활용
		// Object 클래스는 모든 클래스의 부모 클래스이다/
		
		m1(); 
	}

	private static void m1()
	{
		AA a1 = new AA();
		AA a2 = new BB(); // 자식 객체를 부모 변수에 넣은 것, 업캐스팅
		AA a3 = new CC();
		
		// Object 변수는 만능 주머니이다
		// Object[] 배열
		Object o1 = new AA();
		Object o2 = new BB();
		Object o3 = new CC();
		
		Object o4 = new Scanner(System.in);
		Object o5 = new BufferedReader(new InputStreamReader(System.in));
		
		Object o6 = new lee();
		Object o7 = new Park();
		
		Object o8 = "홍길동"; // new String("홍길동")
		Object o9 = new int[3]; 
		
		// o4.nextLine(); // 오브젝트 껍데기라서 nextLine이 없음
		
		// 그래서 앞에 Scanner 붙여서 잠시 형변환해야함
		System.out.println("입력: ");
		String input = ((Scanner)o4).nextLine(); // o4 번호 헷갈리면 런타임오류
		System.out.println(input);
		
		System.out.println(o8); // 얘가 뭔 타입인지 instanceof 쓰면 되긴하는데 너무 귀찮음, 사람이 직접 기억하면서 써야함
		// Object에 들어갈 수 있는게 너무 많아서 쓸때마다 무슨 타입인지 확인해야하는 귀찮음이 있음
		
		// 조심해야 하는 것
		// 홍길동의 정보를 모두 다 넣으려고 시도
		// Object에 넣으니까 다 들어가네?
		// ***하지만 진짜로 하면 안되는 행동***
		// Object는 꺼낼 때 문제가 생긴다
		// 배열이라 가독성이 떨어짐
		// 
		Object[] list = new Object[5];
		
		list[0] = "홍길동";
		list[1] = 20;
		list[2] = true;
		list[3] = "서울시";
		list[4] = 170;
		
		// 배열을 쓰는 첫번째 이유? -> *루프를 돌릴 수 있기 때문이다*
		
		// 컴파일러가 봤을 때 20 +1 이 아니다
		// 컴파일러 눈에는 Object 파일의 무언가와 숫자 1을 더하고 있음
		// 모든 참조 주소는 산술 연산의 대상이 될 수 없다
		// System.out.println(list[1] + 1);
		System.out.println((int)list[1] + 1);
		
		for (int i = 0; i < list.length; i++)
		{
			System.out.println(list[i]); // 배열에 동일한 타입들이 들어가있다고 기대하고 있지만
			// 여러 타입의 자료형이 섞여있었다
			// 쓸거면 한 타입의 데이터만 써라
		}
	}
}


class AA // AA의 부모는 Object
{
	
}

class BB extends AA
{
	
}

class CC extends BB
{
	
}