package com.example.colive.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String userFirstName;
	
	private String userLastName;
		
	private String email;
	
	private String country;
	
	private String adress;
	
	private String city;
	
	private String postalCode;
	
	private String countryCode;
	
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", email=" + email + ", country=" + country + ", adress=" + adress + ", city=" + city
				+ ", postalCode=" + postalCode + ", countryCode=" + countryCode + ", phone=" + phone + ", getId()="
				+ getId() + ", getUserFirstName()=" + getUserFirstName() + ", getUserLastName()=" + getUserLastName()
				+ ", getEmail()=" + getEmail() + ", getCountry()=" + getCountry() + ", getAdress()=" + getAdress()
				+ ", getCity()=" + getCity() + ", getPostalCode()=" + getPostalCode() + ", getCountryCode()="
				+ getCountryCode() + ", getPhone()=" + getPhone() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Reservation(Long id, String userFirstName, String userLastName, String email, String country, String adress,
			String city, String postalCode, String countryCode, String phone) {
		super();
		this.id = id;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.email = email;
		this.country = country;
		this.adress = adress;
		this.city = city;
		this.postalCode = postalCode;
		this.countryCode = countryCode;
		this.phone = phone;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
