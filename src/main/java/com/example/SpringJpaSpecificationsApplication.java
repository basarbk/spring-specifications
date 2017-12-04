package com.example;

import java.io.InputStream;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringJpaSpecificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaSpecificationsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(PersonDao personDao){
		return (args) -> {
			ObjectMapper mapper = new ObjectMapper();
			
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.json");
			Person[] personList = mapper.readValue(is, Person[].class);
			Arrays.stream(personList).forEach(personDao::save);
			
		};
	}
}
