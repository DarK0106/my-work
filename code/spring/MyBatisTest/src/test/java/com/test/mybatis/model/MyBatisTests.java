package com.test.mybatis.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

// JUnit + Spring
// - JUnit4: 생성자 주입 테스트 불가능 -> 필드 주입으로 대체
// 스프링 부트에선 JUnit5 쓸 예정: 생성자 주입 테스트 가능
// new -> JUnit Test Case
// 루트 컨텍스트에 작성해놨던 빈들이 제대로 동작하는지 테스트하는 것
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTests {

	// JUnit이 dataSource를 알아서 만들어서 설정을 넣어준다?
	@Autowired
	private HikariDataSource dataSource;

	// JUnit 실행 방법(= 테스트 방법)
	// 1. Ctrl + F11
	// - 파일 내의 모든 @Test 메서드 실행

	// 2. @Ignore
	// - 일부 테스트 무시

	// 3. 메서드 헤더 -> run as -> JUnit test
	// - 원하는 특정 테스트 실행

	// hikaridatasource를 내가 만든게 아니기 때문에 어노테이션이 아닌 xml으로
	// 빈을 만들어서 가져오는것(남이 만든걸 가져오는것이기때문)

	// 히카리CP 제대로 세팅됐는지 궁금해서 일부 기능(datasource)이 동작이 되는건지
	// 테스트를 하려는것

	// @Test를 붙이면 JUnit이 검증을 해야 될 테스트 메서드가 됨
	@Test
	public void test() {
		System.out.println("테스트 메서드");
	}

	@Test
	public void test2() {
		System.out.println("테스트 메서드2");
	}

	@Ignore
	@Test
	public void test3() {
		fail("테스트 실패");
	}

	@Test
	public void testCreateDataSource() {
		// 일단 dataSource가 생겼으면 not null 일테니까
		// 권장하지 않는 방법
		// System.out.println(dataSource != null);

		// 평가 메서드를 사용(권장되는 방법)
		assertNotNull(dataSource);
	}

	// 소스를 만들었으면 연결이 생성되었는지 테스트
	@Test
	public void testCreateConnection() {

		Connection conn = null;

		try {

			conn = dataSource.getConnection();

		} catch (Exception e) {
			System.out.println("MyBatisTests.testCreateConnection");
			e.printStackTrace();
		}

		assertNotNull(conn);

	}

	// 정상적으로 연결이 되었는지 테스트
	@Test
	public void testIsConnection() {

		Connection conn = null;

		try {

			conn = dataSource.getConnection();

			// false면 테스트 통과, true면 테스트 실패
			assertFalse(conn.isClosed());

		} catch (Exception e) {
			System.out.println("MyBatisTests.testCreateConnection");
			e.printStackTrace();
		}

	}
	
	// 새로운 객체를 의존주입하라고 시킴
	@Autowired
	private SqlSessionTemplate template;
	
	@Test
	// 이름만 보고 무슨 테스트인지 알 수 있게 메서드를 만들어야함
	// MyBatis가 제대로 동작하는지 2단계에 걸쳐서 테스트
	public void testCreateSqlSessionTemplate() {
		assertNotNull(template);
	}
	
	@Test
	public void testExecuteQuery( ) {
		// stat.excuteQuery("select 문 ..") 이거 실행하려는 것
//		template.insert(null)
//		template.update(null)
//		template.delete(null)
//		template.select(null);
		
		String time = template.selectOne("address.time");
		
		assertNotNull(time);
		System.out.println("시간: " + time);
	}
}
