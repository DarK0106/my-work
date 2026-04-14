package com.test.java.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class AddMember {
	
	// 의존 주입을 하려는데 임시로 만든 패스워드 인코더를 써야하는지
	// 방금 만든 blowfish 알고리즘 쓰는 패스워드 인코더를 써야하는지
	// 판단이 안 되서 에러 발생
	// 부모 인터페이스에 집어넣을 수 있는 자식이 하나인데
	// 두개라서 에러 발생
	// 방법 1. 임시로 만든 패스워드 인코더를 삭제한다
	// 방법 2. @Qualifier라는 어노테이션을 사용
	// 하나를 콕 집어서 사용하니 헷갈릴 일이 없음
	
	// 되도록이면 1번 방법을 권장함
	
	@Autowired
	@Qualifier("bCryptPasswordEncoder")
	private PasswordEncoder encoder;
	
	// 쿼리를 날리기 위해 sqlsessiontemplate도 의존 주입
	@Autowired
	private SqlSessionTemplate template;

	@Test
	public void testEncoder() {

		assertNotNull(encoder);
		
		// 드디어 내 손에 패스워드 인코더가 주어짐
		// 사용자가 입력한 비밀번호 1111을 그대로 DB에 넣으면 안되고
		// 인코더를 한 번 거쳐서 암호화를 하고 DB에 넣어야 함
		String pw = "1111";
		System.out.println(encoder.encode(pw));
		
		// $2a$10$fy/Wdr.DetAA4qLliv.ftOx1hDQ8GajEZWpG8hice5QtIPUqV7hcK
		// 이게 암호화된 1111임

	}
	
	@Test
	public void add() {
		// 회원을 추가해보기
		MemberDto dto = new MemberDto();
		
		dto.setMemberid("dog");
		dto.setMemberpw(encoder.encode("1111"));
		dto.setMembername("강아지");
		dto.setEmail("dog@gamil.com");
		dto.setGender("m");
		
		assertEquals(1, template.insert("security.add", dto));
	}
	
	@Test
	public void add2() {
		// 회원을 추가해보기
		MemberDto dto = new MemberDto();
		
		dto.setMemberid("cat");
		dto.setMemberpw(encoder.encode("1111"));
		dto.setMembername("고양이");
		dto.setEmail("cat@gamil.com");
		dto.setGender("f");
		
		assertEquals(1, template.insert("security.add", dto));
	}
	
	@Test
	public void add3() {
		// 회원을 추가해보기
		MemberDto dto = new MemberDto();
		
		dto.setMemberid("tiger");
		dto.setMemberpw(encoder.encode("1111"));
		dto.setMembername("호랑이");
		dto.setEmail("tiger@gamil.com");
		dto.setGender("m");
		
		assertEquals(1, template.insert("security.add", dto));
	}

}
