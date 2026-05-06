package com.test.java;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Main.java
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("===== 게시판 =====");
			System.out.println("1. 목록보기");
			System.out.println("2. 글쓰기");
			System.out.println("3. 종료");
			System.out.println("==================");
			System.out.println("입력(번호): ");

			switch (scan.nextInt()) {
			case 1:
				list();
				break;
			case 2:
				add();
				break;

			default:
				System.out.println("게시판 종료");
				return;
			}
			
		}
	}
	
	private static void list() {
		System.out.println("게시판 목록 보기");
	}
	
	private static void add() {
		System.out.println("게시판 글쓰기");
		System.out.println();
		System.out.println();
	}
	
}
