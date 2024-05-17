package com.example.colive.Entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Bengaluru {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String hotelName;
	
	public String hotelAdress;
	
	public String hotelCost;
	
	public String hotelWebsite;
	
	@Lob
	public byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAdress() {
		return hotelAdress;
	}

	public void setHotelAdress(String hotelAdress) {
		this.hotelAdress = hotelAdress;
	}

	public String getHotelCost() {
		return hotelCost;
	}

	public void setHotelCost(String hotelCost) {
		this.hotelCost = hotelCost;
	}

	public String getHotelWebsite() {
		return hotelWebsite;
	}

	public void setHotelWebsite(String hotelWebsite) {
		this.hotelWebsite = hotelWebsite;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Bengaluru [id=" + id + ", hotelName=" + hotelName + ", hotelAdress=" + hotelAdress + ", hotelCost="
				+ hotelCost + ", hotelWebsite=" + hotelWebsite + ", image=" + Arrays.toString(image) + ", getId()="
				+ getId() + ", getHotelName()=" + getHotelName() + ", getHotelAdress()=" + getHotelAdress()
				+ ", getHotelCost()=" + getHotelCost() + ", getHotelWebsite()=" + getHotelWebsite() + ", getImage()="
				+ Arrays.toString(getImage()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Bengaluru(Long id, String hotelName, String hotelAdress, String hotelCost, String hotelWebsite,
			byte[] image) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.hotelAdress = hotelAdress;
		this.hotelCost = hotelCost;
		this.hotelWebsite = hotelWebsite;
		this.image = image;
	}

	public Bengaluru() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
