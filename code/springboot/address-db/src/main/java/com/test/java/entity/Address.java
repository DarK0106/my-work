package com.test.java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tblAddress")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
	
	@Id
	@SequenceGenerator(name = "seqAddress", allocationSize = 1, sequenceName = "seqAddress")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAddress")
	private Long seq;
	
	private String name;
	private Long age;
	private String gender;
	private String address;	
	
}
