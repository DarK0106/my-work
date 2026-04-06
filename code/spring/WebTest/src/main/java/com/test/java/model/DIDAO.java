package com.test.java.model;

import org.springframework.stereotype.Repository;

// @Component와 사실상 같지만 역할만 부여된 
// @Repository 어노테이션 사용
// @AutoWired 보고 컨트롤러 -> 서비스객체 -> DAO까지 내려오고
// 다시 컨트롤러로 올라가서 최종적으로는 컨트롤러에 있는 Model을 실행
@Repository
public class DIDAO {

	public String get() {

		String data = "홍길동";
		
		return null;
	}

}
