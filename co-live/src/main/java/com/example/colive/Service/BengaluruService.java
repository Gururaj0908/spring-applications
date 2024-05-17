package com.example.colive.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.colive.Entity.Bengaluru;
import com.example.colive.Repository.BengaluruRepository;

@Service
public class BengaluruService {
	
	@Autowired
	public BengaluruRepository bengaluruRepository;
	
	public Bengaluru addBengaluruHotel(MultipartFile file, String hotelName, String hotelAdress,
			String hotelCost, String hotelWebsite) throws IOException {
		
		Bengaluru bengaluru = new Bengaluru();
		bengaluru.setHotelName(hotelName);
		bengaluru.setHotelAdress(hotelAdress);
		bengaluru.setHotelWebsite(hotelWebsite);
		bengaluru.setHotelCost(hotelCost);
		bengaluru.setImage(file.getBytes());
		
		bengaluruRepository.save(bengaluru);
		
		return bengaluru;
		}
	
	public List<Bengaluru> getAllBengaluruHotels(){
		return bengaluruRepository.findAll();
	}
}
