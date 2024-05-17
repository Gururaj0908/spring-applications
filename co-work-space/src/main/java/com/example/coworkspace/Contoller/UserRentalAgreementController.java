package com.example.coworkspace.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.coworkspace.Entity.RentalAgreement;
import com.example.coworkspace.Service.RentalAgreementService;

@RestController
@CrossOrigin("*")

public class UserRentalAgreementController {

	 @Autowired
	    private RentalAgreementService rentalAgreementService;

	    @GetMapping("/user/downloadAgreement/{id}")
	    public ResponseEntity<byte[]> downloadAgreement(@PathVariable Long id) {
	        RentalAgreement agreement = rentalAgreementService.getAgreementById(id);
	        if (agreement != null) {
	            return ResponseEntity.ok()
	                    .contentType(MediaType.APPLICATION_PDF)

	                    .header("Content-Disposition", "attachment; filename=\"rental_agreement.pdf\"")
	                    .body(agreement.getFile());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("/user/signAgreement/{id}")
	    public ResponseEntity<String> signAgreement(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
	        try {
	            RentalAgreement agreement = rentalAgreementService.getAgreementById(id);
	            if (agreement != null) {
	                agreement.setFile(file.getBytes());
	                rentalAgreementService.saveAgreement(agreement);
	                return ResponseEntity.ok("Rental agreement signed and uploaded successfully.");
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Failed to sign rental agreement.");
	        }
	    }
}
