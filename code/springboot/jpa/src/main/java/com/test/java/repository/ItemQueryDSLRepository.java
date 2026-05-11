package com.test.java.repository;

import static com.test.java.entity.QItem.item;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.java.entity.Item;
import com.test.java.entity.QItem;
import com.test.java.model.ItemDto;

import lombok.RequiredArgsConstructor;

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


		public List<ItemDto> m32() {
		// select 한 결과를 DTO 로 매핑하는게 목적
		// 처음엔 셀렉트결과가 무조건 엔티티로 반환되기 때문에
		// 우리가 직접 엔티티를 DTO로 매핑해야함
		// DTO 생성자가 필요한데 Setter 를 못 씀
		// 내가 가져오고 싶은 컬럼만 매개변수로 갖는 생성자가 필요함
		// 애초에 특정 컬럼만 갖고 오는게 목적이기 때문
			return factory.select(Projections.constructor(ItemDto.class, item.name, item.color, item.qty))
					  	  .from(item)
					  	  .fetch();
	}


		public List<Item> m33(ItemDto dto) {
		
		/*
		
			where()
			
			- 동등 비교
				- where(item.color.eq("white"))
			
			- 범위 비교(숫자, 날짜)
				- where(item.price.gt(100000))
			
			- 열거형(in)
				- where(item.color.in("red", "yellow", "blue"))
			
			- 패턴 문자열
			
			- 논리 연산
				- and()
				- or()
				- not()
		
		*/
		
			return factory
					.selectFrom(item)
					// 동등 비교
	//				.where(item.color.eq("white"))
	//				.where(item.color.ne("white"))
	//				.where(item.description.isNull())
	//				.where(item.description.isNotNull())
					// 범위 비교
	//				.where(item.price.gt(110000))
	//				.where(item.price.goe(110000))
	//				.where(item.price.lt(110000))
	//				.where(item.price.loe(110000))
	//				.where(item.price.between(50000, 100000))
					// 열거형
	//				.where(item.color.in("red", "yellow", "blue"))
	//				.where(item.color.notIn("red", "yellow", "blue"))
					// 패턴 문자열
	//				.where(item.description.startsWith("최신"))
	//				.where(item.description.endsWith("입니다"))
	//				.where(item.description.contains("스마트"))
	//				.where(item.description.like("%스마트%"))
					// 논리 연산
					.where(item.color.eq("white").and(item.price.gt(100000).and(item.qty.isNotNull())))
					.fetch();
	}


		public List<Item> m34() {
			
			/*
				
				정렬
				- orderBy(정렬기준)
				
				정렬기준
				- 엔티티.컬럼.기준()
					- asc()
					- desc()
					- nullsFirst()
					- nullsLast()
			
			*/
			return factory
					.selectFrom(item)
//					.orderBy(item.color.asc())
//					.orderBy(item.color.asc()
//							, item.price.desc()
//							, item.qty.asc())
					// NULL 들어간걸 맨앞으로 보낼지
					// 아니면 맨 뒤로 뺄지
//					.orderBy(item.qty.desc().nullsFirst())
//					.orderBy(item.qty.desc().nullsLast())
					// 오름차순은 NULL 이 맨 끝으로 감
					.orderBy(item.qty.asc().nullsFirst())
					.fetch();
		}


		public List<Item> m35(int offset, int limit) {
			return factory
					.selectFrom(item)
					.offset(offset)
					.limit(limit)
					.fetch();
		}


		public Tuple m36() {

			// - count(), sum(), avg(), max(), min()
			
			// select count(*) from tblItem 을 하고 싶다
			return factory
//					.select(item.count())
//					.select(item.qty.count())
//					.select(item.qty.sum())
//					.select(item.qty.avg())
//					.select(item.qty.max())
//					.select(item.qty.min())
					.select(item.count(), item.qty.count(), item.qty.sum())
					.from(item)
					.fetchOne();
			
		}

		
		public List<Tuple> m37() {
			
			return factory
					.select(item.color, item.count(), item.price.avg())
					.from(item)
					.groupBy(item.color)
					.having(item.count().gt(5))
					.fetch();
		}

		// select * from tblItem where price >= (평균가격); 를 하고 싶음
		public List<Item> m38() {

			// 여지껏 우리가 item 이라고 작성하면 tblItem 에 대한 엔티티였는데
			// 서브쿼리용으로 item2 엔티티를 하나 더 만들어야함
			// 근데 item을 우리가 만든게 아니고 QClass에 알아서 만들어져있었음
			// QClass 가서 하나 더 만들면 됨
			
			QItem item2 = QItem.item;
			
			return factory
					.selectFrom(item)
					.where(item.price.goe(
							JPAExpressions.select(item2.price.avg()).from(item2)
					))
					.fetch();
		}

		
		public List<Tuple> m39() {
			
			// select name, price, color, (select avg(price) from tblItem b where a.color = b.color) from tblItem a; 를 하고 싶음
			
			// QItem item2 = QItem.item;
			QItem item2 = new QItem("item2");
			
			return factory
						.select(
							item.name, item.price, item.color,
							JPAExpressions
								.select(item2.price.avg())
								.from(item2)
								.where(item2.color.eq(item.color))
						)
						.from(item)
						.fetch();
		
		}


	
}
