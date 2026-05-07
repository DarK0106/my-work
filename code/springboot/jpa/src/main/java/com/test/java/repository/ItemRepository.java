package com.test.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.Item;

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

	List<Item> findByPriceBetween(int i, int j);

	List<Item> findByPriceGreaterThanEqualAndColor(int i, String string);

	List<Item> findByQtyIsNull();

	List<Item> findByQtyIsNullOrDescriptionIsNull();

	List<Item> findByQtyIsNotNull();

	List<Item> findByColorNotIn(List<String> colors);
	
//	List<Item> findByQtyIsEmpty();


}
