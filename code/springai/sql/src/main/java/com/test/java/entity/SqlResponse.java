package com.test.java.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO
@Getter
@Setter
@ToString
@AllArgsConstructor
public class SqlResponse {

	private String query;
	private List<Map<String, Object>> result;
	
}
