package com.test.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Ex60_FileIO
{
	public static void main(String[] args)
	{
		// Ex60_FileIO.java
		/*
		 * 
		 * 파일 입출력 - 자바 프로그램 -> 영구적으로 보호해야하는 데이터 -> 보조 기억장치(HDD, SSD): 쓰기(출력, 저장) - 자바
		 * 프로그램 <- 영구적으로 보호해야하는 데이터 <- 보조 기억장치(HDD, SSD): 읽기(입력,로딩)
		 * 
		 * 저장 장치 - 데이터를 1,0으로 저장 - 데이터의 자료형이 없다 - 하드디스크에 저장되어 있는 파일은 특정 프로그램에 종속된 파일이
		 * 아니다 - 중립적
		 * 
		 * 인코딩, Encoding - 응용 프로그램 데이터(문자 코드)를 부호(0, 1)화 하는 작업 - 자바 프로그램에서 (String,
		 * "홍길동") 라는걸 만듬 -> 이걸 텍스트 파일로 저장하고싶다(1001011 ...)
		 * 
		 * 디코딩, Decoding - 부호 데이터를 문자 코드로 변환시키는 작업 - 텍스트 파일(010101101 ...) -> 자바
		 * 프로그램(String, "홍길동")
		 * 
		 * 문자셋, 코드셋, 코드페이지, 인코딩(디코딩) 방식 - 데이터를 변환하는 규칙 - 한글 관련
		 * 
		 * 1. ANSI 2. UTF - UTF-8 - UTF-16 3. ISO-8859-1 4. EUC-KR 5. MS949(CP949)
		 * 
		 * ANSI(ISO-8859-1, EUC-KR, MS949 <- 우리나라 입장에선 ANSI와 똑같음) - 응용 프로그램에 있는 모든 영어,
		 * 숫자, 특수문자, 서유럽 문자 (<- 아스키 코드라고 함)는 하드디스크에 한글자당 1byte씩 저장됨 - 응용 프로그램에 있는 모든
		 * 한글(한자, 일본어 등)은 하드디스크에 한글자당 2byte씩 저장됨
		 * 
		 * 
		 * UTF-8 - 응용 프로그램에 있는 모든 영어, 숫자, 특수문자, 서유럽 문자 (<- 아스키 코드라고 함)는 하드디스크에 한글자당
		 * 1byte씩 저장됨 - 응용 프로그램에 있는 모든 한글(한자, 일본어 등)은 하드디스크에 한글자당 3byte씩 저장됨
		 * 
		 * UTF-16 - 응용 프로그램에 있는 모든 영어, 숫자, 특수문자, 서유럽 문자 (<- 아스키 코드라고 함)는 하드디스크에 한글자당
		 * 2byte씩 저장됨 - 응용 프로그램에 있는 모든 한글(한자, 일본어 등)은 하드디스크에 한글자당 2byte씩 저장됨
		 * 
		 * 홍길동 이 0110 1101 0101 라고 치면 UTF에서 ANSI로 왔다갔다하면 011011 010101 이렇게 변해버림 -> 그럼 한글
		 * 다깨짐 ex. 뀄뜛낅
		 * 
		 * 현재는 거의 모든 나라가 UTF-8 사용
		 * 
		 * try catch 템플릿 수정함 Window -> preference -> 자바 템플릿 -> try catch 찾아서 수정(insert
		 * variable 사용)
		 * 
		 * 스트림 객체
		 * 
		 */

		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		m9();
	}

	private static void m9()
	{
		// 성적표 출력
		// - 성적을 파일(score.dat)에 넣는다, 파일의 데이터 저장 구조를 정의해야 한다(스키마)
		// - 학생 이름, 국어, 영어, 수학 점수, 총점, 평균
		// - 홍길동,100,90,80 <- 이런 식으로 저장할건데, 이걸 CSV라고 부름(Comma seperated value)
		
		System.out.println
		("=============================================");
		System.out.println("                    성적표");
		System.out.println
		("=============================================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		try
		{
			// 자원의 경로를 나타낼 때 2가지 방식이 있다
			// 1. 절대경로
			// - 드라이브명으로 시작함
			// 2. 상대경로
			// - 현재 폴더로 시작함
			// - . <- 내가 있는 폴더라는 뜻 / .\\나머지 경로	
//			String path = "C:\\code\\java\\JavaTest\\data\\score.dat"; <- 절대 경로 방식
			
			File dir = new File("."); // 현재 폴더 참조
			// System.out.println(dir.getAbsolutePath()); // 너의 절대경로가 어떻게 되니
			// C:\code\java\JavaTest\. 출력
			String path = ".\\data\\score.dat";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while ((line = reader.readLine()) != null)
			{
				// 홍길동,100,90,80
				//System.out.println(line);
				
				String temp[] = line.split(",");
				String name = temp[0];
				
				int kor = Integer.parseInt(temp[1]);
				int eng = Integer.parseInt(temp[2]);
				int math = Integer.parseInt(temp[3]);
				int total = kor + eng + math;
				double avg = total / 3.0;
				
				System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\r\n", name, kor, eng, math, total, avg);
				
			}
			
			reader.close();
			
		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m9() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}

	private static void m8()
	{
		// 읽기 전용 메모장을 만들자(자바 소스 전용)
		try
		{
			// 파일명을 입력받아서 스트림을 만든 다음에 내용을 읽고 출력한다.
			Scanner scan = new Scanner(System.in);
			System.out.println("파일명을 입력하세요: ");
			String fileName = scan.nextLine();
			
			String path = "C:\\code\\java\\JavaTest\\src\\com\\test\\java\\" + fileName;
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			int number = 1; // 줄번호
			
			while ((line = reader.readLine()) != null)
			{
				System.out.printf("%3d: %s\n", number, line);
				number++;
			}
			
			reader.close();
			
			
		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m8() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}

	private static void m7()
	{
		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\code\\java\\file\\클래스.txt")))
		{
			// try 옆에 () 넣고 () 안에 BufferedReader를 쓰면 reader.close();를 쓰지 않아도 된다
			// try-with-resources 라는 문법, 사람들이 close를 자꾸 까먹어서 새로 생긴 문법
			// 만약에 reader가 두개에요 하면 끝에 ; 넣고 뒤에 또 쓰면 됨
			// 자원을 자동으로 반납해주는 try문이다(자동으로 close()를 호출한다)
			// 텍스트 파일 읽기 -> BufferedReader가 괜찮다
			// 텍스트 파일 쓰기 -> BufferedWriter(BufferedReader랑 짝 맞추려고 쓰는 느낌) or FileWriter
			
			
			String line = reader.readLine();
//			System.out.println(line);
//			
//			String line = null;
			
			while((line = reader.readLine()) != null) // 더이상 읽을게 없을때까지 읽는 루프
			{
				System.out.println(line);
			}

		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m7() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}

	private static void m6()
	{
		// FileOutputStream -> FileWriter -> BufferedWriter
		// FileInputStream -> FileReader -> BufferedReader

		// 클래스 사용자 입장에서 봤을 때
		// 1. InputStreamReader <- 키보드 입력받는 도구, 입력받는 메세지를 InputKey()라고 가정했을 때
		// 2. FileReader <- 텍스트 파일 입력 도구, 읽어오는 메서드가 readText()라고 가정했을 때
		// 도구가 서로 달라서 사용법도 다 알고있어야 했는데
		// 1. BufferedReader 라는 껍데기로 포장한것 BufferedReader(InputStreamReader), nextLine()을
		// 호출했으면? InputKey() 이 메서드가 연결된다
		// 껍데기 안에 있는 알맹이가 InputStreamReader 이기 때문
		// 2. 같은 맥락으로 BufferedReader(FileReader) 에서 nextLine()을 호출하면, 똑같이 nextLine을
		// 호출했지만 알맹이가 FileReader이기 때문에
		// 이번엔 readText 메서드로 연결된다
		// 편의를 위해 추상화를 한 것
		// 핵심 부품만 갈아끼운 것?
		// 만약에 파일 쓰기 업무 말고는 하지 않는다면 그냥 FileWriter를 쓰는게 낫다
		// BufferedWriter는 딱히 장점이랄게 없다?
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		
//		BufferedReader reader2 = new BufferedReader(new FileReader("test.txt"));

		try
		{
			// 파일의 경로를 달라고 하지 않는다, 파일 전용 Writer가 아니기 때문
			// 쓰기 도구 만들기
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\code\\java\\file\\user.txt"));

			writer.write("홍길동");
			writer.write("\r\n");
			writer.write("아무개");
			writer.newLine();
			writer.write("고양이");

			writer.close();

			System.out.println("종료");

		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m6() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}

	}

	private static void m5()
	{
		try
		{
			// 파일 읽기 메서드
			// - FileOutputStream -> FileWriter (더 세련된 느낌)
			// 1. 문자 단위 쓰기를 지원함(2byte씩 쓰기 지원) -> 한글 가능
			// 2. 문자열 전체 읽기를 지원하지 않음 -> 한 문자씩 읽어야함

			FileReader reader = new FileReader("C:\\code\\java\\file\\클래스.txt");

			int code = -1;

//			code = reader.read();
//			System.out.println((char)code);

			while ((code = reader.read()) != -1)
			{
				System.out.print((char) code);
			}

			reader.close();

		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m5() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}

	private static void m4()
	{
		try
		{
			// 쓰기 전용 메모장을 만들자
			Scanner scan = new Scanner(System.in);

			// 파일명을 입력받아서 스트림 객체를 만들고 파일 쓰기를 수행
			System.out.print("저장할 파일의 이름: ");
			String fileName = scan.nextLine();

			FileWriter writer = new FileWriter("C:\\code\\java\\file\\" + fileName);

			while (true)
			{
				System.out.println("> ");
				String line = scan.nextLine();

				if (line.equals("wq")) // write & quit
				{
					break;
				}

				writer.write(line);
				writer.write("\r\n");
			}

			writer.close();
			System.out.println("저장되었습니다.");

		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m4() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}

	}

	private static void m3()
	{
		try
		{
			// 파일 쓰기
			// - FileOutputStream -> FileWriter (더 세련된 느낌)
			// 1. 문자 단위 쓰기를 지원함(2byte씩 쓰기 지원) -> 한글 가능
			// 2. 문자열 자체를 인자로 하여 쓰기를 지원한다

			FileWriter writer = new FileWriter("C:\\code\\java\\file\\list.txt");

			writer.write(65);
			writer.write('가'); // 한글도 기록 가능
			writer.write("홍길동입니다."); // 이것도 덮어쓰기인듯
			writer.close(); // 스트림 닫는거 필수

			System.out.println("종료");

		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m3() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}

	private static void m2()
	{
		// 파일 읽기
		// 이것도 한글은 지원하지 않는다
		// - 읽기 스트림 객체 <- 읽기 전용 빨대

		try
		{
			// - FileOutputStream
			// - FileInputStream

			FileInputStream stream = new FileInputStream("C:\\code\\java\\file\\number.txt");

			// int code = System.in.read(); 와 비슷함
//			int code = stream.read(); // 반환값이 int
//			System.out.print((char)code);
//			
//			code = stream.read();
//			System.out.print((char)code);
//			
//			code = stream.read();
//			System.out.print((char)code);
//			
//			code = stream.read();
//			System.out.print((char)code);
//			
//			code = stream.read();
//			System.out.print((char)code);
//			
//			code = stream.read();
//			System.out.print((char)code);

			// 엄청 자주 쓰는 패턴
			int code = -1; // 더이상 읽을게 없으면 -1을 반환한다

			while ((code = stream.read()) != -1)
			{
				System.out.println((char) code);
			}

			stream.close(); // 빨대 빼기(스트림 닫기)
		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m2() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}

	private static void m1()
	{
		// 파일에 데이터를 저장해보자
		// 파일 쓰기
		// 쓰기용 스트림 객체를 만들자

		// 쓰기 모드
		// 1. Create Mode(기본값)
		// - 파일이 없으면 새로 만들어줌
		// - 기존 파일이 있으면 덮어쓰기를 함

		// 2, Append Mode
		// - 난 계속 이어서 쓰고 싶다
		// - 파일이 없으면 새로 만들어줌
		// - 기존 파일이 있으면 이어서 씀
		// - FileOutputStream stream = new FileOutputStream(file, false); <- false면
		// Create Mode, true면 Append Mode

		try
		{
			File file = new File("C:\\code\\java\\file\\number.txt");

			// 스트림 객체 생성(스트림을 연다)
			// - FileOutputStream 클래스를 사용 <- 이 빨대가 1byte를 넘어가는 글자(ex.한글)는 저장을 못함
			FileOutputStream stream = new FileOutputStream(file, true); // 빨대를 꽂았다
			// 또 안쓸거면 빨때를 빼야함(스트림을 닫는다)
			// 아니면 스트림이 파일을 독점해서 다른 빨대가 못 들어옴

			// 쓰기
//			stream.write(65); // 문자 코드값으로 저장해야함
//			stream.write(66);
//			stream.write(67);
//			stream.write((int)'D');
//			stream.write('E'); // char는 숫자니까 이렇게 작성해도 알아서 숫자로 바뀐다
//			stream.write('F'); // ABC가 없어진 이유 : 덮어쓰기라서

//			stream.write('가');
//			stream.write('나');
//			stream.write('다'); // <- 한글은 깨짐

			// 여러 글자를 한꺼번에 써보자
			String txt = "Hello~";

			// 영어 특수문자 이런것들은 한 글자가 128byte를 넘지 않아서 이런 방식이 가능
			System.out.println(Arrays.toString(txt.getBytes()));

			stream.write(txt.getBytes());

			// 스트림 닫기
			stream.close();

			System.out.println("종료");
		} catch (Exception e)
		{
			System.out.println("Ex60_FileIO.m1() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}
}
