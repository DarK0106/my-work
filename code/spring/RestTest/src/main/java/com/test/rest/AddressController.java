package com.test.rest;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.model.AddressDao;
import com.test.rest.model.AddressDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

// @ResponseBody
// @Controller

// REST API 전용 컨트롤러
@RestController
@RequiredArgsConstructor
// 설명 작성
@Api(value ="주소록 컨트롤러", description = "주소록 데이터 처리를 위한 REST Controller 입니다.")
public class AddressController {
	
	private final AddressDao dao;
	
	@ApiOperation(value = "주소록 목록 보기", notes = "주소록 목록을 반환합니다.")
	@GetMapping(value = "/m1.do")
	public AddressDto m1(Model model) {
		
		// AddressDto를 매핑해서 json으로 만들어보자
		// 방법 1. 직접 문자열로 json으로 만들기
		// 방법 2. JSONObject(simple-json)
		// 방법 3. jackson-databind의 @ResponseBody
		// 반환값에 @ResponseBody 넣기 -> 특정 메서드만 적용
		// 클래스에 @ResponseBody 넣기 -> 모든 메서드에 적용
		// REST API 전용 컨트롤러인 @RestController 사용
		
		AddressDto dto = dao.m1();
		
		return dto;
	}
	
	// CRUD 중 추가하기 기능
	// 1. http://localhost:8080/rest/address
	// 2. POST
	// 3. return값은 int(사실 추가하기인데 리턴값은 없는게맞는데 그냥 피드백용으로
	// 성공하면 1 실패하면 0 이런 느낌)
	// @ResponesBody: 돌려주는 데이터의 본문 데이터를 json으로 돌려받을게요
	// 지금은 그 반대인 @RequestBody
	@PostMapping(value = "/address")
	public int add(@RequestBody AddressDto dto) {
		
		// REST Server가 수신하는 데이터 형식
		// 1. Query String -> book.do?query=검색&start=10
		// 2. JSON -> book.do + raw에 json을 직접 작성
		
		// 이제 보낼때도 json으로 보내고 받을때도 json으로 받겠다
		
		return dao.add(dto);
		
	}
	
	// CRUD의 R인 목록 보기
	// 주소 정의
	// 1. http://localhost:8080/rest/address
	// 2. 메서드를 GET 방식으로
	// 3. 반환값은 List<AddressDto> 인데 모든 입출력을 json 으로 하기로 했으니까
	// jackson-databind가 json으로 매핑해줌
	@GetMapping(value = "/address")
	public List<AddressDto> list(Model model) {
		
		return dao.list();
	}
	
	// 수정하기
	// 1. http://localhost:8080/rest/address/1
	// 아 1번 녀석을 수정하는구나
	// URL 에 드러나는건 식별자까지만
	// 2. 모든 컬럼을 수정하기 위해 PUT
	// 3. 반환값 int(성공하면 1, 실패하면 0, 별 의미 없음)
//	@RequestMapping(value = "/address/1", method = RequestMethod.PUT)
	@PutMapping(value = "/address/{seq}") // {seq} 이걸 경로 변수(Path Variable)이라고 함
	// {seq} "seq" String seq 다 똑같은 애들
	public int edit(@PathVariable("seq") String seq, @RequestBody AddressDto dto) {
		
		// 따로 받아왔기 때문에 둘을 합쳐야함
		dto.setSeq(seq);
		
		// dao한테 수정하라고 할때는 dto만 넘기면된다
		return dao.edit(dto);
	}
	
	// 삭제하기
	// 1. http://localhost:8080/rest/address/1
	// 2. DELETE
	// 3. 반환값 int(성공하면 1, 실패하면 0, 별 의미 없음)
	@DeleteMapping(value = "/address/{seq}")
	public int del(@PathVariable("seq") String seq) {
		
		return dao.del(seq);
	}
	
}
