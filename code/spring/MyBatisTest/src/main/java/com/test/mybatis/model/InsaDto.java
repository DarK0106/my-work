package com.test.mybatis.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InsaDto {
	private String num;
	private String name;
	private String buseo;
	private String jikwi;
	// 문제 해결을 위해 Alias 처리 할 것
	// 일부러 틀리게 작성해본 것
	private Integer salary; // tblInsa에 없는 컬럼임, basicpay가 있음
	
	// 직원 한명이 여러개의 프로젝트를 맡을 수 있음
	private List<ProjectDto> project;
}
