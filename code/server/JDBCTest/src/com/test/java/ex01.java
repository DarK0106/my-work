package com.test.java;

public class ex01 {
	
	public static void main(String[] args) {
		// 자바가 오라클을 조작하는 방법
		/*
		 	JDBC, Java Database Connectivity
		 	Java와 DB를 연결시키는 기술
		 	- 역할: 영속성 계층(Parsistence Layer)
		 	- 위치: 중간 계층
		 	
		 	1. JDBC
		 	
		 	2. Spring JDBC
		 	2. MyBatis(Spring 에서 많이 사용)
		 	2. JPA(Spring 에서 많이 사용)
		 	
		 	JDBC Driver 설치(표현만 이럼)
		 	- 관련 클래스 가져오기 -> .jar 참조
		 	- 어떤 DB를 사용하는가에 따라 드라이버가 달라짐
		 	C:\app\hyz01\product\21c\dbhomeXE\jdbc\lib
		 	ojdbc11.jar
		 	
		 	사람인 우리가 sqldeveloper라는 프로그램을 사용해서(클라이언트)
		 	SQL이라는 언어를 써서
		 	oracle 데이터베이스 서버랑 대화를 했다
		 	
		 	1. 클라이언트 툴 실행
		 	2. DB 접속
		 		- 호스트명: localhost
		 		- 포트번호: 1521
		 		- SID: xe
		 		- 드라이버: thin
		 		- 사용자명: hr
		 		- 암호: java1234
		 		
		 	3. 질의
		 		- SQL 사용(DDL, DNL, DCL..)
		 		3.1 반환값이 없는 쿼리
		 			- select 문을 제외한 쿼리
		 		
		 		3.2 반환값이 있는 쿼리
		 			- select 문
		 			- 결과셋을 반환하는 쿼리
		 			- 결과셋을 업무에 사용
		 			
		 	4. 접속 종료
		 		- commit/rollback
		 	
		 	이제는 자바 프로그램이 오라클과 대화를 하려는것
		 	SQL 언어를 씀
		 	자바도 오라클에 바로 접속은 못함
		 	JDBC라는 도구를 사용해야함
		 	
		 	1. 자바 프로그램 실행(+JDBC)
		 	
		 	2. DB 접속
		 		- JDBC 안의 Connection 클래스 사용
		 		- 호스트명: localhost
		 		- 포트번호: 1521
		 		- SID: xe
		 		- 드라이버: thin
		 		- 사용자명: hr
		 		- 암호: java1234
		 		
		 	3. 질의
		 		- JDBC 안의 Statement 클래스 사용
		 		- SQL 사용(DDL, DNL, DCL..)
		 		3.1 반환값이 없는 쿼리
		 			- select 문을 제외한 쿼리
		 			- void Statement.excuteUpdate("insert")
		 			
		 		3.2 반환값이 있는 쿼리
		 			- select 문
		 			- 결과셋을 반환하는 쿼리
		 			- 결과셋을 업무에 사용
		 			- ResultSet Statement.excuteQuery("SQL")
		 			- JDBC의 ResultSet 클래스 == select의 결과셋
		 			
		 		4. 접속 종료
		 			- JDBC 안의 Connection 클래스 사용
		 			- commit/rollback
		 			
		 		JDBC 라이브러리 클래스(ojdbc11.jar)
		 		- Connection, Statement, ResultSet
		 			
		*/
	}
}
