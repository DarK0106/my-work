package com.test.api.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Ex01 {

	public static void main(String[] args) {

		String clientId = "_WqPf9IWsylfhiUUfd5a";
		String clientSecret = "Q4y0b9taur";

		String text = null;

		try {
			text = URLEncoder.encode("자바", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		// JSON 결과
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;

		// XML 결과
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		// 검색 결과(XML, JSON)
		// System.out.println(responseBody);
		JSONParser parser = new JSONParser();

		try {
			JSONObject root = (JSONObject) parser.parse(responseBody);

			System.out.println(root.get("total") + "권");

			JSONArray list = (JSONArray) root.get("items");

			System.out.println(list.size());

			for (Object obj : list) {

				// obj 1개가 책 1권
				JSONObject book = (JSONObject) obj;

				System.out.println("제목: " + book.get("title"));
				System.out.println("저자: " + book.get("author"));
				System.out.println("가격: " + book.get("discount"));
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

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
