package com.example;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class Filter {

	String gender;
	
	@Min(18)
	Integer age;
	
	Boolean hasPicture;
	
	Boolean active;
	
	String eyeColor;
}
