package com.test.java.collection;

import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class Ex67_Collection
{
	public static void main(String[] args)
	{
		/*
		 * 
		 * - Vector // 거의안씀 ArrayList로 대체됨
		 * - HashTable // 거의안씀 HashMap으로 대체됨
		 * 스레드라는 작업을 할때 안전(safe) + 동기화 지원 을 하냐 안하냐 할 때 가끔 씀
		 * - Properties
		 * 
		 */

		// m1();
		m2();

		/*
		 * List -> 방번호를 사용한 순서가 있는 집합을 필요로 할때
		 * - ArrayList -> 보편적인 선택
		 * - LinkedList -> 잦은 조작이 필요할 때
		 * 
		 * 
		 * Set -> 방번호든뭐든 아무런 식별자가없지만 유일한 값을 관리를 해야할 때
		 * - HashSet -> 보편적인 선택
		 * - TreeSet -> 자동 정렬이 필요할 때
		 * 
		 * 
		 * Map -> 방에 이름이 필요할 때
		 * - HashMap -> 보편적인 선택
		 * - TreeMap -> 자동 정렬이 필요할 때
		 * 
		 * 
		 */
	}

	private static void m2()
	{
		// Properties
		// 어떤 옵션이나 어떤 객체나 프로그램의 상태값을 저장하는 용도
		// Map과 비슷하게 생겼다 Map의 하위버전 느낌?

		Properties prop = new Properties();

		prop.put("color", "red");
		prop.put("font-size", "18px");
		prop.put("font-family", "JetbrainsMono");

		System.out.println(prop.get("font-family"));

		try
		{
			// XML, JSON으로 대체됨
			prop.store(new FileOutputStream(".\\setting.ini"), "환경설정"); // 새로고침 해야 보임
		} catch (Exception e)
		{
			System.out.println("Ex67_Collection.m2() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}

	}

	private static void m1()
	{
		// Vector
		Vector<String> list = new Vector<String>();

		list.add("하나");
		list.add("둘");
		list.add("셋");

		System.out.println(list.size());

		System.out.println(list.get(0));

		// HashTable
		Hashtable<String, Integer> map = new Hashtable<String, Integer>();

		map.put("kor", 100);
		map.put("eng", 90);
		map.put("math", 80);

		System.out.println(map.get("kor"));

		// Vector, HashTable은 동기화 지원이 되어 멀티스레드 환경에서 안전하다. 하지만 느리다.

		// ArrayList와 HashMap은 동기화 지원이 되지 않아 멀티스레드 환경에 불완전하다. 우리가 직접 동기화 작업을 처리함
		// 상대적으로 속도가 빠르다 -> JDK 1.2

	}
}
