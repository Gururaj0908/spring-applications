package com.example.tkb.Controller;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.tkb.Entity.User;

@Entity
public class NewGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    
    @ManyToMany(mappedBy = "groups")
    private Set<User> members = new HashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<User> getMembers() {
		return members;
	}


	public void setMembers(Set<User> members) {
		this.members = members;
	}


	@Override
	public String toString() {
		return "NewGroup [id=" + id + ", name=" + name + ", description=" + description + ", members=" + members
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getDescription()=" + getDescription()
				+ ", getMembers()=" + getMembers() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	public NewGroup(Long id, String name, String description, Set<User> members) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.members = members;
	}


	public NewGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
