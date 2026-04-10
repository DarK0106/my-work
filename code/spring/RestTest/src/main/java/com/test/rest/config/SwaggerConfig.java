package com.test.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// 스프링 설정 방식
// 1. xml로 빈 만들기
// 2. 어노테이션 방식
// 3. 자바 방식

// 이게 자바 방식(Swagger가 권장함)
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// 스프링 빈 선언하기
	// xml에서는 <bean>을 썼고
	// 어노테이션으로는 @Component를 썼는데
	// 자바 방식은 어떻게 만들지
	// 내가 스프링 빈으로 만들고 싶은 클래스 객체를 리턴하는 메서드를 하나 만들자
	// 메서드 이름은 딱히 중요하진 않음
	// @Bean이라는 어노테이션이 붙은 애의 반환 타입인 Random을 보고 빈으로 만든다?
//	@Bean
//	public Random aaa() {
//		return new Random();
//	}

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()) // API 기본 정보(메타 데이터)
				.select() // Docket 객체가 빌더 시작
				.apis(RequestHandlerSelectors.basePackage("com.test.rest"))
				// .path8s(PathSelectors.ant("/address/**"))
				.paths(PathSelectors.any()) // 모든 경로를 대상
				.build();
	}

	// 문서의 제목, 버전, 설명 등..
	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title("Address REST API").version("0.0.1")
				.description("Address 데이터에 대한 REST API 명세서입니다.").build();
	}

}
