package com.test.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex64_LinkedList
{
	public static void main(String[] args)
	{
		/*
		 * 
		 * 대표적인 List 인터페이스 - ArrayList - LinkedList
		 * 
		 * 이 둘은 사용법은 동일하지만 내부 구조가 다르다 -> 사용 목적이 다르다
		 * 
		 * 인터페이스의 역할? 추상 메서드
		 * 
		 * LinkedList에도 종류가 있다? 1. LinkedList (다음 방의 주소를 넣는 방식) 2. Double LinkedList (다음
		 * 방의 주소랑 이전 방의 주소 둘 다 넣는다고해서 double이 붙음) 3. 첫번째방에서 이전방의주소값을 넣는 곳이 비어있고, 마지막 방의
		 * 다음 방의 주소값을 넣는 곳이 비어있어서 여길 비워두지 말고, Double Circular LinkedList 라고 한다. 순환 구조를
		 * 갖고 있어서 원형이라고 한다 -> 자바, 현대의 LinkedList
		 * 
		 * 배열을 읽기 작업만 한다면 ArrayList로 쓰는게 좋다. 성능은 LinkedList가 느리다 체인이 ㅇ-ㅇ-ㅇ-ㅇ-ㅇ 이렇게
		 * 되어있었는데 중간에 ㅇ 하나가 빠졌다 그러면 그냥 ㅇ-ㅇ-ㅇ-ㅇ 이렇게 중간에 하나 빼버리면 그만 그래서 조작하는거에 탁월한 배열이
		 * LinkedList 중간에 계속 넣다뺐다를 해야한다면 LinkedList
		 * 
		 * 
		 * 
		 */

		// m1();
		m2();
		// m3();

	} // main

	private static void m3()
	{
		ArrayList<String> names = new ArrayList<String>();

		names.add("빨강"); // 0
		names.add("주황"); // 0
		names.add("노랑"); // 1
		names.add("초록"); // 1
		names.add("파랑"); // 2 <- 모두 시프트 발생

		// 순서가 있는 List 계열을 루프를 돌면서 요소를 추가하거나 삭제할 때는 방번호가 변경되는것을 주의하라
		// 시프트가 발생하기 때문
//		for (int i = 0; i < names.size(); i++)
//		{
//			System.out.println(names.get(i));
//			names.remove(i);
//		}
//		
//		System.out.println(names); // 다 못지웠음, names.size()때문에 그럼
//		// 루프돌다보니까 size가 계속 줄어서 돌다가 말음, 시프트도 발생함

		// List 계열의 루프 + 요소추가/삭제 > *** 방번호가 변경 주의!!!(시프트)
		for (int i = names.size() - 1; i >= 0; i--)
		{
			// System.out.println(names.get(i));
			names.remove(i);
		}

		System.out.println(names);

	}

	private static void m2()
	{
		// ArrayList와 LinkedList의 속도를 재보자
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		// 스톱워치용 변수, 시작~끝
		long begin = 0, end = 0;

		// 1768523419106 ms (1초 / 1000)
		System.out.println(System.currentTimeMillis());
		// 1978886982000 ns (1초 / 10억)
		System.out.println(System.nanoTime());

		// 1. 순차적으로 데이터를 추가하기, Append
		System.out.println("[1. 순차적으로 데이터 추가하기, Append]");

		begin = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++)
		{
			list1.add(i);
		}

		end = System.currentTimeMillis();

		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);

		// 1. 순차적으로 데이터를 추가하기, Append / LinkedList 는 어떨까
		begin = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++)
		{
			list2.add(i);
		}

		end = System.currentTimeMillis();

		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);

		// 2. 중간에 데이터 추가하기(새치기), Insert
		// 시프트 발생
		// ArrayList는 이 작업을 힘들어하고, LinkedList는 쉽게 하는지 확인하자

		System.out.println("[2. 중간에 데이터 추가하기(새치기), Insert]"); // 맨앞에 끼어들면 중간에 그만둬야함 너무 오래 걸려서 안 끝남

		begin = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) // 너무 오래 걸려서 100만 -> 10만으로 줄임
		{
			list1.add(0, i); // 맨 앞에 끼어들기
		}

		end = System.currentTimeMillis();

		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);

		// 2. 중간에 데이터 추가하기(새치기), Insert / LinkedList
		begin = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++)
		{
			list2.add(0, i);
		}

		end = System.currentTimeMillis();

		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);

		// 3. 중간에 데이터 삭제하기, Delete
		// 시프트 발생

		System.out.println("[3. 중간에 데이터 삭제하기, Delete]");

		begin = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++)
		{
			list1.remove(0);
		}

		end = System.currentTimeMillis();

		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);

		// 3. 중간에 데이터 삭제하기, Delete / LinkedList
		begin = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++)
		{
			list2.remove(0);
		}

		end = System.currentTimeMillis();

		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);

		// 4. 순차적으로 데이터 삭제하기, Delete
		System.out.println("[4. 순차적으로 데이터 삭제하기, Delete]");

		begin = System.currentTimeMillis();

		for (int i = list1.size() - 1; i >= 0; i--)
		{
			list1.remove(i);
		}

		end = System.currentTimeMillis();

		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);

		// 4. 순차적으로 데이터 삭제하기, Delete / LinkedList
		begin = System.currentTimeMillis();

		for (int i = list2.size() - 1; i >= 0; i--)
		{
			list2.remove(i);
		}

		end = System.currentTimeMillis();

		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);

	}

	private static void m1()
	{
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		list1.add(100);
		list1.add(200);
		list1.add(300);

		list2.add(100);
		list2.add(200);
		list2.add(300);

		System.out.println(list1.size());
		System.out.println(list2.size());

		System.out.println(list1.get(0));
		System.out.println(list2.get(0));

		System.out.println(list1.indexOf(200));
		System.out.println(list2.indexOf(200));

		for (int n : list1)
		{
			System.out.println(n);
		}

		for (int n : list2)
		{
			System.out.println(n);
		}

	}
}
