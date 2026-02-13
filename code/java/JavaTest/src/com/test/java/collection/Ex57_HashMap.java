package com.test.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Ex57_HashMap
{
	public static void main(String[] args)
	{
		// Ex57_HashMap.java
		/*
		 * 제일 많이 사용되는 컬렉션들
		 * List -> ArrayList
		 * Map -> HashMap
		 * Set -> HashSet
		 * 
		 * 모든 컬렉션은 제네릭이다?
		 * 
		 * List 계열
		 * - 요소를 관리하는데 있어서 첨자(index)를 사용한다 -> 방 번호가 존재한다
		 * - 방 번호가 있다는 것은 순서가 있는 집합(방 번호 = 요소의 순서)이라는 것
		 * ex) 1강의실, 2강의실, 3강의실
		 * - 이런 배열을 스칼라 배열이라고 함(Scalar Array)
		 * - 요소(Element) = 첨자(index) + 값(value)
		 * - 첨자(index)는 유일하다(중복될 수 없다).
		 * - 값(value)은 중복이 가능하다.
		 * 
		 * Map 계열
		 * - 요소 관리 -> 키(Key) 사용 -> 방 이름
		 * ex) 햇님반, 달님반, 별님반
		 * 순서가 중요하지 않아 순서가 없는 집합
		 * - 연관 배열, 사전 구조(Dictionary) 라고 함
		 * - 요소(Element) = 키(key) + 값(value)
		 * - 키(key) 역시 첨자와 같이 유일하다.
		 * - 값(value)은 중복이 가능하다.
		 * 
		 */
		
		// m1();
		// m2();
		m3();
		
	} // main

	private static void m3()
	{
		HashMap<String, String> map = new HashMap<String, String>(); // 방 이름도 문자열, 안에 들어가는 값도 문자열
		
		// 1. 요소 추가
		map.put("red", "장미");
		map.put("yellow", "개나리");
		map.put("blue", "라일락");
		map.put("white", "백합");
		
		// Map -> 원래는 안되지만 루프를 돌리고 싶다
		// Can only iterate over an array or an instance of java.lang.Iterable
		// for (Object o : map) { } <- 못함
		
		// 자주 쓰진 않지만 가끔 필요함
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		for (String key : keys)
		{
			System.out.println(key + ":" + map.get(key));
		}
		
		Collection<String> values =  map.values();
		System.out.println(values);
		
	}

	private static void m2()
	{
		HashMap<String, String> map = new HashMap<String, String>(); // 방 이름도 문자열, 안에 들어가는 값도 문자열
		
		// 1. 요소 추가
		map.put("red", "장미");
		map.put("yellow", "개나리");
		map.put("blue", "라일락");
		
		// 2. 요소 개수 확인하기
		// 모든 컬렉션들은 size를 갖는다
		System.out.println(map.size());
		
		// 3. 요소 읽기 -> 루프는 못함 -> 루프 할거면 List를 써야함
		System.out.println(map.get("yellow"));
		
		// 4. 요소 수정하기
		map.put("yellow", "영춘화");
		System.out.println(map); // toString이 오버라이드 되어있다
		
		// 5. 요소 삭제하기
		map.remove("yellow");
		System.out.println(map); // 왜 yellow가 뒤로 갔을까? -> 어차피 순서가 없기 때문 -> 자바가 정한 알고리즘에 따라 알아서 배치된것
		
		// 6. 요소 검색하기
		System.out.println(map.containsKey("red"));
		System.out.println(map.containsValue("개나리"));
		
		map.clear();
		
		// 비어있는 배열인지 확인하기
		System.out.println(map.isEmpty());
		
	}

	private static void m1()
	{
		// 요구사항) 학생 1명의 국어 영어 수학 점수를 저장 + 관리
		// 1. 배열을 쓸 수 있을까?
		// 2. ArrayList
		// 3. Class 
		// 4. HashMap
		
		// 1. 배열 <- 이 상황에 적합하진 않다
		// - 집합
		// - 방 번호를 보고 무슨 과목인지 알아보기 힘들다
		// - 루프 가능
		int[] s1 = new int[3];
		
		s1[0] = 100;
		s1[1] = 90;
		s1[2] = 80;
		
		System.out.println(s1[0] + s1[1] + s1[2]);
		
		// 2. ArrayList
		// - 집합
		// - 방 번호를 보고 무슨 과목인지 알아보기 힘들다
		// - 루프 가능
		// - 가변 길이
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		
		s2.add(100);
		s2.add(90);
		s2.add(80);
		
		System.out.println(s2.get(0) + s2.get(1) + s2.get(2));
		
		// 3. Class
		// - 집합
		// - 방 번호를 쓰지 않고 방의 이름을 사용해 가독성이 높다
		// - 클래스를 생성해야 하는 초기 비용이 발생한다
		
		Student s3 = new Student();
		
		s3.setKor(100);
		s3.setEng(90);
		s3.setMath(80);
		
		System.out.println(s3.getKor() + s3.getEng() + s3.getMath());
		
		// 4. HashMap
		// - 집합
		// - 방 번호를 쓰지 않고 방의 이름을 사용해 가독성이 높다
		// class와 비슷한 느낌이다?
		// 내부 멤버를 식별자로 관리한다
		// 초기 비용 무료
		// 설계도가 없고 즉석으로 만들어서 사용가능
		// 클래스면 kor 설계도에 맞게 kor만 쓸 수 있는데 
		// HashMap은 kox koa 즉석으로 생성 가능
		HashMap<String, Integer> s4 = new HashMap<String, Integer>();
		
		s4.put("kor", 100);
		s4.put("eng", 90);
		s4.put("math", 80);
		
		System.out.println(s4.get("kor") + s4.get("eng") + s4.get("math"));
		
	}
}

class Student // 학생들의 성적
{
	private int kor;
	private int eng;
	private int math;
	
	// Getter, Setter
	public int getKor()
	{
		return kor;
	}
	public void setKor(int kor)
	{
		this.kor = kor;
	}
	public int getEng()
	{
		return eng;
	}
	public void setEng(int eng)
	{
		this.eng = eng;
	}
	public int getMath()
	{
		return math;
	}
	public void setMath(int math)
	{
		this.math = math;
	}
	
	
}