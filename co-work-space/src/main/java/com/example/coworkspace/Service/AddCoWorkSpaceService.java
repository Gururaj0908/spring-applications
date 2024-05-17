package com.example.coworkspace.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.coworkspace.Entity.AddCoWorkSpace;
import com.example.coworkspace.Repository.AddCoWorkSpaceRepository;

@Service
public class AddCoWorkSpaceService {

	@Autowired
	public AddCoWorkSpaceRepository addCoWorkSpaceRepository;
	
	public  AddCoWorkSpace  AddCoWorkSpace( MultipartFile file, String coWorkSpaceName, String coWorkSpaceAdress,String spaceCost,String hotelWebsite) throws IOException {
		
		AddCoWorkSpace addCoWorkSpace= new AddCoWorkSpace();
		addCoWorkSpace.setCoWorkSpaceName(coWorkSpaceName);
		addCoWorkSpace.setCoWorkSpaceAdress(coWorkSpaceAdress);
		addCoWorkSpace.setHotelWebsite(hotelWebsite);
		addCoWorkSpace.setSpaceCost(spaceCost);
		addCoWorkSpace.setImage(file.getBytes());
		
		return addCoWorkSpaceRepository.save(addCoWorkSpace);
	}
	
	public List<AddCoWorkSpace> getAllSpaces(){
		return addCoWorkSpaceRepository.findAll();
	}
}
