package com.test.java.ui;

import java.util.List;
import java.util.Scanner;

import com.test.java.dto.AddressDto;

public class AddressUi
{
	public static void mainMenu()
	{
		System.out.println("======================================");
		System.out.println("               🏠주소록");
		System.out.println("======================================");

		System.out.println("1. 주소록 목록보기");
		System.out.println("2. 주소록 추가하기");
		System.out.println("3. 주소록 삭제하기");
		System.out.println("4. 주소록 검색하기");
		System.out.println("5. 종료");

		System.out.println("선택(번호): ");
	}

	public static void closedMessage()
	{
		System.out.println();
		System.out.println("💬 주소록을 종료합니다.");
		System.out.println();
	}

	public static void pause()
	{
		// 각 메뉴 실행이 끝난 뒤 프로그램을 알사 중지
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("💬 계속하시려면 엔터를 입력하세요.");

		scan.nextLine();

	}

	public void printList(List<AddressDto> list)
	{
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("                         1. 주소록 목록보기");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();

		// 1. 헤더 (제목) 출력
		// 제목에는 [괄호]와 한글이 섞여 있어서 데이터보다 조금 더 좁게 잡아야 합니다.
		System.out.printf("%-6s %5s %-6s %-17s %s\n", "[이름]", "[나이]", "[성별]", "[전화]", "[주소]");

		list.sort((a, b) -> a.getName().compareTo(b.getName()));

		for (AddressDto dto : list)
		{
			// 2. 데이터 출력 (여기가 핵심!)
			// 한글 이름(3글자)이 [이름](4글자)보다 글자 수는 적지만 너비는 비슷하게 맞추기 위해
			// 숫자를 미세 조정했습니다. (%-7s, %9s, %-8s 등)
			System.out.printf("%-7s %9s %-8s %-17s %s\r\n", dto.getName(), dto.getAge(),
					dto.getGender().equals("1") ? "남자" : "여자", dto.getTel(), dto.getAddress());
		}

	}

	public final static int ADD = 2;
	public final static int DELETE = 3;

	public void completedMessage(int num)
	{
		String message = "";

		if (num == 2)
		{
			message = "💬 주소록을 추가했습니다.";
		} else if (num == 3)
		{
			message = "💬 주소록을 삭제했습니다.";
		}

		System.out.println();
		System.out.println(message);
	}

	public void subMenu(String title)
	{
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println(" " + title);
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println();
	}

}
