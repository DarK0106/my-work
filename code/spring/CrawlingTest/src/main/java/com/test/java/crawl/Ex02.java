package com.test.java.crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {
	public static void main(String[] args) {

		//Ex02.java
		try {
			String url = "https://www.moviechart.co.kr/rank/boxoffice";
			
			Document doc = Jsoup.connect(url).get();
			
			// System.out.println(doc.html());
			
			// 개봉일, 제목, 별점 등 정보를 가져오려면
			// 검색을 계속 해야하는데 그것보단
			// 그게 모두 포함되어있는 <tr>을 가져오자
			// 근데 <thead>는 또 가져오면 안됨
			
			// 영화 하나를 담고 있는 tr을 찾아서 가져온다
			Elements list = doc.select(".listTable > table > tbody > tr");
			
			System.out.println(list);
			
			// 알기 쉽게 tr을 가져오자
			// 자식인 td 중 title이라는 클래스를 갖는 애의
			// a 태그의 PCDATA 를 찾자
			// document
			// 특정 태그.find("CSS")
			for (Element tr : list) {
				
				String title = tr.select(".title > a").text();
				System.out.println(title);
				
				System.out.printf("%s - %s, %s\n", tr.select(".redAc").text(), tr.select(".date").text(), tr.select(".audience").text());
				System.out.println();
				
				// 영화 상세 페이지로 들어가자
				// /info/movieinfo/detail/20254121
				tr.select(".title > a").attr("href");
				
				// 각 영화 별 상세 페이지의 주소로 가서
				// 또 다른 document를 얻어온다
				Document subdoc = Jsoup.connect("https://www.moviechart.co.kr" + tr.select(".title > a").attr("href")).get();
						
				// 그 데이터(영화 상세 페이지)에서 난 장르를 얻어오고 싶다
				// F12 -> 소스 클릭 -> 클릭된 소스 우클릭 -> Copy -> Copy Selector
				// #content > div.info > div > div.movieIner > div.movieIner__text > div > ul > li:nth-child(2) > dl > dt
				
				// 장르를 가져오자
				String genre = subdoc.select("#content > div.info > div > div.movieIner > div.movieIner__text > div > ul > li:nth-child(2) > dl > dt").text();
				System.out.println(genre.split("/")[0].trim());
				System.out.println();
				System.out.println();
				System.out.println();
				
			}
			
			// 소스를 보니까 listTable.group1가 있고 listTable.group2가 있음
			// 그러면 listTable를 가져오면 다 가져올 수 있을듯
			
		} catch (Exception e) {
			System.out.println("Ex02.main");
			e.printStackTrace();
		}


	}
}
