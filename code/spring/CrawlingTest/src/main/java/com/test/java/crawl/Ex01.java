package com.test.java.crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Ex01 {
	public static void main(String[] args) {

		//Ex01.java
		
		// Jsoup이 웹사이트에 실제로 접속해서
		// 접속한 페이지의 소스를 문자열로 읽어옴
		// 소스를 분석함(파싱)
		// 우리한테 그걸 탐색할 수 있도록 여러 가지 도구를 제공함
		// 우리는 그걸로 원하는 데이터를 수집하면 됨
		
		// https://jsoup.org 이 주소를 브라우저가 요청하면 서버가
		// 브라우저에게 소스를 돌려주는데 브라우저는 돌려받은 소스(문자열)을
		// 분석해서 보기 좋게 바꿔서 화면을 만든다
		// 엄연한 페이지는 소스 자체이고 
		// 우리가 늘상 보던 페이지는 브라우저가 예쁘게 만들어 놓은 것
		
		// https://jsoup.org 이 주소를 jsoup이 요청하면 서버가
		// jsoup에게 소스를 돌려주는데 jsoup은 소스를 분석해서 탐색 도구를 제공한다
		// HTML이라는 소스를 jsoup은 이해를 하고 있다
		
		try {
			
			// 내가 크롤링할 사이트 URL
			String url = "https://jsoup.org";
			
			// 접속해서 읽어온 문서 내용을 담고 있는 객체
			// 자바스크립트의 document 객체와 굉장히 유사함
			Document doc = Jsoup.connect(url).get();
			
			// 데이터 출력해보기
			System.out.println(doc.html());
			// 소스를 받아온 것 까진 성공
			// 이제 수많은 소스 중에 내가 원하는
			// 특정 데이터가 어디 있는지 찾아야 함
			
			// 자바스크립트에서의 document.querySelector("CSS 선택자")
			// 와 유사한 역할
			
			// 우리가 찾고자 하는 특정 데이터의 h1 태그의 ID
			Elements result = doc.select("#jsoup-java-html-parser");
			
			System.out.println(result.size()); // 1
			// 우리가 찾고자 하는 특정 데이터의 내용(여기선 제목을 끌고 왔음)
			System.out.println(result.get(0).text());
			
			// 크롤링 자체는 어렵지 않지만 원본이 되는 소스가 패턴이 이상해서
			// 분석하기가 어려움(크롤링 하려는 사이트 소스가 개판이라)
			
		} catch (Exception e) {
			System.out.println("Ex01.main");
			e.printStackTrace();
		}


	}
}
