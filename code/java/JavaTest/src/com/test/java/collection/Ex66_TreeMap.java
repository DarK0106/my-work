package com.test.java.collection;

import java.util.TreeMap;

public class Ex66_TreeMap {
	
	public static void main(String[] args) {
		
		//Ex66_TreeMap.java
		
		//TreeMap = Tree(이진 탐색 구조) + Map(키, 값)
		
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		map.put("red", "사과");
		map.put("orange", "귤");
		map.put("yellow", "바나나");
		map.put("green", "아보카도");
		map.put("blue", "블루베리");
		
		System.out.println(map); // 트리 구조의 특징 자동정렬
		System.out.println(map.get("yellow"));
		
		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
		
		System.out.println(map.headMap("m")); // m으로 시작하는 키값 바로 전 까지
		System.out.println(map.tailMap("m")); // m으로 시작하는 키값 뒤 까지
		System.out.println(map.subMap("c", "m"));
		
	}

}
