package com.example;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Person.class)
public class Person_ {
	
	public static volatile SingularAttribute<Person, String> gender;
	public static volatile SingularAttribute<Person, Integer> age;
	public static volatile SingularAttribute<Person, String> picture;
	public static volatile SingularAttribute<Person, Boolean> active;
	public static volatile SingularAttribute<Person, String> eyeColor;

}
