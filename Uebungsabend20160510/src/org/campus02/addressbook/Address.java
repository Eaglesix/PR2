package org.campus02.addressbook;

public class Address {
	private String firstname;
	private String lastname;
	private String mobileNumber;
	private String email;
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Address [firstname=" + firstname + ", lastname=" + lastname + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "]";
	}

	public Address(String firstname, String lastname, String mobileNumber, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	
	
}
