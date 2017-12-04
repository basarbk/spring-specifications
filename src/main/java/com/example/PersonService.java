package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	PersonDao personDao;

	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public Page<Person> getMachingPeople(Pageable pageable, Filter filter){
		List<Specification<Person>> specs = new ArrayList<>();
		if(filter.getGender() != null) 
			specs.add(gender(filter.getGender()));
		
		if(filter.getAge()!=null)
			specs.add(ageGreaterThan(filter.getAge()));
		
		if(filter.getHasPicture()!=null)
			specs.add(hasPicture(filter.getHasPicture()));
				
		if(filter.getActive()!=null)
			specs.add(active(filter.getActive()));
		
		if(filter.getEyeColor()!=null)
			specs.add(eyeColor(filter.getEyeColor()));

		if(specs.size() == 0)
			return personDao.findAll(pageable);
		
		Specification<Person> spec = specs.get(0);
		for(int i = 1; i<specs.size();i++)
			spec = Specifications.where(spec).and(specs.get(i));
		
		return personDao.findAll(spec, pageable);
	}
	
	private Specification<Person> gender(String gender){
		return (root, query, cb) -> {
			return cb.equal(root.get(Person_.gender), gender);
		};
	}
	
	private Specification<Person> hasPicture(boolean hasPicture){
		return (root, query, cb) -> {
			if(hasPicture)				
				return cb.isNotNull(root.get(Person_.picture));
			return cb.isNull(root.get(Person_.picture));
		};
	}
	
	private Specification<Person> ageGreaterThan(int age){
		return (root, query, cb) -> {
			return cb.greaterThan(root.get(Person_.age), age);
		};
	}
	
	private Specification<Person> active(boolean active){
		return (root, query, cb) -> {
			return cb.equal(root.get(Person_.active), active);
		};
	}

	private Specification<Person> eyeColor(String eyeColor){
		return (root, query, cb) -> {
			return cb.equal(root.get(Person_.eyeColor), eyeColor);
		};
	}
}
