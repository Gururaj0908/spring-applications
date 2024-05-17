package com.example.coworkspace.Entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class AddCoWorkSpace {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String coWorkSpaceName;
	
	public String coWorkSpaceAdress;
	
	public String spaceCost;
	
	public String hotelWebsite;
	
	@Lob
	public byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoWorkSpaceName() {
		return coWorkSpaceName;
	}

	public void setCoWorkSpaceName(String coWorkSpaceName) {
		this.coWorkSpaceName = coWorkSpaceName;
	}

	public String getCoWorkSpaceAdress() {
		return coWorkSpaceAdress;
	}

	public void setCoWorkSpaceAdress(String coWorkSpaceAdress) {
		this.coWorkSpaceAdress = coWorkSpaceAdress;
	}

	public String getSpaceCost() {
		return spaceCost;
	}

	public void setSpaceCost(String spaceCost) {
		this.spaceCost = spaceCost;
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
		return "AddCoWorkSpace [id=" + id + ", coWorkSpaceName=" + coWorkSpaceName + ", coWorkSpaceAdress="
				+ coWorkSpaceAdress + ", spaceCost=" + spaceCost + ", hotelWebsite=" + hotelWebsite + ", image="
				+ Arrays.toString(image) + ", getId()=" + getId() + ", getCoWorkSpaceName()=" + getCoWorkSpaceName()
				+ ", getCoWorkSpaceAdress()=" + getCoWorkSpaceAdress() + ", getSpaceCost()=" + getSpaceCost()
				+ ", getHotelWebsite()=" + getHotelWebsite() + ", getImage()=" + Arrays.toString(getImage())
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public AddCoWorkSpace(Long id, String coWorkSpaceName, String coWorkSpaceAdress, String spaceCost,
			String hotelWebsite, byte[] image) {
		super();
		this.id = id;
		this.coWorkSpaceName = coWorkSpaceName;
		this.coWorkSpaceAdress = coWorkSpaceAdress;
		this.spaceCost = spaceCost;
		this.hotelWebsite = hotelWebsite;
		this.image = image;
	}

	public AddCoWorkSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
