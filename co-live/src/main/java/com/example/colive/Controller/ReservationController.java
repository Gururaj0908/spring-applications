package com.example.colive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.colive.Entity.Reservation;
import com.example.colive.Service.ReservationService;

@RestController
@CrossOrigin("*")
public class ReservationController {

	@Autowired
	public ReservationService reservationService ;
	
	@PostMapping("/colive/reservation")
	public ResponseEntity<Reservation> addReservation(
			@RequestParam("userFirstName")String userFirstName,
			@RequestParam("userLastName")String userLastName,
			@RequestParam("email")String email,
			@RequestParam("country")String country,
			@RequestParam("adress")String adress,
			@RequestParam("city")String city,
			@RequestParam("postalCode")String postalCode,
			@RequestParam("countryCode")String countryCode,
			@RequestParam("phone")String phone

) {
		return ResponseEntity.ok(reservationService.addReservation(userFirstName, userLastName, email, country, adress, city, postalCode, countryCode, phone));
	}
}
