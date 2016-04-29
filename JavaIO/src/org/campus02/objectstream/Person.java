package org.campus02.objectstream;

import java.io.Serializable;

public class Person implements Serializable {
	private String vorname;
	private String nachname;
	private int age;
	
	@Override
	public String toString() {
		return "Person [vorname=" + vorname + ", nachname=" + nachname + ", age=" + age + "]";
	}

	public Person(String vorname, String nachname, int age) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.age = age;
	}
	
	
}
