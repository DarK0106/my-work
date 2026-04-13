package com.test.java.crawl;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Ajax 배울 때 만들었던 사이트의 데이터를 크롤링해보자
public class Ex03 {
	public static void main(String[] args) {

		// Ex03.java

//		JSoup 
//		- 정적 컨텐츠를 크롤링하는 도구 
//		- HTML 소스 상에 있는 내용을 탐색 
//		- JavaScipt 결과는 탐색할 수 없음 ->
//		동적으로 만들어진 사이트, 즉 CSR 방식으로 만들어진 사이트는 
//		JSoup이 JavaScript를 실행시키지 못해 크롤링 할 수 없음
		 
//		이런 문제를 해결하기 위해 Selenium, Platwright 사용
		  
//		Selenium은 크롤링 하는 도구는 아니고 자동화 테스트 도구이다. 
//		-> 사람 대신 브라우징을 하는 프로그램이다.
		 
//		Selenium의 원래 목적은 사이트를 다 만들고 테스트를 하기 위해 사용하는 도구이다.
		  
//		Selenium 을 사용하기 위해 
//		1. 드라이버 설치(의존성 추가) 
//		2. 크롬 드라이버 설치(chromedriver.exe) 
//		각 브라우저 회사들이 자사 브라우저 기반으로 
//		Selenium이 쓸 수 있는 브라우저 파일을 제공함 
//		크롬 드라이버를 설치할 때 현재 쓰고 있는 크롬 버전을 
//		반드시 확인해서 버전이 같은지 확인해야 함 
//		요즘 브라우저들은 자동으로 업데이트 되는 에버그린 브라우저
		
		// m1();
		// m2();
		// m3();
		m4();

	} // main

	private static void m4() {

		// 크롤링이 불가능했던 Ajax로 만들었던 사이트를
		// 크롤링 해보자
		// JSoup은 자바스크립트를 실행하지 못하고 
		// HTML 소스를 그대로 가져오기 때문에 크롤링을 하지 못했었음
		
		// 이제 셀레니움으로 시도해볼 차례
		String url = "http://localhost:8080/ajax/ex08.do";

		// 크롬드라이버
		String webDriverId = "webdriver.chrome.driver";
		String path = "C:\\Ssangyong\\dev\\chromedriver.exe";
		System.setProperty(webDriverId, path);

		WebDriver driver = new ChromeDriver();
		// 드라이버가 URL을 가져옴
		driver.get(url);
		
		List<WebElement> list = driver.findElements(By.cssSelector("#tbl1 tbody tr"));
		
		// 루프 돌면서 tr 태그를 하나씩 가져오면서
		// 그 안의 td를 빼냄
		for (WebElement tr : list) {
			
			// 이 tr 안에서만 또 검색을 하는 것
			String name = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
			
			System.out.println(name);
			
		}
		
	}

	private static void m3() {

		// 쌍용 사이트 자동 로그인 해보기

		// 아이디
		String name = "황윤재";
		// 비밀번호
		String pw = "6722";

		// 접속할 로그인 페이지의 URL
		String url = "http://lms1.sist.co.kr/worknet/SLogin.asp";

		// 크롬드라이버
		String webDriverId = "webdriver.chrome.driver";
		String path = "C:\\Ssangyong\\dev\\chromedriver.exe";
		System.setProperty(webDriverId, path);

		WebDriver driver = new ChromeDriver();
		// 드라이버가 URL을 가져옴
		driver.get(url);

		// 아이디랑 비밀번호 작성하기
		driver.findElement(By.id("strLoginID")).sendKeys(name);
		driver.findElement(By.id("strLoginPwd")).sendKeys(pw);

		// 로그인 버튼 클릭하기
		driver.findElement(By.cssSelector(".login-btn > input")).click();

		// ** 페이지 전환 > 잠시 쉬었다 가기
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 로그인 했으니 1대1 문의 버튼 클릭해보기
		driver.findElement(By.cssSelector(
				"#content > div > div > div > div.panel-body > div.popbtmbtn_section > div > a:nth-child(9)")).click();

		// ** 모달창 > 잠시 쉬었다 가기
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 1대1 문의 에서 글쓰기 버튼을 클릭하려고 했으나
		// 창이 뜨는데 걸리는 시간을 생각하지 못하고 크롬브라우저가
		// 글쓰기 버튼을 찾으려고 시도해서 결과적으로 글쓰기 버튼이 눌리지 않았음

		// 그래서 중간 중간에 쉬어주는걸 넣어야함

		// 글쓰기 버튼 클릭하기
		driver.findElement(By.id("saveBt")).click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 제목 작성하기
		driver.findElement(By.cssSelector("input[name=formBD_SUBJECT]")).sendKeys("질의 사항이 있습니다.");

	}

	private static void m2() {

		// Selenium을 써보자

		// 접속하고자 하는 URL 확보
		String url = "https://naver.com";

		// 크롬드라이버
		String webDriverId = "webdriver.chrome.driver";
		String path = "C:\\Ssangyong\\dev\\chromedriver.exe";
		System.setProperty(webDriverId, path);

		// 자바가 사용하는 브라우저
		WebDriver driver = new ChromeDriver();
		// URL을 가져와라
		driver.get(url);

		// 이 다음에 이제 뭐함?
		// 하고 싶은 행동을 시키면 됨
		// element 태그를 찾아라

		// 현재 띄워진 창의 검색어를 입력하는 텍스트 박스를 찾았음
		WebElement e1 = driver.findElement(By.id("query"));

		// 여기다 검색어를 넣자
		e1.sendKeys("스프링 부트");

		// 이제 검색 버튼을 누르자
		// 일단 검색 버튼을 찾았음
		WebElement e2 = driver.findElement(By.className("btn_search"));

		// 이제 검색 버튼을 클릭함
		e2.click();
	}

	private static void m1() {

		String url = "http://localhost:8080/ajax/ex08.do";

		try {

			// 데이터를 긁어온다
			Document doc = Jsoup.connect(url).get();

			// 특정 데이터를 리스트로 받기
			Elements list = doc.select("#tbl1 tbody tr");

			// 몇개를 가져왔는지 세기
			System.out.println(list.size());

			// 문제: 숫자를 세봤는데 결과가 1로 나옴
			// 눈에 보이는 페이지가 크롤링 해볼만하게 생겨서 해봐도
			// 온전히 할 수 있는게 아님

			// 지금 상황과 같은 경우 ajax로 클라이언트쪽에서 DOM을 조작해서 만들어진 사이트
			// 즉 CSR로 만든 페이지는 크롤링을 하지 못함
			// 정적인 페이지나 JSP로 만든 페이지만 크롤링 할 수 있음

		} catch (Exception e) {
			System.out.println("Ex03.main");
			e.printStackTrace();
		}
	}
}
