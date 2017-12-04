package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Person {
	
	@Id @GeneratedValue
	private long id;
	
	private String name;
	
	private int age;
	
	private String gender;
	
	private String picture;
	
	private boolean active;
	
	private String eyeColor;

}
