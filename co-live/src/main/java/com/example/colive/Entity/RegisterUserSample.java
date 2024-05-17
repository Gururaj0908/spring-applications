package com.example.colive.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userSample")
public class RegisterUserSample {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String userName;
	private String email;
	private String phone;
	private String message;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "RegisterUserSample [ userName=" + userName + ", email=" + email + ", phone=" + phone
				+ ", message=" + message + ", getUserName()=" + getUserName() + ", getEmail()="
				+ getEmail() + ", getPhone()=" + getPhone() + ", getMessage()=" + getMessage() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public RegisterUserSample() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterUserSample(Long id, String userName, String email, String phone, String message) {
		super();
		
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}
	
	
	
	
}

