package com.test.java.crawl.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieDto {
	private String seq;
	private String title;
	private String date;
	private String genre;
	private String director;
	private String[] actor;
	private String poster;
}
