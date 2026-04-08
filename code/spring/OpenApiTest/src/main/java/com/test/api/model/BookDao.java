package com.test.api.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	public List<BookDto> search(String word, String page) {

		String clientId = "_WqPf9IWsylfhiUUfd5a";
		String clientSecret = "Q4y0b9taur";

		String text = null;

		try {
			text = URLEncoder.encode(word, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		// 1. 넘어온 page 문자열을 숫자로 바꿔서 시작 번호 계산 (한 페이지당 5개 기준)
		int startIdx = (Integer.parseInt(page) - 1) * 5 + 1;

		// 2. JSON 결과 URL에 page 대신 계산된 startIdx 변수를 넣어줌
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&display=5&start=" + startIdx;

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		// responseBody > 파싱 > List<BookDto>

		List<BookDto> blist = new ArrayList<BookDto>();

		JSONParser parser = new JSONParser();

		try {

			JSONObject root = (JSONObject) parser.parse(responseBody);

			JSONArray list = (JSONArray) root.get("items");

			for (Object obj : list) {

				// obj 1개 == 책 1권 > BookDto 1개
				JSONObject book = (JSONObject) obj;

				BookDto dto = new BookDto();

				dto.setTitle(book.get("title").toString());
				dto.setLink(book.get("link").toString());
				dto.setImage(book.get("image").toString());
				dto.setAuthor(book.get("author").toString());
				dto.setDiscount(book.get("discount").toString());
				dto.setPublisher(book.get("publisher").toString());

				blist.add(dto);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return blist;
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}

}
