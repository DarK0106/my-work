package com.test.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PointDto {
	private String seq;
	private Integer point;
	private String aseq; // FK
}
