package com.test.java.crawl.model;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	public List<MovieDto> list() {
		
		List<MovieDto> mlist = new ArrayList<MovieDto>();
		
		try {
			String url = "https://www.moviechart.co.kr/rank/boxoffice";

			Document doc = Jsoup.connect(url).get();

			Elements list = doc.select(".listTable > table > tbody > tr");

			System.out.println(list);

			for (Element tr : list) {
				
				// 옮겨 담을 상자를 만든다
				MovieDto dto = new MovieDto();
				
				String title = tr.select(".title > a").text();
				String seq = tr.select("redAc").text();
				String date = tr.select(".date").text();
				
				dto.setSeq(seq);
				dto.setTitle(title);
				dto.setDate(date);

				Document subdoc = Jsoup.connect("https://www.moviechart.co.kr" + tr.select(".title > a").attr("href")).get();

				// 장르
				String genre = subdoc.select("#content > div.info > div > div.movieIner > div.movieIner__text > div > ul > li:nth-child(2) > dl > dt").text();
				
				// 감독
				String director = subdoc.select("#content > div.info > div > div.movieIner > div.movieIner__text > div > ul > li:nth-child(3) > dl > dt").text();
				
				// 배우
				String actor = subdoc.select("#content > div.info > div > div.movieIner > div.movieIner__text > div > ul > li:nth-child(4) > dl > dt").text();
				
				// actor를 통째로 가져왔으니 배열로 쪼개자
				String[] actorList = actor.split(",");
				
				// 포스터 이미지
				String poster = subdoc.select("#content > div.info > div > div.movieIner > div.poster > a > img").attr("src");
				
				dto.setGenre(genre);
				dto.setDirector(director);
				dto.setActor(actorList);
				dto.setPoster(poster);
				
				// 상자에 데이터를 담는다
				mlist.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mlist;
	}
}
