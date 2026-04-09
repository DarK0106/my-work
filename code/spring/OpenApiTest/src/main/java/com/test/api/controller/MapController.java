package com.test.api.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.api.model.MapDao;
import com.test.api.model.MapDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MapController {

	private final MapDao dao;

	@GetMapping(value = "/map01.do")
	public String map01(Model model) {
		return "map01";
	}

	@GetMapping(value = "/map02.do")
	public String map02(Model model) {
		return "map02";
	}

	@GetMapping(value = "/map03.do")
	public String map03(Model model) {
		return "map03";
	}

	@GetMapping(value = "/map04.do")
	public String map04(Model model) {

		List<MapDto> list = dao.list();

		model.addAttribute("list", list);

		return "map04";
	}

	@PostMapping(value = "/add.do")
	public String add(Model model, MapDto dto) {

		dao.add(dto);

		return "redirect:/map04.do";
	}

	@GetMapping(value = "/map05.do")
	public String map05(Model model) {
		return "map05";
	}

	@GetMapping(value = "/map06.do")
	public String map06(Model model) {
		return "map06";
	}

	@GetMapping(value = "/map07.do")
	public String map07(Model model) {
		return "map07";
	}

	@PostMapping(value = "/map07ok.do")
	public String map07ok(Model model
						, @RequestParam("startLat") String startLat
						, @RequestParam("startLng") String startLng
						, @RequestParam("endLat") String endLat
						, @RequestParam("endLng") String endLng) {
		
		if (startLat != null && startLng != null && endLat != null && endLng != null) {
			
			try {
			
				String start = startLng + "," + startLat;
				String end = endLng + "," + endLat;
				String key = "04e0cf81b9f1cc6780f0d099dc7f8e75";
				
				//DISTANCE: 최단 거리 > 도보 or 자전거
				//TIME: 최단 시간 > 자동차 or 대중교통
				//RECOMMEND: 최단 거리 + 최단 시간
				String url = "https://apis-navi.kakaomobility.com/v1/directions?origin=" + start + "&destination=" + end + "&priority=RECOMMEND";
				
				URL url2 = new URL(url);	
				HttpURLConnection conn = (HttpURLConnection)url2.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Authorization", "KakaoAK " + key);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				StringBuilder sb = new StringBuilder();
				
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				
				reader.close();
				conn.disconnect();
				
				//System.out.println(sb);
				model.addAttribute("routeData", sb.toString());
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return "map07ok";
	}
}
