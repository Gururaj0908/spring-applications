package com.example.coworkspace.Contoller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.coworkspace.Entity.AddCoWorkSpace;
import com.example.coworkspace.Service.AddCoWorkSpaceService;

@RestController
@CrossOrigin("*")
public class AddCoWorkSpaceController {

	@Autowired
	public AddCoWorkSpaceService addCoWorkSpaceService;
	
	@PostMapping("/cowork/addcoworkspace")
	public AddCoWorkSpace addAddCoWorkSpace( 
			@RequestParam("file") MultipartFile file,
			@RequestParam("coWorkSpaceName")String coWorkSpaceName,
			@RequestParam("coWorkSpaceAdress")String coWorkSpaceAdress,
			@RequestParam("spaceCost")String spaceCost,
			@RequestParam("hotelWebsite")String hotelWebsite
			) throws IOException {
		return addCoWorkSpaceService.AddCoWorkSpace(file, coWorkSpaceName, coWorkSpaceAdress, spaceCost, hotelWebsite) ;
	}
	
	@GetMapping("/cowork/getallspaces")
	public List<AddCoWorkSpace> getAllSpaces(){
		return addCoWorkSpaceService.getAllSpaces();
	}
}
