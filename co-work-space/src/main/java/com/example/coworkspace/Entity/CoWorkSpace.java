package com.example.coworkspace.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoWorkSpace {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long Id;
	public String coWorkSpaceName;
	public String details;
	public String adress;
	public int amount;
	public String image;
	
	

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCoWorkSpaceName() {
		return coWorkSpaceName;
	}
	public void setCoWorkSpaceName(String coWorkSpaceName) {
		this.coWorkSpaceName = coWorkSpaceName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public CoWorkSpace(Long id, String coWorkSpaceName, String details, String adress, int amount,String image) {
		super();
		Id = id;
		this.coWorkSpaceName = coWorkSpaceName;
		this.details = details;
		this.adress = adress;
		this.amount = amount;
		this.image = image;
	}
	public CoWorkSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
