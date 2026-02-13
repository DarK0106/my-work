package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex58_HashSet
{
	public static void main(String[] args)
	{
		// Ex58_HashSet.java
		/*
		 * 1. List
		 * - 순서가 있는 집합
		 * - 방 번호가 있기 때문, 첨자는 유일하다
		 * - 값 중복을 허용
		 * 
		 * 2. Map
		 * - 순서가 없는 집합
		 * - 키(방 이름) + 키는 유일하다
		 * - 값 중복을 허용
		 * 
		 * 3. Set
		 * - 순서가 없는 집합
		 * - 방을 구분하는 식별자 그 자체가 없다. 번호도 없고 이름도 없음 -> 방을 구분할 수 없음
		 * - 값의 중복을 허용하지 않음(*****)
		 * 
		 */
		
		
		// m1();
		// m2();
		// m3();
		m4();
		
		
	} // main

	private static void m4()
	{
		// User 가 들어있는 배열
		// 그걸 HashSet으로 만들어야하는 상황
		
		HashSet<User> group = new HashSet<User>();
		
		group.add(new User("홍길동", 20));
		group.add(new User("아무개", 22));
		group.add(new User("테스트", 25));
		group.add(new User("홍길동", 20)); // Set을 쓰는 유일한 목적 중복값을 허용하지 않는다
		// 근데 들어감 자바는 기본적으로 객체와 객체의 비교를 주소값으로 한다 그래서 들어감
		// 나는 이 둘(홍길동)을 같은 사람으로 인정해서 Set이 안 집어넣게 만들고 싶다
		
		System.out.println(group);
	}

	private static void m3()
	{
		int a1 = 10;
		int a2 = 20;
		int a3 = 10;
		
		System.out.println(a1 == a2); // false
		System.out.println(a1 == a3); // true
		System.out.println();
		
		User u1 = new User("홍길동", 20);
		User u2 = new User("아무개", 22);
		User u3 = new User("홍길동", 20);
		User u4 = u1; // 주소값을 복사한것
		
		// u1과 u3는 동일인? 동명이인?
		System.out.println(u1.equals(u2));
		System.out.println(u1.equals(u3)); // 주소에 가면 있는 값(홍길동)을 직접 비교한게 아니고 u1, u3 주소값만 비교한것
		System.out.println(u1.equals(u4)); // 주소값이 같으니 같다고 나옴
		System.out.println();
		
		// 사전 확인
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());
		System.out.println(u3.hashCode());
		System.out.println(u4.hashCode());
		
	}

	private static void m2()
	{
		// 로또 번호 -> 서로 다른 숫자 6개를 만들어내야하는 행동
		// 난수 + 유일한 번호
		
		Random rnd = new Random();
		
		// Case 1. ArrayList
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++)
		{
			int n = rnd.nextInt(45) + 1; // 1 ~ 45 <- 문제 : 중복값이 생김
			
			if (lotto.contains(n))
			{
				// 중복됨 <- 문제 : 중복을 거르긴 했는데 거른 숫자를 패스해버려서 
				// 숫자가 일정하게 6개 나오질 않음(5개만 나올때가있음)
				i--; // 중복될때마다 i 하나 줄여서 해결
			}
			else
			{
				// 중복되지 않음
				lotto.add(n); // 번호 넣기
				
			}
			
			
		}
		
		System.out.println(lotto);
		
//		while(lotto.size() < 6)
//		{
//			int n = rnd.nextInt(45) +1;
//			
//			if(!lotto.contains(n))
//			{
//				lotto.add(n);
//			}
//			
//		}
//		
//		System.out.println(lotto);
		
		
		// Case 2. HashSet
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		while(lotto2.size() < 6)
		{
			int n = rnd.nextInt(45) +1;
			lotto2.add(n); // 중복값 허용을 안하기 때문에 조건문 없어도 가능
		}
		
		System.out.println(lotto2);
		
		
	}

	private static void m1()
	{
		HashSet<String> set = new HashSet<String>();
		
		// 1. 요소 추가
		set.add("사과");
		set.add("딸기");
		set.add("딸기"); // 똑같은 값을 넣으면 안 넣음
		// System.out.println(set.add("딸기"));// 리턴값을 보면 처음 들어간건 true, 나중에 들어가는건 false 출력됨
		set.add("바나나");
		
		System.out.println(set); // toString은 읽기 아니고 개발자가 눈으로 확인하는 용도, 모든 덤프 메서드는 개발자를 위한 보조 도구이다
		
		// 2. 요소 개수 확인하기
		System.out.println(set.size());
		
		// Iterable 인터페이스의 구현체는(Iterable을 상속받은)
		// 1. 향상된 for문 사용 가능
		// 2. Iterator 대상 가능
		
		// 3. 요소 읽기
		// - 방을 구분할 수 없음 -> 원하는 방만 접근 불가능
		// - 전용 읽기 도구 존재(*****) -> Iterator
		
		for (String item : set)
		{
			System.out.println(item);
		}
		
		Iterator<String> iter = set.iterator();
		
		// iterator라는 걸 만드는 순간 화살표가 생기고, BOF(begin of file)을 가리킴
		// BOF(begin of file), EOF(end of file)
		// 화살표는 한번에 한칸씩 내려가는것밖에 못함
		// 화살표를 다른말로 커서라고함 <- 앞으로 가는 것 밖에 못함 <- 그래서 전진 커서라고 함
		System.out.println(iter.hasNext()); // 다음번 데이터가 있습니까?
		System.out.println(iter.next()); // 커서를 한칸 전진시킴 + 데이터를 읽음
		
		System.out.println(iter.hasNext());
		System.out.println(iter.next());
		
		System.out.println(iter.hasNext());
		System.out.println(iter.next());
		
		System.out.println(iter.hasNext()); // EOF, false 출력
//		System.out.println(iter.next()); // 강제로 커서 이동시키면 에러 발생
		
		// 처음부터 다시 읽고 싶다 ..
		System.out.println(set);
		
		iter = set.iterator(); // 이터레이터를 다시 만들어야 한다(유일한 초기화 방법)
		
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		for (String item : set)
		{
			System.out.println(item);
		}
		
		
		
	}
}

class User
{
	private String name;
	private int age;
	
	public User(String name, int age)
	{
		this.name = name;
		this.age = age;
		
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s(%d)", this.name, this.age);
	}
	
	// 값이 동일한 객체를 진짜 같은 객체로 취급하게 하려면..
	// 1. hashCode() 재정의
	// 2. equals() 재정의
	
	
	@Override
	public int hashCode() // User 클래스의 해시코드
	{	
//		System.out.println("홍길동: " + "홍길동".hashCode());
//		System.out.println("홍길동: " + "홍길동2".hashCode());
		
		
		// 이름과 나이가 동일하면 같은 해시코드를 반환하게 만들자
		// - "홍길동20"
		// - "아무개22"
		return (this.name + this.age).hashCode(); // 문자열이 원래 가지고 있는 해시코드 메서드
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// u1.equals(u2)
		
		// return super.equals(obj); -> 메모리 주소값 비교
		
//		User u2 = (User)obj;
		
//		return this.name.equals(u2.getName()) && this.age == u2.getAge();
		
		return this.hashCode() == obj.hashCode();
	}
	
}
