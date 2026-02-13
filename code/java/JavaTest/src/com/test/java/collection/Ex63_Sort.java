package com.test.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Ex63_Sort
{
	public static void main(String[] args)
	{
		// Ex63_Sort.java
		/*
		 * 
		 * 왜 익명클래스를 사용하는지 알아보자
		 * 
		 * 정렬, Sort
		 * - 배열, 컬렉션(List 계열)
		 * - 순서가 있는 데이터 집합에 한해서 .. 
		 * 
		 */
		
		// m1();
		// m2();
		// m3();
		// m4();
		m5();
		
	}

	private static void m5()
	{
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee("홍길동","개발부","부장"));
		list.add(new Employee("병아리","영업부","대리"));
		list.add(new Employee("강아지","개발부","사원"));
		list.add(new Employee("고양이","영업부","부장"));
		list.add(new Employee("아무개","개발부","과장"));
		list.add(new Employee("거북이","영업부","사원"));
		list.add(new Employee("테스트","개발부","대리"));
		
		// The method sort(List<T>) in the type Collections is not applicable for 
		// the arguments (ArrayList<Employee>)
//		Collections.sort(list, comparator);
		
		list.sort(new Comparator<Employee>()
		{
			@Override
			public int compare(Employee o1, Employee o2)
			{
//				return o1.getName().compareTo(o2.getName()); // o1 이랑 o2 중에 ㄱㄴㄷ순으로 비교했을때 누가 먼저 앞에 와야하나?
//				return o1.getDepartment().compareTo(o2.getDepartment());
				// return o1.getPosition().compareTo(o2.getPosition()); // 직위별로 정렬하고 싶은데 ㄱㄴㄷ순으로 정렬됨
				// 직위 자체의 순수한 데이터 값으로는 내가 원하는대로 비교가 불가능하니 각 직위에 숫자를 대입해서 정렬해보자
//				return o2.getPositionNumber() - o1.getPositionNumber(); // 부장님 ~ 사원
				
				if (o1.getPositionNumber() > o2.getPositionNumber())
				{
					return 1; // 앞이 커서 양수를 반환하면 오름차순
				}
				else if (o1.getPositionNumber() < o2.getPositionNumber())
				{
					return -1; // 뒤가 커서 음수를 반환하면 내림차순
				}
				else
				{
//					return 0; // 둘이 똑같을 때 -> 문제) 같은 직위끼리의 정렬을 자바 마음대로 해버림
					// 직위가 동일한 사람들끼리는 재조건을 제시해서 다시 정렬해보자
					
					return o1.getName().compareTo(o2.getName()); // 부서로 판가름이 안 나면 이름(가나다순)으로 판가름하라
				}
			}
		});
		System.out.println(list);
		
	}

	private static void m4()
	{
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("강아지");
		names.add("매미");
		names.add("라쿤");
		names.add("다람쥐");
		names.add("나비");
		
//		Comparator<String> comparator = new Comparator<String>() // 굳이 클래스를 따로 만들지 않아도 comparator를 확보할 수 있다
//		{
//			@Override
//			public int compare(String o1, String o2)
//			{
//				return o2.compareTo(o1);
//			}
//		};
//		
//		// 내림차순
//		// 익명 객체를 사용
//		// 클래스를 구현한 클래스의 인스턴스를 만든다?
//		names.sort(comparator);
		
//		names.sort(new Comparator<String>()
//		{
//			@Override
//			public int compare(String o1, String o2)
//			{
//				return o2.compareTo(o1);
//			}
//		});
		
		names.sort((o1, o2) -> o2.compareTo(o1));
		
		System.out.println(names);
	}

	private static void m3()
	{
		String[] names = { "강아지", "고양이", "병아리", "닭", "참새" };
		
//		Arrays.sort(names);
		
		// 내림차순 정렬을 하기 위해선 내가 직접 해야 한다
		Arrays.sort(names, new MyComparator());
		System.out.println(Arrays.toString(names));
	}

	private static void m2()
	{
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("강아지");
		names.add("타조");
		names.add("거북이");
		names.add("독수리");
		names.add("고양이");
		
		System.out.println(names);
		
		// 오름차순
//		Collections.sort(names);
//		System.out.println(names);
		
		// 내림차순 정렬은?
		// 최소한의 코드로 내림차순을 구현해보자
//		Collections.reverse(names); // 순서를 반대로 뒤집는 
//		System.out.println(names);
		
		// 내림차순 하는 방법은 아님
		// 내가 원하는 모든 정렬을 하는 방법
		// 
		
		MyComparator my = new MyComparator(); 
//		Collections.sort(names, my); // 내가 직접 알려줄테니까 내가 알려준 방법대로 정렬해
//		names.sort(my);
		System.out.println(names);
		
		
		
	}

	private static void m1()
	{
		// 정렬
		// - 오름차순, 내림차순
		// 1. 직접 우리가 정렬 알고리즘을 직접 만들어서 쓰는 방법
		// 2. JDK가 제공해주는 기능 <- 대부분 이거 씀
		
		// 정렬 -> 우위 비교를 통해서 자리를 바꾸는 행동

		// 우위 비교가 가능한 자료형
		// 1. 숫자
		// 2. 문자, 문자열 <- 문자코드로 비교
		// 3. 날짜, 시간 <- 타임스태프로 비교
		
		// 정렬 메서드
		// Arrays.sort()
		// Collections.sort()
		
		// 1.a 숫자 + 배열
		int[] nums1 = { 1, 5, 3, 2, 4 };
		
		System.out.println(Arrays.toString(nums1));
		
		// 정렬(오름차순)
		Arrays.sort(nums1);
		// 내림차순 정렬해주는 메서드는 공식적으론 없다
		
		// 1.b 숫자 + 컬렉션
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		
		
		nums2.add(1);
		nums2.add(5);
		nums2.add(3);
		nums2.add(4);
		nums2.add(2);
		
		System.out.println(nums2);
		Collections.sort(nums2);
		
		System.out.println(nums2);
		System.out.println();
		
		// 2. 문자열
		String s1 = "Java";
		String s2 = "Oracle";
		
//		System.out.println(s1 > s2);
		System.out.println('J' > 'O');
		System.out.println(s1.compareTo(s2)); // 음수 출력 / 0이 나오면 똑같다. 양수면 앞의 값이 더 크다, 음수면 뒤의 값이 더 크다
		
		char c1 = 'A';
		char c2 = 'F';
		
		System.out.println(c1 > c2);
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("강아지");
		names.add("타조");
		names.add("거북이");
		names.add("독수리");
		names.add("고양이");
		
		System.out.println(names);
		
		// 정렬?: 버블, 선택, 힙, 퀵, 삽입, Merge
		
		// sort() 메서드는 퀵정렬을 썼다고 알려져있다
		Collections.sort(names);
		System.out.println(names);
		
		// 3. 날짜 시간 정렬
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		
		d2.add(Calendar.MINUTE, 30);
		
//		System.out.println(d1 > d2); // 참조형이니까 비교안됨
		System.out.println(d1.getTimeInMillis() > d2.getTimeInMillis());
		
		System.out.println(d1.compareTo(d2)); // 음수가 나오면 앞에 애가 더 작고, 양수가 나오면 앞에 애가 더 크다
		System.out.println();
		
		ArrayList<Calendar> times = new ArrayList<Calendar>();
		
		// 날짜 만들기
		times.add(Calendar.getInstance());
		times.get(0).add(Calendar.DATE, 0);
		
		times.add(Calendar.getInstance());
		times.get(1).add(Calendar.DATE, -7);
		
		times.add(Calendar.getInstance());
		times.get(2).add(Calendar.DATE, +3);
		
		times.add(Calendar.getInstance());
		times.get(3).add(Calendar.DATE, -2);
		
		times.add(Calendar.getInstance());
		times.get(4).add(Calendar.DATE, 1);
		
		for (Calendar c : times)
		{
			System.out.printf("%tF\n",c);
		}
		System.out.println();
		
		Collections.sort(times); // 정렬
		
		for (Calendar c : times)
		{
			System.out.printf("%tF\n",c);
		}
		System.out.println();
	}
}


