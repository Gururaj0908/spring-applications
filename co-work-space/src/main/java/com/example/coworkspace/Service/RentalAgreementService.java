package com.example.coworkspace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coworkspace.Entity.RentalAgreement;
import com.example.coworkspace.Repository.RentalAgreementRepository;

@Service
public class RentalAgreementService {

	 @Autowired
	    private RentalAgreementRepository rentalAgreementRepository;

	    public RentalAgreement saveAgreement(RentalAgreement agreement) {
	        return rentalAgreementRepository.save(agreement);
	    }

	    public RentalAgreement getAgreementById(Long id) {
	        return rentalAgreementRepository.findById(id).orElse(null);
	    }
}
