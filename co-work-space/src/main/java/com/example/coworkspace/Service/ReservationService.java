package com.example.coworkspace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coworkspace.Entity.Reservation;
import com.example.coworkspace.Repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	public ReservationRepository reservationRepository;
	
	public Reservation addReservation(String userFirstName, String userLastName, String email,String country, String adress,String city, String postalCode,String countryCode, String phone) {
		
		Reservation reservation1=new Reservation();
		reservation1.setUserFirstName(userFirstName);
		reservation1.setUserLastName(userLastName);
		reservation1.setEmail(email);
		reservation1.setCountry(country);
		reservation1.setAdress(adress);
		reservation1.setCity(city);
		reservation1.setCountryCode(countryCode);
		reservation1.setPostalCode(postalCode);
		reservation1.setPhone(phone);

		return reservationRepository.save(reservation1);
	}
}



