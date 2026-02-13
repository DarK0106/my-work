package com.test.java.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Ex55_ArrayList
{
	public static void main(String[] args)
	{
		// Ex55_ArrayList
		/*
		 * 
		 * Collection, 컬렉션
		 * 배열의 업그레이드 버전
		 * JCF, Java Collection Framework
		 * 업그레이드?
		 * 	1. 상황에 따른 성능 향상
		 *	2. 상황에 따른 사용법 향상
		 * 	3. 길이 가변 -> 길이가 늘었다 줄었다 가능
		 * 
		 * 컬렉션 종류
		 * 
		 * 1. List 계열(대부분이 클래스 아니면 인터페이스)
		 * 	- ArrayList(*****) 유독 배열이랑 비슷함
		 * 	- LinkedList
		 * 	- Que
		 * 	- Stack
		 * 	- Vector
		 * 
		 * 2. Set 계열
		 * 	- HashSet(***)
		 * 	- TreeSet
		 * 	
		 * 3. Map 계열
		 * 	- HashMap(***)
		 * 	- TreeMap
		 * 	- Properties
		 * 	- HashTable
		 * 
		 * ArrayList 클래스
		 * 	- Iterable<E>, Collection<E>, List<E>
		 * 
		 * 
		 * 
		 */
		
		// m1();
		// m2();
		// m3();
		m4();
		
	} // main

	private static void m4()
	{
		// 성적표 만들기
		// 학생 5명의 국영수 성적표 만들기 -> 학생 이름, 국어, 영어, 수학 성적 저장
		// 클래스를 만들어야 함
		// 1. 배열을 쓸 것인지 <- 길이 고정
		// 2. ArrayList를 쓸 것인지 <- 가변 길이
		
//		Score s1 = new Score();
//		
//		s1.setName("홍길동");
//		s1.setKor(100);
//		s1.setEng(90);
//		s1.setMath(80);
//		
//		System.out.println(s1.getTotal());
//		System.out.println(s1.getAvg());
		
		// 더미 데이터 만들기
		
		ArrayList<Score> list = new ArrayList<Score>(); // 성적이 포함된 학생 명단
		
		String [] names = {"홍길동", "아무개", "강아지", "고양이", "병아리" };
		Random rnd = new Random();
		
		for (int i = 0; i < 5; i++)
		{
			// 1번 회전 -> 학생 1명 -> Score 객체 1개
			Score s = new Score();
			
			s.setNo(i + 1);
			s.setName(names[i]);
			
			// 점수는 60~100점
			// (0~40) + 60
			s.setKor(rnd.nextInt(41) + 60);
			s.setEng(rnd.nextInt(41) + 60);
			s.setMath(rnd.nextInt(41) + 60);
			// 한 사람 분량의 데이터가 완성됨
			
			list.add(s); // 지역변수라서 for 벗어나면 죽으니까 ArrayList에 넣어야함
		}
		
		// 출력
		System.out.println
		("=====================================================");
		System.out.println("                        성적표");
		System.out.println
		("=====================================================");
		System.out.println("[번호]\t[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		for (Score s : list)
		{
			System.out.printf("%5d\t%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\r\n", s.getNo(), s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getTotal(), s.getAvg());
		}
		
		
	}

	private static void m3()
	{
		// 다차원 배열 만들 때
		int[]     ns1 = new int[3];
		int[][]   ns2 = new int[2][3];
		int[][][] ns3 = new int[2][3][4];
		
		// 이것과 똑같은 역할을 하는 ArrayList 만들기
		// int[] ns1
		ArrayList<Integer> ms1 = new ArrayList<Integer>(); // 1차원 배열
		ns1[0] = 10; // 배열
		ms1.add(10);
		
		//int[][] ns2
		ArrayList<ArrayList<Integer>> ms2 = new ArrayList<ArrayList<Integer>>(); // 바깥쪽 ArrayList가 안쪽 ArrayList를 요소로 갖고 있다
		ns2[0][0] = 20; // 배열
		ms2.add(new ArrayList<Integer>()); // 바깥쪽 2차원 안에 1차원을 집어넣었다
		ms2.get(0).add(20); // 값 넣기
		System.out.println(ms2.get(0).get(0)); // 값을 꺼내본다
		
		// int [][][] ns3
		ArrayList<ArrayList<ArrayList<Integer>>> ms3 = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
	}

	private static void m2()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		// 1. 요소 추가하기
		// - boolean add(T value) <- boolean은 없는거라고 생각해라?
		// - 배열의 마지막 방에 추가 -> Append Mode
		list.add("사과");
		list.add("바나나");
		list.add("귤");
		list.add("파인애플");
		list.add("망고");
		
		// 2. 요소 개수 확인하기
		// - 추가한 요소의 총 개수 = 배열의 길이 역할
		// - int size()
		
		System.out.println(list.size());
		
		// 3. 요소 읽기
		// - T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
		// 4. 요소 수정하기
		// - T set(int index, T newValue)
		// list[2] = "파파야" <- 이것과 비슷함
		// 덮어쓰기 전에 사라질 값을 하나 반환해준다?
		System.out.println(list.set(2, "파파야"));
		list.set(2, "파파야"); // <- 요소 수정하는법
		
		System.out.println(list.get(2));
		
		// 5. 요소 삭제하기
		// - = 방 없애기
		// - T remove(index index)
		// - boolean remove(Object o)
		
		list.add("파파야");
		System.out.println(list.get(4)); // 4번 방에 있는 망고를 가져옴
		
		System.out.println(list); // 삭제되기전에 덤프
		list.remove(2); // 2번 방에 있는 요소를 삭제
		// list.remove("파파야"); // <- 방 번호 말고 그냥 삭제하고 싶은 값을 넣어도 삭제 가능
		// 방 번호로 지우면 내가 지우고 싶은 파파야를 정확하게 지울 수 있음
		// 값으로 지우면 제일 처음에 만나는 애를 삭제하고 끝남
		// 파파야가 하나만 있으면 상관없고, 보통 방번호로 삭제하는걸 많이 씀
		System.out.println(list); // 삭제하고 나서 확인
		
		System.out.println(list.get(4)); // 2번 방에 있던 파파야가 삭제되서 방 번호가 앞으로 한칸씩 땡겨졌음 
		// 그래서 망고가 아닌 파파야가 가져와짐, 그래서 방 번호를 절대적으로 신뢰하면 안됨
		
		// 6. 요소 추가
		// - Insert Mode
		// - 새치기. 원하는 위치에 요소 추가 
		// - 시프트 발생(새치기 때문에 방 번호가 하나씩 증가)
		// - void add(int index, T value)
		// - void add(T value) <- 이렇게 하면 맨 마지막 방에 넣어짐
		
		System.out.println();
		System.out.println(list);
		list.add(2, "포도");
		System.out.println(list);
//		list.add("샤인머스켓");
//		System.out.println(list);
		
		// 7. 요소 검색
		// - int indexOf(T value)
		// - int lastIndexOf(T value)
		// - boolean contains(T value)
		System.out.println(list.indexOf("파인애플"));
		
		// 8. 탐색
		// 첫번째방에서 마지막방까지 뭐가 들어있는지 찾아보고싶다
		// 덤프는 무조건 문자열로만 나온다 <- 탐색이라고 하기 어려움
		
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println();
		
		// 다르게 생긴 for문(Ex23 d)
		// 향상된 for문, Enhanced for statement
		
		// foreach ( 변수 : 집합 ) { }
		// for ( 변수 : 집합 ) { }
		
		for ( String s : list ) // 단순한 차례대로 읽기밖에 못함
		{
			System.out.println(s);
		}
		System.out.println();
		
		// 9. 초기화
		// - 모든 요소 삭제 = 모든 방.remove()
		// - void clear()
		
		System.out.println(list); // [사과, 바나나, 포도, 파인애플, 망고, 파파야]
		list.clear(); // 모든 요소 삭제
		// list = new ArrayList<String>(); // 모든 요소를 삭제한게 아니라 옛날 ArrayList를 버리고 새걸로 바꾼것
		// 기존 참조가 끊긴다, 겉보기에는 구분이 안 감(주소값 100에 있던 참조를 끊고 200번지에 있는 새거랑 연결함)
		// 100번지에 있던건 garbage라고 부름 <- 메모리 해제(릴리즈)를 해야하는데 자바에선 개발자가 직접 못함, 자바가 알아서 함
		// 쓰레기차가 알아서 회수해가는데 쓰레기차를 garbagecollector라고 부름
		// 그때 100번지에 있던건 소멸됨
		System.out.println(list); // []
		
		// 10. 빈 배열 확인
		// - boolean isEmpty()
		// - 메서드 이름이 is로 시작하면 대부분 반환값이 boolean이다
		System.out.println(list.isEmpty());
		list.add("사과");
		System.out.println(list.isEmpty());
		
	}

	private static void m1()
	{
		
		// 순수 배열
		// 타입 명시(int)
		// 길이 명시(3), 나중에 길이 못바꿈
		// 그럼 ArrayList 쓰지 배열은 왜 씀? <- 고정 길이면 배열이 성능이 제일 좋음
		int[] nums1 = new int[3];
		
		// 요소 접근 -> 첨자(index) 사용 / [1] <- 1번 방
		nums1[0] = 10; // [] 안에 번호 넣는걸 Indexer(인덱서) 라고 함
		nums1[1] = 20;
		nums1[2] = 30;
		
		System.out.println(nums1[0]); // 방 안에 있는거 꺼내보기
		System.out.println(nums1[1]);
		System.out.println(nums1[2]);
		
		System.out.println(nums1.length); // 배열의 길이
		System.out.println();
		
		// 컬렉션(Arraylist)와 비교
		// ArrayList nums2 = new ArrayList();
		// 타입 명시(제네릭)
		// 길이 없음 -> 가변길이라서(*****) <- 이거 때문에 많이 씀
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		// 요소 접근 -> 끝에다 추가한다고 해서 Append라고 함
		nums2.add(10); // 0번째 방 / 인덱서 지원이 되지 않아 메서드 형태로 값을 넣는다
		nums2.add(20); // 1번째 방
		nums2.add(30); // 2번째 방 / 길이도 없고 방의 번호도 표시 안해도 됨, 자동으로 방 번호가 매겨짐
		
		System.out.println(nums2.size()); // 길이를 보고싶을 때
		System.out.println(nums2.get(0)); // 방에 있는거 꺼낼 때
		System.out.println(nums2.get(1));
		System.out.println(nums2.get(2));
		
		System.out.println();
		
		System.out.println(Arrays.toString(nums1)); // 배열 덤프
		System.out.println(nums2); // ArrayList 덤프
		// ArrayList의 할아버지(AbstractList)가 toString을 오버라이딩해두었다
		
	}
}


// 학생 1명의 클래스를 만들자
class Score
{
	private int no; // 학번
	private String name; // 이름
	private int kor; // 국어 성적
	private int eng; // 영어 성적
	private int math; // 수학 성적
	
	public int getNo()
	{
		return no;
	}
	
	public void setNo(int no)
	{
		this.no = no;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
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
	
	// 계산된 프로퍼티
	// 총점 구하기
	public int getTotal()
	{
		return this.kor + this.eng + this.math;
	}
	
	// 성적 평균 구하기
	public double getAvg()
	{
		return this.getTotal() / 3.0;
	}
}