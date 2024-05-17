package com.example.coworkspace.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.coworkspace.Entity.RentalAgreement;
import com.example.coworkspace.Service.RentalAgreementService;

@RestController
@CrossOrigin("*")

public class AdminRentalAgreementController {

	   @Autowired
	    private RentalAgreementService rentalAgreementService;

	    @PostMapping("/admin/uploadAgreement")
	    public ResponseEntity<String> uploadAgreement(@RequestParam("file") MultipartFile file) {
	        try {
	            RentalAgreement agreement = new RentalAgreement();
	            agreement.setFile(file.getBytes());
	            rentalAgreementService.saveAgreement(agreement);
	            return ResponseEntity.ok().body("{\"message\": \"Rental agreement uploaded successfully.\"}");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Failed to upload rental agreement.");
	        }
	    }
}
