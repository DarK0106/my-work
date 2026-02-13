package com.test.java.collection;

import java.util.TreeSet;

public class Ex65_TreeSet {
	
	public static void main(String[] args) {
		
		//Ex65_TreeSet.java
		/*
		
			컬렉션 이름 패턴
			
			[물리구조]	[사용법(인터페이스)]
			Array 		List
			Linked 		List
			
			Hash 		Set
			Tree 		Set
			
			Hash 		Map
			Tree 		Map
		
			
			TreeSet
			- 방 식별자가 없다.
			- 중복값을 가지지 않는다.(***)
			- 내부 요소가 자동으로 정렬된다.
			- 유일값 + 자동 정렬
			- 내부에 트리구조를 사용해서 데이터를 저장
				- 이진 탐색 트리 구조 > 레드-블랙 트리(균형 잡힌 이진 트리)
			
		*/
		
		//HashSet<Integer> set = new HashSet<Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(5);
		set.add(3);
		set.add(6);
		set.add(2);
		set.add(1);
		set.add(8);
		set.add(7);
		set.add(9);
		set.add(4);
		set.add(10);
		
		System.out.println(set);
		
		
		for (int n : set) {
			System.out.println(n);
		}
		System.out.println();
		
		//자동 정렬 > 추가 기능
		System.out.println(set.first());
		System.out.println(set.last());
		
		System.out.println(set.headSet(3));
		System.out.println(set.tailSet(7));
		System.out.println(set.subSet(3, 7));	
		
	}

}











