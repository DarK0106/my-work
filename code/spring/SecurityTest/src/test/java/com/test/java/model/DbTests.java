package com.test.java.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class DbTests {
	
	@Autowired
	private DataSource source; // DBCP
	
	@Autowired
	private SqlSessionTemplate template; // MyBatis
	
	@Test
	public void test() {
		
		assertNotNull(source);
		
		try {
			Connection conn = source.getConnection();
			System.out.println(conn.isClosed()); // false
			assertEquals(false, conn.isClosed());
		} catch (SQLException e) {
			System.out.println("DbTests.test");
			e.printStackTrace();
		}

		
	}
	
	@Test
	public void testMyBatis() {
		
		assertNotNull(template);
		
		int count = template.selectOne("security.test");
		System.out.println(count);
		
	}
}
