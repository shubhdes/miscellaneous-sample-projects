package com.pattern.creational.builder;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private char gender;
	private String address;
	private String city;
	private String state;
	private String country;
	private long pincode;
	private String mobile;
	private String email;

	public Person(String firstName, String lastName, int age, char gender, String address, String city, String state,
			String country, long pincode, String mobile, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.mobile = mobile;
		this.email = email;
	}

	public static PersonBuilder getBuilder() {
		return new PersonBuilder();
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + ", mobile=" + mobile + ", email=" + email + "]";
	}

	public static class PersonBuilder {

		private String firstName;
		private String lastName;
		private int age;
		private char gender;
		private String address;
		private String city;
		private String state;
		private String country;
		private long pincode;
		private String mobile;
		private String email;
		private Person person;

		public PersonBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public PersonBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PersonBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public PersonBuilder withGender(char gender) {
			this.gender = gender;
			return this;
		}

		public PersonBuilder withAddress(String address) {
			this.address = address;
			return this;
		}

		public PersonBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public PersonBuilder withState(String state) {
			this.state = state;
			return this;
		}

		public PersonBuilder withCountry(String country) {
			this.country = country;
			return null;
		}

		public PersonBuilder withPincode(long pincode) {
			this.pincode = pincode;
			return null;
		}

		public PersonBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public PersonBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Person build() {
			this.person = new Person(firstName, lastName, age, gender, address, city, state, country, pincode, mobile,
					email);
			return person;
		}

		public Person getPerson() {
			return person;
		}
	}

}
