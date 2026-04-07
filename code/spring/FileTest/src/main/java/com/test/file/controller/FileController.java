package com.test.file.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FileController {
	
	private final ServletContext servletContext; // application 객체
	
	@GetMapping(value = "/ex01.do")
	public String ex01(Model model) {
	
		System.out.println(servletContext != null);
		
		return "ex01";
	}
	
	@PostMapping(value = "/ex01ok.do")
	public String ex01ok(Model model, @RequestParam("txt") String txt, MultipartFile attach) {
		
		System.out.println("txt: " + txt);
		
		// 업로드된 파일의 태그 이름을 반환
		System.out.println(attach.getName()); // <input type="file name="attach"<- 이게 출력됨
		
		System.out.println(attach.getOriginalFilename()); // images.jpg
		System.out.println(attach.getContentType()); // image/jpeg
		System.out.println(attach.getSize()); // 6202
		System.out.println(attach.isEmpty()); // false, 즉 첨부 파일이 있다는 것
		
		// 업로드된 파일이 어디 있을까?
		// 임시 폴더에 있는 업로드 파일을 우리가 의도한 보관 파일에 옮기는 작업을
		// 개발자가 해야함
		
		String path = servletContext.getRealPath("/resources/files");
		System.out.println(path);
		
		// 임시 폴더에서 보관 파일로 옮기는 작업
		try {
			
			// 파일명이 중복되는 경우를 방지하자
			// 방법 1. 숫자 붙이기(cos.jar의 방식)
			// 방법 2. 고유 파일명 만들기
			// 		- 시간_파일명
			//		- 난수_파일명
			// 방법 3. UUID 사용
			// UUID는 뭘까? 시간 + 난수의 로직을 섞은 것
//			String filename = getUniqueFileName(path, attach.getOriginalFilename());
//			String filename = getUniqueFileName2(attach.getOriginalFilename());
			String filename = getUniqueFileName3(attach.getOriginalFilename());
			
			File file = new File(path + "\\" + filename);
			attach.transferTo(file); // renameTo?
			
			model.addAttribute("txt",txt);
			model.addAttribute("filename", filename);
			model.addAttribute("filetype", attach.getContentType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 문제: 똑같은 이름의 다른 파일을 올리면 덮어쓰기를 해버림

		return "ex01ok";
	}
	
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String filename, HttpServletRequest req) {

		String path = req.getRealPath("/resources/files");
		Resource resource = new FileSystemResource(path + "\\" + filename);

		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String resourceName = resource.getFilename();

		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();
		try {

			String downloadName = null;

			if (userAgent.contains("Trident")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			} else {
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}


			headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	// 방법 3. UUID 사용
	private String getUniqueFileName3(String filename) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		
		return uuid + "_" + filename;
	}

	// 방법 2. 고유 파일명 만들기
	private String getUniqueFileName2(String filename) {
		
		// 예: 회원.txt -> rgsnrs23rsn4_회원.txt
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		return System.nanoTime() + "_" + filename;
	}
	
	// 방법 1. 숫자 붙이기(cos.jar의 방식)
	private String getUniqueFileName(String path, String filename) {
		// 중복된 파일명을 체크해서 중복이 안되게끔 뒤에 숫자를 붙이는 메서드
		// 예: 회원.txt -> 회원_1.txt -> 회원_2.txt
		
		// 뒤에 붙을 숫자 변수
		int n = 1;
		
		String orgFilename = filename;
		
		// 참조 변수
		File file = null;
		
		// 몇번만에 끝나는지 모르니까 무한루프
		while (true) {
			// 파일 객체를 만들어라
			file = new File(path + "\\" + filename);
			
			// 똑같은 파일명이 있는지 없는지 찾자
			if (file.exists()) {
				// 중복된 파일명이 있다
				// 파일명이 회원.txt인걸 회원_1.txt로 바꿔야 함
				int lastIndex = orgFilename.lastIndexOf(".");
				// 확장자 없는 순수한 파일 이름인 fileNameWithoutExtension
				String fileNameWithoutExtension = orgFilename.substring(0, lastIndex);
				
				// 확장자
				String extension = orgFilename.substring(lastIndex);
				
				// 여기까지가 파일명을 두 덩어리로 자른 것
				
				// "회원" + "_" + n + ".txt"
				// 결과: 회원_n.txt
				filename = fileNameWithoutExtension + "_" + n + extension;
				n++;
				
			} else {
				// 중복된 파일명이 없다
				return file.getName();
			}
		}
		
	}
}
