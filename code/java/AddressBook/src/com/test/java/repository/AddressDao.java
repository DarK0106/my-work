package com.test.java.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.test.java.dto.AddressDto;

// 파일 입출력 담당자
// DAO(Data Access Object) -> 데이터를 직접 조작하는 업무를 맡는 객체
public class AddressDao
{
	private final String PATH;

	public AddressDao()
	{
		this.PATH = ".\\data\\address.txt";
	}

	public List<AddressDto> list()
	{
		// address 텍스트 파일의 내용을 읽어서 그걸 반환
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH));)
		{

			String line = null;
			List<AddressDto> list = new ArrayList<AddressDto>(); // ArrayList를 자기한테 일을 시킨 사람에게 돌려주자

			while ((line = reader.readLine()) != null)
			{
				// Raw Data(line)
				// 김민수,25,1,010-1234-5678,서울시 강남구 역삼동 101-2

				// 파싱(Parsing)
				String[] temp = line.split(",");

				// Raw Data 를 포장해서 AddressDto 구조를 갖는 객체로 만들어서 관리한다
				AddressDto dto = new AddressDto();

				dto.setName(temp[0]);
				dto.setAge(temp[1]);
				dto.setGender(temp[2]);
				dto.setTel(temp[3]);
				dto.setAddress(temp[4]);

				list.add(dto);

			} // while

			return list; // 주소록 목록( = list<AddressDto>)

		} catch (Exception e)
		{
			System.out.println("AddressDao.list() 예외 발생");
			e.printStackTrace();
		}

		return null; // 목록에 아무도 없을 때
	}

	public void add(AddressDto dto)
	{
		// Dto -> 항목들을 가져와서 -> 파일에 쓰기
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true)))
		{

			// 파일입출력은 파일이 없으면 알아서 생성함
			// 그래서 PATH로 만듦

			// 김민수,25,1,010-1234-5678,서울시 강남구 역삼동 101-2
			String line = String.format("%s,%s,%s,%s,%s", dto.getName(), dto.getAge(), dto.getGender(), dto.getTel(),
					dto.getAddress());

			writer.write(line);
			writer.write("\r\n");

		} catch (Exception e)
		{
			System.out.println("AddressDao.add() 예외 발생");
			e.printStackTrace();
		}
	}

	public void delete(String name)
	{
		try
		{
			// 파일에서 원하는 줄(한사람)을 삭제하는 것
			// 문제) 텍스트 입출력에는 삭제라는 행위, 개념 자체가 없다
			// 가나다라마 에서 가나라마 는 다를 삭제한게 아니고 가나라마로 덮어쓰기한것
			// 그래서 덮어쓰기로 해결해야함
			BufferedReader reader = new BufferedReader(new FileReader(PATH));

			String wholeText = "";
			String line = null;

			while ((line = reader.readLine()) != null)
			{
				if (!line.startsWith(name))
				{
					wholeText += line + "\r\n"; // 문자열 조작을 통해서 원하는 부분만 제거를 하고
					// 나머지 부분을 덮어씌워서 삭제 작업을 하는것
				}
			}

			reader.close();

			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));

			// System.out.println(wholeText);
			writer.write(wholeText);

			writer.close();

		} catch (Exception e)
		{
			System.out.println("AddressDao.delete() 예외 발생");
			e.printStackTrace();
		}
	}

	public List<AddressDto> search(String word)
	{

		// address 텍스트 파일의 내용을 읽어서 그걸 반환
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH));)
		{

			String line = null;
			List<AddressDto> list = new ArrayList<AddressDto>(); // ArrayList를 자기한테 일을 시킨 사람에게 돌려주자

			while ((line = reader.readLine()) != null)
			{
				// Raw Data(line)
				// 김민수,25,1,010-1234-5678,서울시 강남구 역삼동 101-2

				// 파싱(Parsing)
				String[] temp = line.split(",");

				// Raw Data 를 포장해서 AddressDto 구조를 갖는 객체로 만들어서 관리한다
				if (temp[4].replace(" ", "").contains(word.replace(" ", "")))
				{
					AddressDto dto = new AddressDto();

					dto.setName(temp[0]);
					dto.setAge(temp[1]);
					dto.setGender(temp[2]);
					dto.setTel(temp[3]);
					dto.setAddress(temp[4]);

					list.add(dto);
				}

			} // while

			return list; // 주소록 목록( = list<AddressDto>)

		} catch (Exception e)
		{
			System.out.println("AddressDao.list() 예외 발생");
			e.printStackTrace();
		}

		return null; // 목록에 아무도 없을 때

	}

}
