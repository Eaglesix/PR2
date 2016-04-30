package org.campus02.personen;

public class Person {

	private String vorname;
	private String nachname;
	private String geburtsort;
	
	public Person(String vorname, String nachname, String geburtsort) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsort = geburtsort;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getGeburtsort() {
		return geburtsort;
	}
	public void setGeburtsort(String geburtsort) {
		this.geburtsort = geburtsort;
	}
	@Override
	public String toString() {
		return "Person [vorname=" + vorname + ", nachname=" + nachname + ", geburtsort=" + geburtsort + "]";
	}
	
	
}
