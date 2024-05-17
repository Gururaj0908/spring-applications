package com.example.colive.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.colive.Entity.Bengaluru;
import com.example.colive.Service.BengaluruService;

@RestController
@CrossOrigin("*")

public class BengaluruController {

	@Autowired
	public BengaluruService bengaluruService;
	
	@PostMapping("/colive/addBengaluru")
	public Bengaluru addBengaluruHotels( 
			@RequestParam("file") MultipartFile file,
			@RequestParam("hotelName")String hotelName,
			@RequestParam("hotelAdress")String hotelAdress,
			@RequestParam("hotelCost")String hotelCost,
			@RequestParam("hotelWebsite")String hotelWebsite
			) throws IOException {
		
		return bengaluruService.addBengaluruHotel(file, hotelName, hotelAdress, hotelCost, hotelWebsite);
	}
	
	@GetMapping("/colive/getAllbengaluru")
	public List<Bengaluru> getAllBengaluruHotels(){
		return bengaluruService.getAllBengaluruHotels();
	}
}
