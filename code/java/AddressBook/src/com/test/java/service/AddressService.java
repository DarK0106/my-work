package com.test.java.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.test.java.dto.AddressDto;
import com.test.java.repository.AddressDao;
import com.test.java.ui.AddressUi;

public class AddressService
{

	private AddressDao dao = new AddressDao();
	private AddressUi ui = new AddressUi();

	public AddressService()
	{
		this.dao = new AddressDao();
		this.ui = new AddressUi();
	}

	public void list()
	{
		// 주소록 목록 보기

		List<AddressDto> list = dao.list();

		ui.printList(list);

	}

	// AddressService.add
	public void add()
	{
		// 주소록 추가하기
		// 파일에 쓰기 작업을 해야함 -> AddressDao에게 위임
		
		// 사용자로부터 내용을 입력받기
		// 입력받은 내용을 Dao에게 전달
		// 파일에 쓰기 작업
		ui.subMenu("2. 주소록 목록보기");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름: ");
		String name = scan.nextLine();
		
		System.out.println("나이: ");
		String age = scan.nextLine();
		
		System.out.println("성별(남자(1), 여자(2)): ");
		String gender = scan.nextLine();
		
		System.out.println("전화: ");
		String tel = scan.nextLine();
		
		System.out.println("주소: ");
		String address = scan.nextLine();
		
		// 권장 사항
		// 계층과 계층 간에 데이터를 전달할 때에는
		// 되도록이면 상자에 담아서 넘겨라
		AddressDto dto = new AddressDto();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		dao.add(dto);
		
		ui.completedMessage(AddressUi.ADD);
		
	}

	public void delete()
	{
		// 주소 삭제하기
		// 사용자가 삭제하려는 이름을 입력 -> 파일 내에서 해당 정보를 삭제하는 기능
		ui.subMenu("3. 주소록 삭제하기");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름: ");
		String name = scan.nextLine();
		
		dao.delete(name);
		
		ui.completedMessage(AddressUi.DELETE);
	}

	public void search()
	{
		// 주소록 검색하기
		// 검색어를 입려해서 Dao 에게 결과 반환
		ui.subMenu("4. 주소록 검색하기");
		Scanner scan = new Scanner(System.in);
		System.out.println("검색어 ");
		String word = scan.nextLine();
		
		List<AddressDto> list = dao.search(word);
		
		ui.printList(list);
	}

}
