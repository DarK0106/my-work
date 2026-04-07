package com.test.mybatis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import oracle.net.jdbc.TNSAddress.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class MyBatisDaoTests {
	// DAO를 테스트해보자
	// 필드 주입으로 의존 주입
	@Autowired
	private MyBatisDao dao;

	@Test
	public void testCreateDao() {
		assertNotNull(dao);
	}

	@Test
	public void testM2() {
		int result = dao.m2("1");

		assertEquals(1, result);
	}

	@Test
	public void testM3() {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("seq", "1");
		map.put("name", "홍길순");
		map.put("age", "30");
		map.put("address", "부산시");
		map.put("gender", "f");

		int result = dao.m3(map);

		assertEquals(1, result);
	}
	
	@Test
	public void testM4() {
		AddressDto dto = new AddressDto();
		dto.setSeq("1");
		dto.setName("근준식");
		dto.setAge("43");
		dto.setAddress("하와이");
		dto.setGender("f");
		
		int result = dao.m4(dto);
		assertEquals(1, result);
	}
	
	@Test
	public void testM5() {
		String name = dao.m5("1");
		assertEquals("근준식", name);
	}
	
	@Test
	public void testM6() {
		AddressDto dto = dao.m6("1");
		assertNotNull(dto);
		
		assertEquals("근준식", dto.getName());
		
		System.out.println(dto);
	}
	
	@Test
	public void testM7() {
		List<String> list = dao.m7();
		
		assertEquals(6, list.size());
		
		System.out.println(list);
	}
	
	@Test
	public void testM8() {
		List<AddressDto> list = dao.m8();
		
		assertEquals(6, list.size());
		
		System.out.println(list);
	}
	
	@Test
	public void testM10() {
		// 나이가 10살 이상인 애들만 찾으라고 테스트
		List<AddressDto> list = dao.m10(10);
		
		// 결과 레코드의 개수가 3개면 테스트 성공
		assertEquals(3, list.size());
	}
	
	@Test
	public void testM11() {
		List<AddressDto> list = dao.m11("강동");
		
		assertEquals(3, list.size());
	}
	
	@Test
	public void testM12() {
		List<AddressDto> list = dao.m12("f");
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testM13() {
		
		AddressDto dto = new AddressDto();
		dto.setAge("20");
		dto.setGender("m");
		dto.setAddress("강남");
		
		List<AddressDto> list = dao.m13(dto);
		
//		assertEquals(2, list.size());
		System.out.println(list);
	}
	
	@Test
	public void testM14() {
		
		List<String> buseo = Arrays.asList("영업부", "총무부", "개발부");
		
		List<InsaDto> list = dao.m14(buseo);
		
		System.out.println(list);
		
	}
	
	@Test
	public void testM16() {
		List<AddressPointDto> list = dao.m16();
		
		System.out.println(list);
	}
}
