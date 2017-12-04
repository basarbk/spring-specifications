package com.example;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/people")
	public ResponseEntity<?> getMathcingPeople(Pageable pageable, @Valid Filter filter){
		return ResponseEntity.ok(personService.getMachingPeople(pageable, filter));
	}
	
}
