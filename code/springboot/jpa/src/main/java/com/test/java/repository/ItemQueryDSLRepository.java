package com.test.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.java.entity.Item;

import lombok.RequiredArgsConstructor;

import static com.test.java.entity.QItem.item;

@Repository
@RequiredArgsConstructor
public class ItemQueryDSLRepository {
	
	private final JPAQueryFactory factory; //statement 역할

	public List<Item> m26() {
		
		// QClass 쿼리 작성
		// - selectFrom(QClass): 해당 엔티티에서 모든 컬럼/레코드를 가져온다
		// 셀렉트를 날렸으니 결과셋을 가지고 매핑을 해서 결과를 가져와야함
		// - fetch(): 리스트 조회(다중 행 가져오기), List<엔티티>,
		// 만약 결과가 없다면 빈 리스트 반환
		// - fetchOne()
		// - fetchFirst()
		// - fetchResults()
		// - fetchCount()
		
		// select m from Item(엔티티) m 를 하기 위해
		List<Item> list = factory
							.selectFrom(item) //SQL(JPQL) 생성 + ResultSet 생성
							.fetch(); //selectList() + Mapping
		
		return list;
	}
	
	
	// Query DSL로 where 절은 어떻게 하는지
	// 레코드를 하나만 반환받고 싶으면 어떻게 하는지
	public Item m29(String name) {
		
		// 테이블이 필요하면 엔티티에 해당하는 QClass(여기선 item)를 사용
		// 컬럼이 필요하면 엔티티.필드 즉 QClass.컬럼(여기선 item.name) 으로 사용
		
		// 커서를 한칸만 전진시켜서 레코드를 한개만 갖고오는게
		// fetchOne()
		// 그래서 자연스럽게 엔티티를 반환한다?
		
		// 그래서 Query DSL 이 JPQL에 비해서 뭐가 좋은거임?
		// JPQL은 쿼리문을 작성할 때 
		// @Query(value = "select m from Item m where m.color = :color")
		// 이렇게 쓰는데
		// value = ... <- 여기서 오타나도 바로 에러가 안 나고
		// 사이트를 이용하는 고객이 저 쿼리문을 호출할 일이 생길때
		// 런타임 오류로 발생해서 개발한 사람이 매우 곤란해짐
		// 하지만 Query DSL에서 오타나면? 바로 에러남
		// 그래서 개발자가 아 내가 잘못 쳤구나 이걸 바로 알 수 있어서
		// 안정성이 좋음
		// Query DSL 에서 +-*/= 이런 연산자 안 쓰고 
		// 이런 연산자 비교연산자 이런게 다 메서드로 되어있음
		return factory
					.selectFrom(item)
					.where(item.name.eq(name)) // where name = ?
					// fetchOne 썼는데 해당하는 값이 두개 이상이면
					// 에러나니까 사용할 때 반드시 하나인거 확인하고
					// 사용해야함
					.fetchOne()
					;
		
	}

	public List<String> m30() {

		// 모든 컬럼: select * from -> selectFrom()
		// 특정 컬럼: select name from -> select() + from()
		
		return factory
					.select(item.name)  // select name // .select(엔티티.컬럼명)
					.from(item) 		// from tblItem
					.fetch()			// 매핑
					;
	}

	
	// 몇개의 컬럼만 가져오고 싶음
	// Tuple 은 동적으로 만들어진 배열이라고 생각하자
	public List<Tuple> m31() {
		
		
		// [피자, black, 102] 이렇게 출력되는데 이게 Tuple
		return factory
					.select(item.name, item.color, item.qty)
					.from(item)
					.fetch()
					;
	
	}
}
