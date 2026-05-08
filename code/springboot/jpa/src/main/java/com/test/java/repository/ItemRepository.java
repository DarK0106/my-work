package com.test.java.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.java.entity.Item;
import com.test.java.model.ItemDto;

// 이 리포지토리의 역할은
// 엔티티를 조작하는 역할임
// 보통 이름을 '엔티티명'Repository
// 라고 작성함
// 다른 인터페이스를 상속받아야함
// extends JpaRepository<엔티티명, 이 엔티티의 Primary Key 자료형>
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	// 특정 데이터를 이름으로 좀 찾고싶어서 만듦
	// Optional<Item> findByName(String name);
	
	Item findByName(String name);

	Item findByNameIs(String name);

	Item findByNameEquals(String name);

	List<Item> findByColor(String color);

	List<Item> findByQty(int i);

	Item findFirstByColor(String string);

	Item findFirstByQty(int i);

	Item findTopByQty(int i);

	List<Item> findTop3ByColor(String string);

	Item findByNameAndColor(String string, String string2);

	List<Item> findByColorOrQtyOrPrice(String string, int i, int j);

	List<Item> findByPriceGreaterThan(int i);

	List<Item> findByPriceGreaterThan(Sort sort, int i);

	List<Item> findByPriceBetween(int i, int j);

	List<Item> findByPriceGreaterThanEqualAndColor(int i, String string);

	List<Item> findByQtyIsNull();

	List<Item> findByQtyIsNullOrDescriptionIsNull();

	List<Item> findByQtyIsNotNull();

	List<Item> findByColorNotIn(List<String> colors);

	List<Item> findByNameStartsWith(String string);

	List<Item> findByNameEndsWith(String string);

	List<Item> findByNameContaining(String string);

	List<Item> findByDescriptionLike(String string);

	List<Item> findAllByOrderByNameAsc();

	List<Item> findAllByOrderByNameDesc();

	List<Item> findByColorOrderByPriceAsc(String string);

	List<Item> findAllByOrderByColorAscPriceDesc();

	List<Item> findAllByOrderByPriceAsc();
	
	// JPQL, 내가 직접 구현하는 메서드
	// select * from tblItem; 을 하고 싶다
	// @Query 어노테이션을 사용해야함
	// m24가 뭔지를 JPA에게 알려준다는 것
	// "select m from Item(엔티티 이름) m"
	@Query(value = "select m from Item m")
	List<Item> m24();
	
	// Native Query
	// 최후의 수단
	@Query(value = "select * from tblItem", nativeQuery = true)
	List<Item> m24_1();
	
	
	@Query(value = "select m from Item m where m.color = :color")
	List<Item> m26(@Param(value = "color") String color);
	
	@Query(value = "select m from Item m where m.color = :#{#dto.color} and m.price >= :#{#dto.price}")
	List<Item> m27(@Param(value="dto") ItemDto dto);
	
	// String color 의 color 값을 :color의 color에 넣어줘야함
	// @Param(value = "color") 사용
	

	
//	List<Item> findByQtyIsEmpty();


}
