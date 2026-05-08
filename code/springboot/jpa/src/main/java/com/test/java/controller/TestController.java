package com.test.java.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.querydsl.core.Tuple;
import com.test.java.entity.Board;
import com.test.java.entity.Item;
import com.test.java.entity.User;
import com.test.java.entity.UserInfo;
import com.test.java.model.ItemDto;
import com.test.java.repository.BoardRepository;
import com.test.java.repository.ItemQueryDSLRepository;
import com.test.java.repository.ItemRepository;
import com.test.java.repository.UserInfoRepository;
import com.test.java.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	private final UserInfoRepository userInfoRepository;
	private final BoardRepository boardRepository;
	
	private final ItemQueryDSLRepository itemQueryDSLRepository;

	/*
		DB 조작
		1. JDBC 쿼리를 문자열로 날림
		2. MyBatis 쿼리를 XML로 날림
		3. JPA
		
		JPA에서 쿼리를 날리는 방식은 3가지
		
		1. Query Method
			- 내가 DB작업을 100% 한다 치면 이건 30~40%
			- 쿼리가 단순하면 무조건 이걸 사용
			- 조인같은거 안하는 단순 쿼리
			- 생산성이 매우 좋지만 한계가 명확함
			- 쿼리가 조금만 복잡해져도 얘로 하면 너무 힘들다
		
		2. JPQL, Java Persistence Query Language
			- 내가 DB작업을 100% 한다 치면 이건 10~20%
			- 이게 많아지면 상황이 안좋다는 것
			- 아주 복잡한 업무
			- 뭐가 간단하고 뭐가 복잡한지는 개발자가 판단하는것
			
		3. Query DSL
			- 내가 DB작업을 100% 한다 치면 이건 30~40%
			- 복잡한 업무 담당
			- 이걸로 하다가도 한계에 다다르면 JPQL로 감
	*/
	@GetMapping("/m1")
	public String m1(Model model) {
		return "add";
	}

	@PostMapping("/m1ok")
	public String m1ok(Model model, ItemDto dto) {

		System.out.println(dto);

		// CRUD 중 C
		// 레코드 추가하기(insert)
		// 새로 추가할 레코드를 엔티티로 생성(중요)

		// ORM
		// 개발자는 자바에서의 객체를 조작하는 행위를 했을 뿐인데
		// 관계형 DB에 그 행위를 적용

		// MyBatis에선 쿼리를 짰었는데 JPA에서는 쿼리를 작성하지 않음

		// DTO -> (변환, 매핑) -> 엔티티

		/*
			1. 브라우저에서 폼을 제출하면 ItemDto로 데이터를 받습니다
			2. ItemDto를 Item 엔티티로 변환합니다
			3. itemRepository.save(item)을 호출합니다
			4. JPA가 자동으로 INSERT 쿼리를 만들어서 DB에 날립니다 
		*/

		// 방법 1
		// 첫번째 인자값은 무조건 seq로 작성 new Item(dto.getSeq(), ...
		// 근데 이 방법(생성자)이 좋긴 한데 이렇게 작성하는게 좀 불편함
		/*
		Item item = new Item(dto.getSeq(), dto.getName(), dto.getPrice(), dto.getColor(), dto.getQty(), dto.getDescription());
		*/

		// 방법 2
		// 빌더 패턴 <- 좀 편함, 위에 한줄이랑 똑같음
		// 가독성이랑 편의성이 좋음
		/*
		Item item = Item.builder()
						.seq(dto.getSeq()) // 이게 Builder가 만든 Setter 임
						.name(dto.getName())
						.price(dto.getPrice())
						.color(dto.getColor())
						.qty(dto.getQty())
						.description(dto.getDescription())
						.build();
		*/

		// 방법 3
		// ItemDto에서 DTO를 엔티티로 바꾼걸 가져옴
		Item item = dto.toEntity();

		itemRepository.save(item); // INSERT / UPDATE

		return "result";
	}

	@GetMapping("/m2")
	public String m2(Model model) {

		// CRUD 중 R
		// DB에서 1개의 레코드를 가져와보자
		// select * from tblItem where seq = 1;
		// 이거 해보자는 말

		// 찾으면 그 아이템을 반환하고
		// 못찾으면 empty를 반환하게
		// Optional 사용
		Optional<Item> item = itemRepository.findById(1L);

		// System.out.println(item);

		if (item.isPresent()) {
			//Entity를 매핑해서 Dto 로 바꾸자
			model.addAttribute("dto", item.get().toDto());
		}

		return "result";
	}

	// CRUD 중 UPDATE
	@GetMapping("/m3")
	public String m3(Model model, @RequestParam("seq") Long seq) {

		// m3?seq='번호' 를 하기 위해
		Optional<Item> item = itemRepository.findById(seq);

		item.ifPresent(value -> model.addAttribute("dto", value.toDto()));

		return "edit";

	}

	// 엔티티를 직접 생성 후 UPDATE를 하는 방법
	/*
	@GetMapping("/m3ok")
	public String m3ok(Model model, ItemDto dto) {
		
		//CR[U]D
		//- 레코드 수정하기
		// 1. 엔티티 직접 생성 > 값을 수정 > 수정하기
		// 2. 검색 > 엔티티 반환 > 값을 수정 > 수정하기
				
		Item item = Item.builder()
						.seq(dto.getSeq())
						.name(dto.getName())
						.price(dto.getPrice())
						.color(dto.getColor())
						.qty(dto.getQty())
						.description(dto.getDescription())
						.build();
		
		// save() 가 호출되면
		// 일단 그 seq(번호)로 select 를 한번 함
		// 그 번호에 해당하는 애를 찾으면 UPDATE 를 함
		// 만약 그 번호에 해당하는 애가 없으면 INSERT 를 함
		// 그래서 itemRepository.save()로 INSERT, UPDATE 둘 다 할 수 있음
		itemRepository.save(item);
		
		return "result";
	}
	*/

	// 엔티티 만드는게 부담스러워서
	// 두번째 방법으로 해보자
	@GetMapping("/m3ok")
	public String m3ok(Model model, ItemDto dto) {

		//CR[U]D
		//- 레코드 수정하기
		// 1. 엔티티 직접 생성 > 값을 수정 > 수정하기
		// 2. 검색 > 엔티티 반환 > 값을 수정 > 수정하기

		Optional<Item> item = itemRepository.findById(dto.getSeq());

		// 실제 엔티티 원본을 꺼냈음
		Item result = item.get();

		// 이 엔티티를 이제 수정(UPDATE) 한 다음
		// DB에 넣으면 좋은데 수정하기 위한 Setter가 없어서
		// Item.java 에서 Setter 역할을 하는 메서드를 만들었다
		// 일종의 안전 장치
		result.update(dto.getName(), dto.getPrice(), dto.getColor(), dto.getQty(), dto.getDescription()); // 꺼내온 원본 엔티티에 수정할 데이터를 반영한다

		// 굳이 왜 이렇게 해야함?
		// JPA를 대하는 개발자의 태도?
		// dto.setName("이름") 이후 발생하는 일들이 다양함
		// DTO 값을 수정하는건 문제가 되거나 안될수도 있는데
		// 엔티티를 함부로 고치고 수정하면 무조건 INSERT 나 UPDATE가 발생함
		// 엔티티를 함부로 수정하면 반드시 DB에 반영되기 때문
		// 함부로 @Setter를 만들어 놓으면 엔티티를 함부로 고칠까봐
		// 평상시에 흔히 쓰는 @Setter를 만들지 않고
		// 내가 엔티티를 고치고 있구나(= 이게 바로 DB에 반영되겠구나) 
		// 자각하라고 
		// Setter 역할을 하는 메서드를 만든것이다

		itemRepository.save(result);

		return "result";
	}

	// CRUD 중 DELETE
	// 엔티티를 직접 생성 후 DELETE를 하는 방법
	/*
	@GetMapping("/m4")
	public String m4(Model model, @RequestParam("seq") Long seq) {
		
		// /m4?seq='번호'
		
		//CUR[D]
		//- 레코드 삭제하기
				
		//1. 엔티티 직접 생성 후 > 삭제
		//2. 엔티티 검색 후 > 삭제
		// 이 번호가 있으리라는 보장이 없이
		// 무조건 삭제해버림
		Item item = Item.builder()
						.seq(seq)
						.build();
		
		itemRepository.delete(item);
		return "result";
	}
	*/

	// 엔티티를 직접 만드는게 아닌
	// 엔티티를 조회해서 가져와서 삭제
	// 좀 더 안정성이 높은 방식
	@GetMapping("/m4")
	public String m4(Model model, @RequestParam("seq") Long seq) {

		//m4?seq=1

		//CUR[D]
		//- 레코드 삭제하기

		//1. 엔티티 직접 생성 후 > 삭제
		//2. 엔티티 검색 후 > 삭제
		/*
		1. findById(seq)로 해당 레코드 먼저 조회
		2. isPresent()로 존재 여부 확인
		2-1. 있으면 delete() → DELETE 쿼리 실행
		2-2. 없으면 아무것도 안 함
		3. result 페이지로 이동 
		*/
		Optional<Item> item = itemRepository.findById(seq);

		if (item.isPresent()) {
			itemRepository.delete(item.get());
		}

		return "result";
	}

	@GetMapping("/m5")
	public String m5(Model model, @RequestParam("seq") Long seq) {

		/*
		
			1. Query Method
			- 정해진 키워드를 사용해 메서드명 생성 후 호출하면,
			메서드명에 따라 정해진 SQL이 실행
			- 패턴: 정해진 행동 키워드 + 컬럼명
		
		*/

		// Optional<Item> item = itemRepository.findById(3L);

		// 내가 Primary Key(지금은 번호)로 찾고싶은게 아니고 
		// 다른걸로 좀 찾아보고 싶음

		// 근데 JPA가 무슨 수로 이름이 이름인걸 알아서
		// 이름으로 찾을 수 있을까?
		// findById 처럼 findByName을 억지로 만든다
		// findBy 도 약속된 예약어이고
		// findBy'엔티티에 있는 메서드 이름' 이렇게
		// 이미 정해져있음

		// 내가 이름으로 특정 데이터를 좀 찾고 싶음
		// Optional<Item> item = itemRepository.findByName("피자");

		// model.addAttribute("dto", item.get().toDto());

		Item item = itemRepository.findByName("피자");

		model.addAttribute("dto", item.toDto());

		return "result";
	}

	@GetMapping("/m6")
	public String m6(Model model) {

		// select count(*) 을 하고 싶음
		Long count = itemRepository.count();

		// seq가 10번인 레코드의 존재 유무를 확인
		Boolean result = itemRepository.existsById(10L);

		model.addAttribute("count", count);
		model.addAttribute("result", result);

		return "result";
	}

	@GetMapping("/m7")
	public String m7(Model model) {

		//전체 레코드 가져오기
		//- select * from tblItem
		List<Item> list = itemRepository.findAll();

		//List<엔티티> >> List<DTO>
		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	@GetMapping("/m8")
	public String m8(Model model) {

		// m5 때 했던 일
		// 이걸 Is, Equals 라고 하는데 생략되었음
		// Is, Equals 를 동등 비교 라고 함
		// Item item = itemRepository.findByName("전기 스쿠터");
		// 이렇게 쓰는게 오리지널임
		// Item item = itemRepository.findByNameIs("전기 스쿠터");
		// findByNameIs 랑 똑같음
		//		Item item = itemRepository.findByNameEquals("전기 스쿠터");

		//		model.addAttribute("dto", item.toDto());

		// 이제 이름이 아니라 color 로 한번 특정 데이터를 찾아보자
		// where color = ?? 를 해보고 싶은 것
		// Item item = itemRepository.findByColor("yellow");
		// model.addAttribute("dto", item.toDto());

		// 근데 이렇게 하면 DB에 color 가 yellow 인게 많은데

		// 반환을 단일 객체(Item)로 받아서 에러남

		// 그래서 Item 으로 받을게 아니라 Item 배열로 받아야 함
		/*
		List<Item> list = itemRepository.findByColor("yellow");
		
		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());
		
		model.addAttribute("dlist", dlist);
		*/

		// 이제 수량으로 찾아보자
		// 수량이 동일한 애가 있을테니
		// 아까 색상으로 찾을때랑 방법은 똑같음
		List<Item> list = itemRepository.findByQty(20);

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	@GetMapping("/m9")
	public String m9(Model model) {
		// First, Top
		// 가져올 레코드의 개수를 지정한다.
		// 결과셋에서 위에서부터 몇개를 가져올건지?

		// Top 의 유래?
		// select * from tblItem where rownum <= 3; 을 하고 싶다(오라클 버전)
		// select * from tblItem limit 0, 3; (MySQL 버전)
		// select top 3 * from tblItem; (MS-SQL 버전)

		// select 한 결과(color 가 yellow)에서 첫번째를 가져오는 findFirstBy
		// Item item = itemRepository.findFirstByColor("yellow");

		// select 한 결과(수량이 20개)에서 첫번째를 가져온다
		// Item item = itemRepository.findFirstByQty("20");
		// First 나 Top이나 똑같은것
		// Item item = itemRepository.findTopByQty("20");

		// model.addAttribute("dto", item.toDto());

		// 이제 가져올 레코드의 개수를 지정해서 가져와보자
		// findTop'가져올 개수'ByColor
		List<Item> list = itemRepository.findTop3ByColor("white");

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	// and 와 or 연산자
	@GetMapping("/m10")
	public String m10(Model model) {

		// Is 또는 Equals는 생략되어있는 것
		// .findByNameIsAndColor()
		//		Item item = itemRepository.findByNameAndColor("키보드", "blue");
		//		model.addAttribute("dto", item.toDto());

		List<Item> list = itemRepository.findByColorOrQtyOrPrice("yellow", 20, 85000);

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	// 우위 비교(크다 작다)
	@GetMapping("/m11")
	public String m11(Model model) {

		// After, Before: 날짜, 시간 비교
		// GreaterThen(GreaterThanEqual), LessThen(LessThanEqual): 숫자 비교
		// Between: 날짜, 시간, 숫자 비교

		// After, GreaterThen(GreaterThanEqual): 크다
		// Before, LessThen(LessThanEqual): 작다

		// List<Item> list = itemRepository.findByPriceGreaterThan(100000);
		// List<Item> list = itemRepository.findByPriceBetween(50000, 100000);
		List<Item> list = itemRepository.findByPriceGreaterThanEqualAndColor(100000, "white");

		// 쿼리 메서드의 단점: 메서드 이름이 점점 길어지고 가독성이 점점 떨어짐

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	// isEmpty, isNull
	// isNotEmpty, isNotNull
	// - isNull -> null 체크 -> where tel is null
	// IsNull → DB에서 NULL인지만 체크
	// - isEmpty -> 빈 문자열, 집합(size: 0) 등을 체크
	// IsEmpty → NULL 또는 빈 문자열('') 둘 다 체크
	// 상황: 수량 중에 null이 있는 상품이 있고,
	// 설명 중에 null 이 있는 상품이 있음
	@GetMapping("/m12")
	public String m12(Model model) {

		// qty, description
		//		List<Item> list = itemRepository.findByQtyIsNull();
		//		List<Item> list = itemRepository.findByQtyIsEmpty();

		// 수량이 NULL 이거나 설명이 NULL 인것 둘중에 하나라도 해당되면 다 가져와
		// List<Item> list = itemRepository.findByQtyIsNullOrDescriptionIsNull();

		//List<Item> list = itemRepository.findByQtyIsNullOrDescriptionIsNull();

		//where (qty is null or desc is null) and price > 100000

		//List<Item> list = itemRepository.findByQtyIsNullOrDescriptionIsNullAndPriceGreaterThan(100000);

		List<Item> list = itemRepository.findByQtyIsNotNull();

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	// In, NotIn
	@GetMapping("/m13")
	public String m13(Model model) {

		// - 열거형 조건
		// - where color in ('black', 'white')
		// - 매개변수 > List 전달

		List<String> colors = List.of("black", "white", "blue"); //읽기 전용 List

		//List<Item> list = itemRepository.findByColorIn(colors);
		List<Item> list = itemRepository.findByColorNotIn(colors);

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	// 패턴 검색
	@GetMapping("/m14")
	public String m14(Model model) {

		// 패턴 검색
		// StartsWith, StartingWith
		// EndsWith, EndingWith
		// Contains
		// Like: 사용자 정의형

		// where name = '스마트폰'
		// where name like '스마트%'
		// where name like ? escape '\'
		// where name like '%기%'

		// where name 을 하고 싶다
		// where name like '???%' 를 하고싶다
		// 실제로 만들어진 쿼리: where i1_0.name like ? escape '\'
		// 오라클 버전에 따라 일부 SQL 구문이 다를 수 있다
		// JPA가 그 오라클 버전이나 DB 종류에 맞게끔 알아서 짜준다

		// DB에서 실제 레코드를 조회해서 가져옴
		// List<Item> list = itemRepository.findByNameStartsWith("스마트");

		// ??? 로 끝나는 데이터를 찾고싶다
		// List<Item> list = itemRepository.findByNameEndsWith("폰");

		// ??? 를 포함하는 데이터를 찾고싶다
		// List<Item> list = itemRepository.findByNameContaining("기");
		List<Item> list = itemRepository.findByDescriptionLike("%기능%");

		// 꺼낸 엔티티를 DTO로 변환
		// DB에서 SELECT해서 꺼낸 진짜 데이터를 DTO로 바꾸는 것
		// 조회(SELECT) 후 뷰에 넘길 때 씀
		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	// 정렬
	@GetMapping("/m15")
	public String m15(Model model) {

		// 정렬을 해보자
		// 정렬도 키워드로 함
		// 쿼리 메서드로 정렬하고 싶을 때 사용하는 키워드
		// - OrderBy컬럼명Asc
		// - OrderBy컬럼명Desc

		// List<Item> list = itemRepository.findAll();
		// List<Item> list = itemRepository.findAllByOrderByNameAsc();
		// List<Item> list = itemRepository.findAllByOrderByNameDesc();

		// All 로 다 가져오는게 아니라 조건으로 일부만 가져와서
		// 정렬해보고 싶다
		// List<Item> list = itemRepository.findByColorOrderByPriceAsc("white");

		// 색상을 알파벳순으로 먼저 정렬하고, 
		// 같은 색상 안에서는 가격이 높은 것 부터 정렬하고 싶다
		List<Item> list = itemRepository.findAllByOrderByColorAscPriceDesc();

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	@GetMapping("/m16")
	public String m16(Model model, @RequestParam("price") Integer price, @RequestParam("order") String order) {

		// 가격이 10만원 이상 > 오름 차순
		// - m16?price=100000&order=asc
		// - m16?price=100000&order=desc

		// List<Item> list = itemRepository.findByPriceGreaterThanEqual(price);

		//		if (order.equals("asc")) {
		//			List<Item> list = itemRepository.findByPriceGreaterThanEqualOrderByPriceAsc(price);
		//		} else if (order.equals("desc")) {
		//			List<Item> list = itemRepository.findByPriceGreaterThanEqualOrderByPriceDesc(price);
		//		}

		Direction orderDirection = Sort.Direction.ASC;

		if (order.equals("desc")) {
			orderDirection = Sort.Direction.DESC;
		}

		// List<Item> list = itemRepository.findByPriceGreaterThan(Sort.by(orderDirection, "price"), price);

		// List<Item> list = itemRepository.findAllByOrderByPriceAsc();

		// ASC
		// List<Item> list = itemRepository.findAll(Sort.by("name"));

		// 내림차순 정렬
		// List<Item> list = itemRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));

		// 다중 정렬
		// List<Item> list = itemRepository.findAll(Sort.by("color", "price"));

		// 내가 원하는 방향으로 다중 정렬
		List<Item> list = itemRepository.findAll(Sort.by(Sort.Order.asc("color"), Sort.Order.desc("price")));

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		model.addAttribute("dlist", dlist);

		return "result";
	}

	// 페이징을 해보자
	// m17하고 m18 따로 만들어야 하는데
	// 수업듣다가 그냥 하나에 해버림
	// 그래서 m17 없음
	@GetMapping("/m18")
	public String m18(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page) {

		// 페이징 구현
		// /m18
		// /m18?page=1
		// /m18?page=2
		// /m18?page=3
		// URL에서 값을 받아오려고 @RequestParam 사용
		// /m18?page=2 이렇게 접속하면 
		// URL의 page=2 를 자바 변수 page에 넣어주는 게 @RequestParam
		page--;

		// 어디서부터 몇개를 가져올 것인가?
		// (0, 20): 첫번째 레코드부터 20번째 레코드까지 갖고 오겠습니다
		// PageRequest.of(페이지 번호, 한 페이지 당 레코드 개수);
		PageRequest pageRequest = PageRequest.of(page, 5);

		// 키워드는 아니고 매개변수로 넣는 방식
		// List 대신 Page(페이징 관련 기능이 추가된 List) 반환
		Page<Item> list = itemRepository.findAll(pageRequest);

		/*
		// 페이지 번호
		System.out.println(list.getNumber());
		// 가져온 엔티티 수
		// 현재 가져온 페이지의 레코드 수
		System.out.println(list.getNumberOfElements());
		// 모든, 총 엔티티 수
		System.out.println(list.getTotalElements());
		// 총 페이지 수(29 / 5 하고 반올림해서 6)
		System.out.println(list.getTotalPages());
		// 한 페이지당 가져오기로 설정한 레코드 수
		System.out.println(list.getSize());
		*/

		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());

		// 페이지 바 구현
		String temp = "";
		for (int i = 1; i <= list.getTotalPages(); i++) {
			temp += """
					<a href="/m18?page=%d">%d</a>
					""".formatted(i, i);
		}

		model.addAttribute("dlist", dlist);
		model.addAttribute("temp", temp);

		return "result";
	}

	//---------- Query Method > 메서드 만드는 수업

	//---------- Query Method > 엔티티 조작 > 조인  

	@GetMapping("/m19")
	public String m19(Model model) {

		// DB 테이블 -> 엔티티 생성
		// 엔티티까진 만들었음, 근데 DB에 있는 테이블 처럼
		// 엔티티끼리도 관계를 맺어줘야함
		
		// User 가져오기
		Optional<User> user = userRepository.findById("hong");
		
		System.out.println(user.get().getName());
		System.out.println(user.get().getPw());
		
		// User.java(엔티티)에 UserInfo도 참조를 해놨으니
		// UserInfo 에 있는 정보도 join을 통해 가져올 수 있다
		System.out.println(user.get().getUserInfo().getAddress());
		
		// UserInfo 가져오기
		UserInfo userInfo = userInfoRepository.findById("hong").get();
		
		System.out.println(userInfo.getAddress());
		System.out.println(userInfo.getGender());
		System.out.println(userInfo.getUser().getName());
		
		// 개발자가 해야 할 일? -> 엔티티 간의 관계를 맺어주고, 알려주면 됨
		// join은 JPA가 알아서 해줌
		
		return "result";
	}
	
	@GetMapping("/m20")
	public String m20(Model model) {
		
		// 1 : N 관계
		// tblUser : tblBoard (실제 DB)
		// User : Board (엔티티)
		
		User user = userRepository.findById("hong").get();
		
		System.out.println(user.getName());
		System.out.println(user.getBoard().size()); // 5
		// 길동이가 글을 5개 썼나보다
		
		// 진짜 5개 썼나?
		user.getBoard().forEach(board -> {
			
			System.out.println(board.getSubject());
		});
		
		return "result";
	}
	
	@GetMapping("/m21")
	public String m21(Model model) {
		
		// 1 : N 관계
		// tblUser : tblBoard (실제 DB)
		// User : Board (엔티티)
		
		Board board = boardRepository.findById(1L).get();
        
        System.out.println(board.getSubject());
        System.out.println(board.getContent());
		
		return "result";
	}
	
	@GetMapping("/m22")
	public String m22(Model model) {
		
		// N : N 관계
		// 정규화를 통해
		// 1 : N N : 1
		// tblTag:tblTagging - tblTagging:tblBoard (실제 DB)
		// Tag:Tagging - Tagging:Board (엔티티)
		
		// Board 가져오기
		Board board = boardRepository.findById(10L).get();
		
		System.out.println(board.getSubject());
		System.out.println(board.getTagging().size());
		System.out.println(board.getTagging().get(0).getTag().getTag());
		System.out.println(board.getTagging().get(1).getTag().getTag());
		
		return "result";
	}
	
	// 가져온 게시물을 페이지에 출력해보자
	@GetMapping("/m23")
	public String m23(Model model) {
		
		// 엔티티 관계가 중요
		List<Board> list = boardRepository.findAll();
		
		model.addAttribute("blist", list);
		
		return "result";
	}
	
	// JQPL, Native Query 수업
	@GetMapping("/m24")
	public String m24(Model model) {
		
		/*
		
	 	JPQL, Java Persistence Query Language
	 	- JPA에서 질의에 사용하는 전용 질의문(JPA 전용 SQL)
	 	- SQL과 유사
	 	
	 	SQL:  테이블을 대상으로 질의
	 	JPQL: 엔티티를 대상으로 질의
	 
		 */
	
		// Query Method 가 아닌
		// 내가 직접 구현하는 메서드
		
		// List<Item> list = itemRepository.m24();
		List<Item> list = itemRepository.m24_1();
		
		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());
		
		model.addAttribute("dlist", dlist);
		
		return "result";
	}
	
	// 숫자 하나 밀렸는데
	// 그냥 편의상 m26으로 작성했음
	@GetMapping("/m26")
	public String m26(Model model, @RequestParam(name="color", defaultValue = "black") String color) {
		
		// /m26 <- 기본이 black인걸로 처리해보자
		// /m26?color=white
		
		List<Item> list = itemRepository.m26(color);
		
		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());
		
		model.addAttribute("dlist", dlist);
		
		return "result";
	}
	
	// DTO(다중값) 넘기기?
	@GetMapping("/m27")
	public String m27(Model model, ItemDto dto) {

		// /m27?color=white&price=100000

		// dto(color=white, price=100000)
		List<Item> list = itemRepository.m27(dto);
		
		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());
		
		model.addAttribute("dlist", dlist);
		
		return "result";
	}
	
	// Query DSL 수업
	@GetMapping("/m28")
	public String m28(Model model) {
		
		// JPQL 작성을 도와주는 동적 쿼리
		// JPQL을 자바의 메서드를 사용해서 생성해줌
		// 장점: 안정성 높아짐, 컴파일 시 오류를 발견할 수 있음
		// 가독성 높음
		// 엔티티 조작을 도와주는 QClass가 필요함
		
		// select * from tblItem 을 하고 싶다
		List<Item> list = itemQueryDSLRepository.m26();
		
		List<ItemDto> dlist = list.stream().map(item -> item.toDto()).collect(Collectors.toList());
		
		model.addAttribute("dlist", dlist);
		
		return "result";
	}
	
	@GetMapping("/m29")
	public String m29(Model model) {
		
		// /m29?name=태블릿
		
		// 항목 하나를 찾아 레코드 한개를 반환하는 작업을 해보자
		Item item = itemQueryDSLRepository.m29("마우스");
		
		// 엔티티를 DTO로 바꾼다
		model.addAttribute("dto", item.toDto());
		
		return "result";
	}
	
	@GetMapping("/m30")
	public String m30(Model model) {
		
		// 상품 이름만 좀 가져오고 싶음, 즉 컬럼 1개
		
		List<String> names = itemQueryDSLRepository.m30();
		
		model.addAttribute("names", names);
		
		// 일부 컬럼만 가져오는게 Query Method로는 안되고
		// JPQL 로는 되니까 Query DSL 로도 됨
		
		
		return "result";
	}
	
	@GetMapping("/m31")
	public String m31(Model model) {
		
		// 다중 컬럼
		// 1. 모든 컬럼을 받을거면 -> List<DTO> 사용
		// 2. 1개의 컬럼만 받을거면 -> List<String>
		// 3. 2~5개 처럼 어정쩡한 개수의 컬럼만 받을거면?
		// Tuple 이 뭘까? 배열 같은 것
		List<Tuple> list = itemQueryDSLRepository.m31();
		
		model.addAttribute("tlist", list);
		
		return "result";
	}
	
	@GetMapping("/m32")
	public String m32(Model model) {
		
		// 일부 컬럼만 가져오고 싶다
		// 근데 엔티티를 쓰긴 싫다
		// 그래서 Tuple을 쓴다
		// 근데 DTO도 쓸 수 있다?
		// 여지껏 DTO를 많이 썼기 때문에
		// 친숙하긴 한데 난이도는 있는 편
		
		// 일부 컬럼 조회 할 때
		// 1. 엔티티 -> 편함, 무조건 모든 컬럼 가져옴
		// 단점은 사용하지 않는 값까지 다 가져옴
		
		// 2. Tuple -> 조금 편함, 컬럼 인덱스(0, 1, 2 ...)로
		// 접근해야해서 가독성 떨어짐 0, 1, 2 가 뭔데?
		
		// 3. DTO -> 불편함, 프로퍼티(컬럼명)로 접근해서 가독성 좋음
		
		return "result";
		
	}

}
