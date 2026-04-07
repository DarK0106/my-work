package com.test.mybatis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyBatisDao {

	// SqlSessionTemplate 를 의존 주입 받기
	// root-context.xml에 있는
	// 팩토리빈(MyBatis 설정 주석) -> 데이터소스 -> HikariCP 이렇게 역으로
	// 팩토리빈 먼저 생성되면서 올라감
	private final SqlSessionTemplate template;

	// 우리가 날리는 모든 쿼리는 DAO가 담당
	// 실제 SQL 구문은 XML Mapper에 작성될 예정
	// JDBC에서 반환값이 없는 쿼리인 int stat.executeUpdate()를 날렸었는데
	// MyBatis에선 다음과 같이 쓴다
	// int.template.insert()
	// int.template.update()
	// int.template.delete()

	// JDBC에서 반환값이 있는 쿼리인 ResultSet stat.executeUpdate()를 날렸었는데
	// MyBatis에선 다음과 같이 쓴다
	// template.selectOne() -> 결과셋의 레코드가 1개가 확실하면 사용
	// template.selectList() -> 결과셋의 레코드가 N개가 확실할때 사용

	public int m1() {
		// insert 문

		// JDBC에서 할 때
		// 1. Connection open
		// 2. SQL
		// 3. Statement
		// 4. executeUpdate()

		return template.insert("address.m1");
	}

	// 단위 테스트
	public int m2(String seq) {
		// update 문
		return template.update("address.m2", seq);
	}

	public int m3(HashMap<String, String> map) {
		// update 문
		return template.update("address.m3", map);
	}

	// DTO 넘기기
	// Array-list 넘기기?
	public int m4(AddressDto dto) {
		return template.update("address.m4", dto);
	}

	public String m5(String seq) {

		// JDBC에서 할 때
		// 1. Connection
		// 2. SQL
		// 3. PreparedStatement
		// 4. ? 1 -> seq
		// 5. executeQuery()
		// 6. ResultSet
		// 7. if (rs.next())
		// 8. rs.getString("name");
		// 9. return
		// 이걸 MyBatis로 하러 온 것

		// 이 사람의 이름을 받고 싶어서 온 것이니
		// 문자열을 리턴값으로 받아야하는데
		// MyBatis는 쿼리만 짜주면 알아서
		// 자바 타입(여기선 문자열)으로 변환시켜줌
		// 이게 매핑임
		// MyBatis의 강점은 리턴값 매핑이다
		return template.selectOne("address.m5", seq);
	}

	// 행은 하나이고 반환값은 여러개를 돌려받을 때
	// DTO를 돌려주도록 내부가 설계되어있다
	public AddressDto m6(String seq) {
		// 레코드는 하나이므로 selectOne 사용
		return template.selectOne("address.m6", seq);
	}

	public List<String> m7() {

		// JDBC로 할 때
		// 1. Connection
		// 2. SQL
		// 3. Statement
		// 4. executeQuery()
		// 5. ResultSet
		// 6. List<String> names
		// 7. while (rs.next()) {}
		// 8. rs.getString("name")
		// 9. names.add(name)
		// 10. return names

		return template.selectList("address.m7");
	}

	public List<AddressDto> m8() {

		// JDBC로 할 때
		// 1. Connection
		// 2. SQL
		// 3. Statement
		// 4. executeQuery()
		// 5. ResultSet
		// 6. List<dto> names
		// 7. while (rs.next()) {}
		// 8. rs.getString("name")
		// 9. names.add(name)
		// 10. return names

		return template.selectList("address.m8");
	}

	public List<AddressDto> m9(Map<String, String> map) {
		return template.selectList("address.m9", map);
	}

	// 인자값으로 나이를 받음: m10(int age)
	public List<AddressDto> m10(int age) {
		// 우위 비교(크냐? 같냐?)
		return template.selectList("address.m10", age);
	}

	public List<AddressDto> m11(String word) {
		// Like 검색
		// .. where address like '%강남%'
		return template.selectList("address.m11", word);
	}

	// 매개변수가 성별
	public List<AddressDto> m12(String gender) {

		// m12.do?gender=m
		// m12.do?gender=f
		// m12.do?gender=all
		return template.selectList("address.m12", gender);
	}

	public List<AddressDto> m13(AddressDto dto) {

		// m13.do?age=20
		// m13.do?age=20&gender=m
		// m13.do?gender=m
		// m13.do?address=강동

		// where age = 20
		// where gender = 'f'
		// where address like '%강동%'
		// where age = 20 and gender = 'f'
		// where age = 20 and address like '%강남%'
		// where age = 20 and gender = 'f' and address like '%강남%'
		return template.selectList("address.m13", dto);
	}

	public List<InsaDto> m14(List<String> buseo) {

		// mybatis.query("id", 매개변수)
		// - 단일값
		// - Map
		// - Dto
		// - List

		// - where bueso = '영업부' or buseo = '총무부' or buseo = '개발부'
		// - where buseo in ('영업부', '총무부', '개발부')

		return template.selectList("address.m14", buseo);
	}

	public void add(AddressDto dto) {
		template.insert("address.add", dto);
	}

	public void addPoint() {

		template.insert("address.addPoint");
	}
	
	public List<AddressPointDto> m16() {
		// 조인해보기
		// tblAddress + tblPoint
		return template.selectList("address.m16");
	}

	public List<AddressDto> m17() {

		return template.selectList("address.m17");
	}

	public List<InsaDto> m18() {
		
		return template.selectList("address.m18");
	}
}
