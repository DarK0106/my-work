package com.test.java.lambda;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.test.data.Data;

public class Ex71_Stream
{
	public static void main(String[] args)
	{
		/*
		 * 자바에서의 스트림 1. 입출력 스트림 - 파일 입출력, 콘솔 입출력, 네트워크 입출력 .. 2. 스트림 - Java 8(JDK 1.8)
		 * -> 람다식, 함수형 인터페이스, 스트림 다 이 때 출시됨 - 배열(주로 컬렉션) 등의 탐색 및 조작을 하는 기술
		 * 
		 * 표준 API 함수형 인터페이스
		 * 
		 * 1. Comsumer 매개변수가 있고 반환값이 없음
		 * 
		 * 2. Supplier 매개변수가 없고 반환값이 있음
		 * 
		 * 3. Function 매개변수도 있고 반환값도 있음
		 * 
		 * 4. Operator 매개변수도 있고 반환값도 있음 - 매개변수 자료형 == 반환값 자료형
		 * 
		 * 5. Predicate 매개변수도 있고 반환값도 있음 - 반환값이 무조건 boolean
		 * 
		 * 
		 * 스트림, Stream - 특정 데이터 집합(소스) 으로부터의 생성
		 * 
		 * 파이프, Pile - 스트림 객체를 통해서 호출되는 메서드 - 중간 파이프 - 최종 파이프
		 * 
		 * 최종 처리 - forEach(Consumer) 매개변수로 인터페이스를 달라는얘기는 ? - 최종 파이프 - 앞의 스트림으로부터 데이터를
		 * 건네받아서 최종 처리하는 메서드
		 * 
		 * 필터링
		 * - filter(Predicate)
		 * - 중간 파이프 -> 모든 중간 파이프는 반환값이 Stream이다
		 * - 최종 파이프는 반환값이 Stream을 제외한 나머지이다
		 * - 앞의 스트림으로부터 데이터를 받아 조건에 대입해보고 조건에 맞는 요소만 남기고 맞지 않는 요소는 버린다
		 * 
		 * 중복 제거
		 * - distinct() <- 매개변수가 없다. 자기가 알아서 같은 값을 없애주는게 끝이라서
		 * - 중간 파이프
		 * - 앞의 스트림으로부터 데이터를 받아 중복값을 제거한다.
		 * 
		 * 변환(*중요*)
		 * - map(Function), mapXXX(Function)
		 * - 중간 파이프
		 * - 앞의 스트림으로부터 요소를 받아 다른 형태로 변환 후 새로운 스트림 반환
		 * 
		 * 정렬
		 * - sorted(Comparator) 어떤걸 비교해서 오름차순 내림차순으로 정리할지를 내가 알려줘야 한다
		 * - 중간 파이프
		 * - 사용법이 기존 Collections.sort(), Arrays.sort() 와 동일하다
		 * 
		 * 매칭
		 * - allMatch(), anyMatch(), noneMatch()
		 * - 최종 파이프
		 * - 셋 다 리턴값이 boolean
		 * 매개변수가 Predicate
		 * 모든 요소가 조건을 모두 만족하는지?
		 * boolean allMatch(Predicate) : 모든 요소가 조건을 모두 만족하는지? <- and 느낌
		 * boolean anyMatch(Predicate) : 일부 요소가 조건을 만족하는지? <- 약간 or 느낌
		 * boolean noneMatch(Predicate) : 모든 요소가 조건을 불만족하는지? -> 여기 계신 분들 모두 서울에 안 살지요 ?
		 * 
		 * 집계 / 통계 Reduce
		 * - count()
		 * - max()
		 * - min()
		 * - sum()
		 * - avg()
		 * - 모두 최종 파이프
		 * 
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
		
	} // main

	private static void m9()
	{
		// 짝수 56개
		System.out.println(Data.getIntList().stream().filter(num -> num % 2 == 0).count());
		
		// 홀수 44개
		System.out.println(Data.getIntList().stream().filter(num -> num % 2 == 1).count());
		
		// 남자 7명
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 1).count());
		
		// 여자 3명
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 2).count());
		
		// max, min
		System.out.println(Data.getIntList().stream().max((a, b) -> a - b));
		System.out.println(Data.getIntList().stream().min((a, b) -> a - b));
		
		System.out.println(Data.getUserList().stream()
											 .max((a, b) -> a.getAge() - b.getAge())); // 나이가 제일 많은 사람
		
		List<Integer> nums2 = new ArrayList<Integer>();
		nums2.add(100);
		nums2.add(50);
		nums2.add(20);
		
		// 배열에 항상 숫자가 들어있을거란 보장이 없기 때문에 만약 반환할 숫자가 없으면 null이라도 돌려줘야함
		// 만약 int 붙이면 int라는 값형식은 null 을 가질 수 없다
		// 0 도 안됨
		// 메서드의 반환값이나 인자값을 아무것도 안 주고 싶을 때 값형을 사용하면 안된다(null을 넣을 수 없어서)
		// 안정성을 높이려고 만든 Optional
		// Optional을 바로 써먹는게 아니라 get을 써서 실제 데이터를 꺼내야한다
		
		// if (maxNum != null)
		
		Optional<Integer> maxNum = nums2.stream().max((a, b) -> a - b);
//		Optional<Integer> maxNum = Data.getIntList().stream().max((a, b) -> a - b);
		
		if (maxNum.isPresent()) // if (maxNum != null)
		{
			System.out.println(maxNum);
			System.out.println(maxNum.get());
		}
		
		if (maxNum.isEmpty()) // if (maxNum == null)
		{
			
		}
		
		System.out.println(maxNum); // Optional[99] 가 뭘까
		
		// 스트림 타입: 숫자, 문자열, 날짜
		// - count(), max(), min()
		
		// 스트림 타입 : 숫자
		// - sum(), avg()
		
		// 우리가 쓰고있는 stream은 제네릭 stream
		// Stream<String>
		// 제네릭은 숫자라는 보장을 못해준다
//		Data.getIntList().stream().
		
		// 숫자 전용 스트림을 써야 한다
		// Stream<Integer> : 범용
		// IntStream : 전용
		
		// String<Integer> 를 IntStream 으로 변환
		int sum = Data.getIntList().stream().mapToInt(num -> num).sum(); // 넘어온 숫자에는 가공을 하지 않고 그대로 돌려준다, 
		// 전용 스트림으로 만들려고만 한 것
		System.out.println(sum);
		
		// 평균 구하기
		System.out.println(Data.getIntList().stream().mapToInt(num -> num).average().getAsDouble());
		// OptionalDouble, Optional<Double> 전용이냐 범용이냐
		// 더하기는 숫자가 있어서 더하면 숫자, 아무런 더할 대상이 없어도 0이기때문에 무조건 값을 되돌려받을수 있지만
		// 평균은 아무것도 없으면 돌려받지 못해 무조건 돌려받을 보장이 없기 때문에 Optional을 사용했다
		// getAsDouble은 숫자만 뽑아오고 싶어서 붙인 것
		
		// user들에서 남자들의 평균키를 알고싶다. 여자는 빼고
		// 변환과 동시에 전용 스트림까지 만들어낸다?
		Data.getUserList().stream().filter(u -> u.getGender() == 1).mapToInt(u -> u.getHeight()).average().getAsDouble();
		
		
		
		
		
		
	}

	private static void m8()
	{
		// int[] nums = { 2, 4, 6, 8, 10 }; // 이 초기화 리스트 하고
		// Returns an unmodifiable list containing five elements.
		// 수정할 수 없다?
		// 읽기 전용이다
		// 컬렉션 장점이 넣다뺐다하는건데 장점이 퇴색되서 대중적으로 쓰진 않는다
		List<Integer> nums = List.of(2, 4, 6, 8, 10); // 이 초기화 리스트는 같아보이지만 의미가 다르다
		// nums.add(12);
		// nums.remove(0);
		// System.out.println(nums);
		
		// nums 에 짝수만 있는지 확인하고 싶다 짝수만 있으면 true, 짝수가 아닌게 섞여있으면 false를 반환받고 싶다
		boolean result = false;
		
		for (int n : nums)
		{
			if ( n % 2 == 1) // false니까 잘못된걸 찾는게 보기 편하다
			{
				result = true; // 잘못된걸 발견했다
				break; // 홀수가 하나라도 발견됐으니 더이상 루프를 돌 필요가 없다
			}
		}
		
		System.out.println(result);
		
		result = nums.stream().allMatch(num -> num % 2 == 0); // allmatch는 모든 애가 예 라는 대답이 나와야 true가 나옴
		System.out.println(result); // 5개의 숫자 모두가 짝수라서 true가 출력되었다
		
		result = Data.getUserList().stream().filter(user ->user.getHeight() >= 180) // 키가 180 이상 이라는 필터
											.allMatch(user -> user.getGender() == 1);
		System.out.println(result); // 모두 남자입니다
		
		nums = List.of( 2, 4, 6, 8, 10 );
		
		// nums 안에 홀수가 1개라도 있나??
		result = nums.stream().anyMatch(n -> n % 2 ==1);
		System.out.println(result);
		
		// 짝수가 존재하지 않느냐?
		nums = List.of( 2, 3, 4);
		result = nums.stream().noneMatch(n -> n % 2 == 0); // 이걸 yes라고 답하는 사람이 아무도 없지요? 라고 질문
		System.out.println(result);
		
	}

	private static void m7()
	{
		Data.getIntList(10)
			.stream()
//			.sorted((a, b) -> b -a) // 내림차순
//			.sorted(Comparator.naturalOrder()) // (a, b) -> a - b 와 똑같다
			.sorted(Comparator.reverseOrder()) // (a, b) -> b - a 와 똑같다
			.forEach(n -> System.out.println(n));
	}

	private static void m6()
	{
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		System.out.println();
		
		// 각 단어를 글자수로 변환을 하고 싶다
		List<Integer> result = new ArrayList<Integer>();
		for (String str : list)
		{
			result.add(str.length());
		}
		
		System.out.println(result);
		
		list.stream()
			.map(word -> word.substring(0, 2)) // 반환값으로 구성된 스트림 생성
			.forEach(word -> System.out.println(word));
		
		list.stream().map(word -> word.length()).forEach(length -> System.out.println(length));
		
		list.stream().map(word -> word.length() >= 5 ? "긴 단어" : "짧은 단어").forEach(result2 -> System.out.println());
		System.out.println();
		
		// User 배열
		Data.getUserList().stream()
						//.map(user -> user.getName())
		                //.map(user -> user.getAge())
						  .map(user -> user.getGender() == 1 ? "남자" : "여자").forEach(result3 -> System.out.println(result3));
		System.out.println();
		
		String[] names = {"홍길동", "아무개", "강아지", "고양이", "병아리"};
		
		// com.test.java.lambda
//		new User(이름, 나이, 주소) 이걸 가지고 유저 객체 5개를 만들고 싶다
		
		// String[] names -> (변환) -> List<User> ulist
		List<User> ulist = new ArrayList<User>();
		for (String name : names)
		{
			User u = new User(name, 20, "서울시");
			ulist.add(u);
		}
		
		
		Arrays.stream(names).map(name -> new User(name, 20, "서울시")).forEach(user -> System.out.println(user));
		
	}

	private static void m5()
	{
		// 중복 제거 연습
		
		List<Integer> nums = Data.getIntList();
		System.out.println(nums.size());
		
		System.out.println(nums.stream().count());
		System.out.println();
		
		System.out.println(nums.stream().distinct().count()); // 100개의 숫자 중에 39개가 중복되었다
		System.out.println();
		
		int[] nums2 = { 10, 20, 30, 10, 10, 10, 10 };
		System.out.println(Arrays.stream(nums2).distinct().count()); // 중복되는거 한개만 남기고 나머지는 다 없애버림
		// 그래서 10 20 30 만 남아서 3이 출력됨
		
		long begin = 0, end = 0; // 실행하는데 얼마나 걸리는지 시간을 재보자
		begin = System.nanoTime();
		
		
		Data.getStringList().stream()
							.filter(word -> word.length() >= 5)
							.distinct()
							.forEach(word -> System.out.println(word));
		end = System.nanoTime();
		System.out.println(end - begin + "ns");
		System.out.println();
		
		begin = System.nanoTime();
		Data.getStringList().stream()
							.distinct()
							.filter(word -> word.length() >= 5) // 중복값부터 먼저 제거하고 ~ 결과적으론 결과는 똑같음 근데 업무 효율이 다름 
							.forEach(word -> System.out.println(word));
		end = System.nanoTime();
		System.out.println(end - begin + "ns");
		System.out.println();
		
		
		
		
	}

	private static void m4()
	{
		List<Integer> list = Data.getIntList(20); // 숫자 20개
		System.out.println(list);
		
		// 짝수만 출력하는 작업
		// for문으로 할 떄
		for (int i =0; i < list.size(); i++)
		{
			if(list.get(i) % 2 == 0)
			{
				System.out.printf("%-4d", list.get(i));
			}
		}
		System.out.println();
		
		list.stream().forEach(n -> 
		{
			if (n % 2 == 0)
			{
				System.out.printf("%-4d", n);
			}
		});
		System.out.println(); // 맞긴한데 스트림답게 쓴게 아님
		
		// 스트림답게 써보자
		list.stream()
			.filter(n -> n % 2 == 0)
			.forEach(n -> System.out.printf("%-4d", n));
		System.out.println();
		
		list.stream()
			.filter(n -> n % 2 == 0)
			.filter(n -> n >= 50)
			.forEach(n -> System.out.printf("%-4d", n));
		System.out.println();
		
		Data.getStringList().stream()
							.filter(word -> word.length() >= 5) // 5글자 이상인 단어만
							.filter(word -> word.startsWith("애")) // 애 로 시작하는 단어만
							.forEach(word -> System.out.println(word));
		System.out.println();
		
		Data.getUserList().stream()
						.filter(user -> user.getGender() == 1) // 남자인 user 만
						.filter(user -> user.getHeight() >= 180) // 키 180 이상
						.filter(user -> user.getWeight() >= 80) // 몸무게 80 이상
						.forEach(user -> System.out.println(user));
		System.out.println();
		
		
	}

	private static void m3()
	{
		// 스트림을 얻어오는 방법
		// stream() 또는 여러가지 메서드를 호출
		// 1. *배열로부터 스트림을 뽑아낸다*
		// 2. *컬렉션으로부터 스트림을 뽑아낸다*
		// 3. 숫자 범위 ... <- 자주 안 씀 ..
		// 4. 파일로부터 ... <- 자주 안 씀 ..
		// 5. 디렉토리로부터 ... <- 자주 안 씀 ..
		// 6. ... <- 자주 안 씀 ..
		
		// 1.
		int[] nums1 = { 10, 20, 30 }; // 순수 배열은 첫 jdk부터 있었다
		// 스트림은 jdk 1.8부터
		// 기존거에다 스트림 기술을 끼워넣으려 했는데 그게 잘 안됨
		Arrays.stream(nums1).forEach(num -> System.out.println(num));
		System.out.println();
		
		// 2.
		List<Integer> nums2 = Data.getIntList(3);
		nums2.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		// 3. 
		// 전용 스트림?
//		Stream<T> <- 우리가 쓰고 있는 스트림
		
		// IntStream.range(1, 10) 이거 자체가 스트림
		IntStream.range(1, 10).forEach(num -> System.out.println(num));
		System.out.println();
		
		// 4. 파일 읽기
		// FileReader
		// Scanner
		// Stream
		
		try
		{
			Path path = Paths.get(".\\data\\score.dat");
			
			Files.lines(path).forEach(line -> System.out.println(line));
			System.out.println();
			
			// 5. 디렉토리로부터
			Path dir = Paths.get("C:\\dev\\eclipse-jee-2025-12-R-win32-x86_64\\eclipse");
			Files.list(dir).forEach(p ->
			{
				
				System.out.println(p.getFileName());
				File file = p.toFile();
				System.out.println(file.isFile());
				
			}); // dir.listFiles()
		} 
		catch (Exception e)
		{
			System.out.println("Ex71_Stream.m3() 예외 발생");
			e.printStackTrace(); // 에러 메세지 출력
		}
	}

	private static void m2()
	{
		// 배열 또는 컬렉션을 우리가 어떻게 탐색을 해왔었는지에 대한 총정리
		List<String> txt1 = Data.getStringList(10);
		System.out.println(txt1); // 단어가 10개 들어있는 집합

		// 1. for문(while문)
		for (int i = 0; i < txt1.size(); i++)
		{
			System.out.printf("%s", txt1.get(i));
		}
		System.out.println();

		// 2. 향상된 for문
		for (String s : txt1)
		{
			System.out.printf("%s", s);
		}
		System.out.println();

		// 3. iterator
		Iterator<String> iter = txt1.iterator();

		while (iter.hasNext())
		{
			System.out.printf("%s", iter.next());
		}
		System.out.println();

		// 4. stream
		// 방식이나 목적이 살짝 다르다
		// 4.1 데이터 소스로부터 스트림을 일단 만들어내야한다
		Stream<String> Stream = txt1.stream();

		// 4.2 스트림 객체를 통해서 배열의 요소에 접근할 수 있게 된다
		// 접근해서 조작이 가능하도록
		Consumer<String> c1 = s -> System.out.println("단어: " + s); // foreach로부터 받은 단어를 consumer가 소비하고 자기 일을 끝냈다

		// 스트림으로부터 요소 하나를 꺼낸다.
		// 꺼낸 요소를 Consumer에게 전달한다
		// - c1.accept(문자열) 호출한다
		Stream.forEach(c1);
		System.out.println();

		txt1.stream()
			.forEach(s -> System.out.println(s)); // 이 방법을 자주 쓴다, 메서드 체인 형태? 너무 길어지면 가독성이 안좋아짐
		// 그래서 파이프별로 엔터를 많이들 침
		System.out.println();

		// 숫자 10개를 가져가서 제곱값을 출력해보자
		Data.getIntList(10)
			.stream()
			.forEach(num -> System.out.println(num * num));

		// Item 10개를 가져가서 정보를 출력해보자
		Data.getItemList().stream().forEach(item ->
		{
			System.out.println(item.getName());
			System.out.println(item.getColor());
			System.out.printf("%tF\n", item.getDate());
			System.out.println();
		});

	}

	private static void m1()
	{
		int[] nums1 = Data.getIntArray();
//		System.out.println(Arrays.toString(nums1));

		int[] nums2 = Data.getIntArray(10);
//		System.out.println(Arrays.toString(nums2));

		List<Integer> nums3 = Data.getIntList();
		System.out.println(nums3);

		List<Integer> nums4 = Data.getIntList(10);
		System.out.println(nums4);

		String[] txt1 = Data.getStringArray();
		System.out.println(Arrays.toString(txt1));

		com.test.data.User[] ulist = Data.getUserArray();
		System.out.println(Arrays.toString(ulist));

		com.test.data.Item[] ilist = Data.getItemArray();
		System.out.println(Arrays.toString(ilist));

	}
}
