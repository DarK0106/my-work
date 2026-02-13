package com.test.java.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class Ex59_File
{
	private static int fileCount = 0;
	private static int directoryCount = 0;
	private static int totalSize = 0;

	public static void main(String[] args)
	{
		// Ex59_File.java
		/*
		 * 
		 * 데이터의 지속적인 관리 
		 * 1. 파일 / 디렉터리 조작 
		 * - 윈도우 탐색기가 하는 행동들 ..
		 * 
		 * 2. 파일 입출력 a. 텍스트 입출력 -> 문자를 입출력 
		 * - 메모장 
		 * - 이클립스
		 * 
		 * 
		 * b. 이진 데이터(바이너리) 입출력 -> 문자가 아닌 것들을 입출력 
		 * - 이미지 생성 
		 * - 동영상 재생
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
		// m9();
		// m10();
		// m11();
		// m12();
		// m13();
		// m14();
		// m15();
	}

	private static void m15()
	{
		// 내용물이 있는 폴더 삭제하기
		String path = "C:\\code\\java\\file\\schedule"; // 경로 쓸 때 조심해야됨
		File dir = new File(path);

		if (dir.exists())
		{
			deleteDirectory(dir); // 재귀메서드로 빼야해서 클릭하고 메서드 만들기
		}
	}

	private static void deleteDirectory(File dir)
	{
		// 모든 파일 삭제하기
		// 1. 목록 가져오기
		File[] list = dir.listFiles();

		
		for (File file : list)
		{
			if (file.isFile())
			{
				System.out.println(file.getName() + " - deleted ");
				file.delete();
			}
		}

		
		for (File subdir : list)
		{
			if (subdir.isDirectory())
			{
				// ***
				deleteDirectory(subdir);
			}
		}
		
		// 루프가 끝나면 현재 폴더가 빈 폴더가 된다.
		dir.delete();
	}

	private static void m14()
	{
		// 파일의 누적 용량을 합쳐서 표시하기
		// 파일 13,708
		// 폴더 2,376
		// 768MB (806,116,638 바이트)

		// count = 10; // static에서는 this.를 쓸 수 없다 원래는 this.count인데 this가 생략되어있음
		// Ex59_File 클래스에서 선언한 count에 static을 붙여야 m14()에서 접근 가능

		String path = "C:\\dev\\eclipse-jee-2025-12-R-win32-x86_64\\eclipse";
		File dir = new File(path);

		if (dir.exists())
		{
			search(dir);

			System.out.printf("총 파일 개수: %,d개\n", fileCount);
			System.out.printf("총 폴더 개수: %,d개\n", directoryCount);
			System.out.printf("폴더 크기: %,dB\n", totalSize);
			System.out.printf("폴더 크기(MB): %,dMB\n", totalSize / 1024 / 1024);
		}

	}

	public static void search(File dir)
	{
		// 1. 목록 가져오기
		File[] list = dir.listFiles();

		// 2. 파일 개수 세기
		for (File file : list)
		{
			if (file.isFile())
			{
				fileCount++;
				totalSize += file.length();
			}
		}

		// 3. 자식 폴더로 가서 1, 2 반복
		for (File subdir : list)
		{
			if (subdir.isDirectory())
			{
				// ***
				search(subdir);
				directoryCount++;
			}
		}
	}

	private static void m13()
	{
		// 파일의 누적 용량을 합쳐서 표시하기
		// 파일 13,708
		// 폴더 2,376
		// 768MB (806,116,638 바이트)
		String path = "C:\\dev\\eclipse-jee-2025-12-R-win32-x86_64\\eclipse";
		File dir = new File(path);
		int count = 0; // 누적 변수, 파일인 애들만 개수를 세서 누적 변수에 누적시키기

		if (dir.exists())
		{
			// 가장 꼭대기에 있는 파일의 개수부터 센다
			File[] list = dir.listFiles();

			for (File file : list)
			{
				if (file.isFile())
				{
					count++;
				}
			}

			// 자식 폴더로 내려간다
			for (File subdir : list)
			{
				if (subdir.isDirectory())
				{
					// 목록을 얻어오고 파일의 개수를 센다
					File[] sublist = subdir.listFiles(); // 내용을 얻은 다음에

					for (File subfile : sublist)
					{
						if (subfile.isFile())
						{
							count++; // 개수를 센다
						}
					}
					// 자식 폴더의 자식 폴더를 찾아간다
					for (File subsubdir : sublist)
					{
						if (subsubdir.isDirectory())
						{
							File[] subsublist = subsubdir.listFiles();

							for (File subsubfile : subsublist)
							{
								if (subsubfile.isFile())
								{
									count++;
								}
							}
						}
					}

				}
			}

			System.out.printf("총 파일 개수: %,d개\n", count);
		}
	}

	private static void m12()
	{
		// 특정 폴더의 내용물 보기
		String path = "C:\\dev\\eclipse-jee-2025-12-R-win32-x86_64\\eclipse";
		File dir = new File(path);

//		if(dir.exists())
//		{
//			// 폴더의 내용물
//			String[] list = dir.list();
//			
//			for (String item : list)
//			{
//				System.out.println(item); // 이름만 가지고는 뭔지 잘 구분이 힘들다
//			}
//		}

		File[] list = dir.listFiles();

//		for (File item : list)
//		{
//			System.out.println(item.getName()); // 이름이 뭐니
//			System.out.println(item.isFile()); // 너 파일이니 폴더니 / 파일이면 true, 폴더면 false
//			System.out.println();
//		}

		// 폴더를 구분해서 표시하기
		for (File item : list)
		{
			if (item.isDirectory())
			{
				System.out.println("📁" + item.getName()); // 윈도우키 + . -> 이모티콘
			}
		}
		// 파일을 구분해서 표시하기
		for (File item : list)
		{
			if (item.isFile())
			{
				System.out.println(item.getName());
			}
		}
	}

	private static void m11()
	{
		// 폴더 삭제
		File dir = new File("C:\\code\\java\\file\\bbb");

		// 빈폴더만 삭제 가능 !!
		System.out.println(dir.delete());
	}

	private static void m10()
	{
		// 폴더명 수정 or 폴더 이동
		File dir = new File("C:\\code\\java\\file\\일정");
		File dir2 = new File("C:\\code\\java\\file\\schedule");

		System.out.println(dir.renameTo(dir2));
	}

	private static void m9()
	{
		// 요구사항) 일정별 자원을 정리하는 폴더 -> 날짜별 폴더 생성하기
		// [2026-01-01 목]
		// [2026-01-02 금]
		// [2026-01-03 토]
		// ...
		// [2026-12-31 목]

		Calendar c = Calendar.getInstance(); // c에 현재시간 들어있음
		c.set(2026, 0, 1); // 이 날짜가 속한 년도에

		// System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR)); // 이 숫자가 가질 수
		// 있는 최대 숫자가 얼마야?

		for (int i = 0; i < c.getActualMaximum(Calendar.DAY_OF_YEAR); i++)
		{
			// String date = String.format("%tF %tA", c, c).substring(0, 12); // substring
			// 붙여서 ~요일 을 뺄 수 있다 12자리까지만 나오게
			String date = String.format("%tF %s", c,
					c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.NARROW_FORMAT, Locale.KOREAN)); // 비슷한 기능

			System.out.println(date);

			String path = "C:\\code\\java\\file\\일정\\[" + date + "]";
			File dir = new File(path);
			dir.mkdirs();

			// 한바퀴씩 돌때마다 하루씩 증가하면 좋겠다
			c.add(Calendar.DATE, 1);
		}

	}

	private static void m8()
	{
		// 요구사항) 회원 명단을 받아 개인 폴더를 생성하기
		String[] member =
		{ "홍길동", "아무개", "강아지", "고양이", "병아리" };
		for (int i = 0; i < member.length; i++)
		{
			String path = String.format("C:\\code\\java\\file\\회원\\[개인폴더]%s님", member[i]);

			File dir = new File(path);
			dir.mkdir();
		}

		System.out.println("생성 완료");
	}

	private static void m7()
	{
		// 폴더 생성하기
//		String path = "C:\\code\\java\\file\\aaa";
//		File dir = new File(path);
//		
//		System.out.println(dir.mkdir()); // make directory, 이미 만들어졌는데 또 실행하면 false 반환하면서 폴더가 만들어지지 않음

		String path = "C:\\code\\java\\file\\bbb\\ccc\\ddd";
		File dir = new File(path);

		System.out.println(dir.mkdirs()); // make directories, 중간에 만들어지지 않은 부모 폴더가 있으면 그 폴더까지 같이 만들어줌

	}

	private static void m6()
	{
		// 파일 삭제하기
		String path = "C:\\code\\java\\move\\aaa.txt";
		File file = new File(path);

		// 보통 삭제한다고하면 휴지통으로 가는데 사실 이건 삭제가 아님
		// 휴지통이라는 폴더로 이동하는것
		// 이건 진짜 삭제하는것, 복구 불가능
		boolean result = file.delete();
		System.out.println(result); // boolean 값으로 상황 확인하기
	}

	private static void m5()
	{
		// 파일 이동하기
		// C:\code\java\file\data.txt
		// C:\code\java\move 로 이동

		// 수정 전
		String path = "C:\\code\\java\\file\\data.txt";
		File file = new File(path);

		// 수정 후
		String path2 = "C:\\code\\java\\move\\aaa.txt";
		File file2 = new File(path2);

		System.out.println(file.renameTo(file2)); // renameTo는 이름 바꾸는 일만 하는게 아니라
		// 전체 파일 경로에 관련된건 바꿔주는 역할이다
		// 이동도 하면서 이름도 한번에 바꿀 수도 있음
	}

	private static void m4()
	{
		// 파일명 수정하기
		// 요구사항) list.txt의 이름을 data.txt 로 바꿔보자

		// 수정 전
		String path = "C:\\code\\java\\file\\list.txt";
		File file = new File(path);

		// 수정 후
		String path2 = "C:\\code\\java\\file\\data.txt";
		File file2 = new File(path2);

		System.out.println(file.renameTo(file2));
	}

	private static void m3()
	{
		// 파일 조작 -> 파일을 새로 만들거나 이동하거나 이름을 수정하거나 복사, 삭제하는것

		// 생성하기 -> 새 파일 만들기
		String path = "C:\\code\\java\\file\\list.txt";

		File file = new File(path); // 저 경로에 대한 새로운 파일 객체를 만들자

		try
		{
			file.createNewFile(); // 똑같은 파일이 있으면 안 만들어줌
			// boolean 리턴값이 있음 <- true면 새로 만든거고 false면 똑같은 파일이 있어서 만들기 실패한것
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private static void m2()
	{
		// C:\code\java\file\
		// 디렉터리의 정보 읽기
		String path = "C:\\code\\java\\file";
		// 디렉터리 참조 객체 -> 폴더 자체가 파일의 일종이다
		// 모든 폴더는 크기가 0바이트이다
		File dir = new File(path);

		if (dir.exists())
		{
			System.out.println(dir.getName()); // 폴더명
			System.out.println(dir.isFile());
			System.out.println(dir.isDirectory());
			System.out.println(dir.length()); // 폴더의 크기 -> 무조건 0 -> 그래서 안씀
			// 자식 파일의 크기의 합을 누적해서 보여주면 좋지 않나? -> 그건 직접 만들어야함
			System.out.println(dir.getAbsolutePath());
			System.out.println(dir.lastModified());
			System.out.println(dir.isHidden());
			System.out.println(dir.canRead());
			System.out.println(dir.canWrite());
			System.out.println(dir.getParent());
		} else
		{
			System.out.println("디렉터리가 없습니다.");
		}

	}

	private static void m1()
	{
		// C:\code\java\file\test.txt
		// 파일의 정보 읽기

		// 자바 -> (접근) -> 파일
		// - 참조 객체를 사용한다.

		// 파일 경로
		String path = "C:\\code\\java\\file\\test.txt";

		// 파일 참조 객체 -> java.io.File
		File file = new File(path);

//		System.out.println(file.exists()); // 조작을 하기 전에 exists()로 true가 출력되는지 확인할것

		if (file.exists())
		{
			// 파일 정보 읽기
			System.out.println(file.getName()); // 파일명 -> test.txt
			System.out.println(file.isFile()); // 너 파일이니 -> true
			System.out.println(file.isDirectory()); // 너 폴더가 맞니 -> false
			System.out.println(file.length()); // 파일 크기 -> 19byte
			System.out.println(file.getAbsolutePath()); // 파일 위치
			System.out.println(file.lastModified()); // 수정 날짜

			// 타임스탬프 -> Calendar
			Calendar c1 = Calendar.getInstance();
			System.out.println(c1.getTimeInMillis());
			c1.setTimeInMillis(file.lastModified());

			System.out.printf("%tF %tT\n", c1, c1); // 마지막으로 파일을 수정한 시간

			System.out.println(file.isHidden());
			System.out.println(file.canRead());
			System.out.println(file.canWrite());
			System.out.println(file.getParent()); // 부모 디렉토리 출력
		} else
		{
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}
}
