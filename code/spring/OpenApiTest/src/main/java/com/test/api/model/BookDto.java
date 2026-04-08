package com.test.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDto {
	private String title;
	private String link;
	private String image;
	private String author;
	private String discount;
	private String publisher;
}
