package com.example.tkb.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	   @Id
	    private String userName;

	    private String userFirstName;
	    private String userLastName;
	    private String userPassword;

	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "user_role", 
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles;

	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "user_group",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "group_id"))
	    private Set<Group1> groups = new HashSet<>();


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Group1> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group1> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userPassword=" + userPassword + ", roles=" + roles + ", groups=" + groups + ", getUserName()="
				+ getUserName() + ", getUserFirstName()=" + getUserFirstName() + ", getUserLastName()="
				+ getUserLastName() + ", getUserPassword()=" + getUserPassword() + ", getRoles()=" + getRoles()
				+ ", getGroups()=" + getGroups() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public User(String userName, String userFirstName, String userLastName, String userPassword, Set<Role> roles,
			Set<Group1> groups) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.roles = roles;
		this.groups = groups;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