// T: < > 안에 정렬을 하려는 배열의 요소 타입을 쓰자
class MyComparator implements Comparator<String> // 사용자가 정의하는 정렬 클래스
{
	@Override
	public int compare(String o1, String o2)
	{
		System.out.println(o1 + ":" + o2);
		
		// 내가 만약 오름차순을 하고싶으면 o1 - o2
		// 내가 만약 내림차순을 하고싶으면 o2 - o1
		
//		return o1.compareTo(o2); // o1 o2 면 오름차순, o2 o1 이면 내림차순 으로 변경 가능
		return o2.length() - o1.length();
	}
}

class Employee
{
	private String name;
	private String department;
	private String Position;

	public Employee(String name, String department, String position)
	{
		super();
		this.name = name;
		this.department = department;
		Position = position;
	}

	@Override
	public String toString()
	{
		return String.format("\n%s(%s,%s)", this.name, this.department, this.Position);
	}
	
	public int getPositionNumber() // 직급별로 정렬하고 싶어서 만든 메서드
	{
		if(this.Position.equals("사원"))
		{
			return 1;
		}
		
		else if(this.Position.equals("대리"))
		{
			return 2;
		}
		
		else if(this.Position.equals("과장"))
		{
			return 3;
		}
		
		else if(this.Position.equals("부장"))
		{
			return 4;
		}
		
		return -1; // 이것도 저것도 해당이 안되는 값이 오면 아무 의미 없는 값으로 반환해주자
		
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getPosition()
	{
		return Position;
	}

	public void setPosition(String position)
	{
		Position = position;
	}
	
	
}