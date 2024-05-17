package com.example.coworkspace.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coworkspace.Entity.CoWorkSpace;
import com.example.coworkspace.Repository.CoWorkSpaceRepository;

@Service
	public class CoWorkSpaceService {

		@Autowired
		private CoWorkSpaceRepository coWorkSpaceRepository;
		
		public CoWorkSpace createCoWorkSpace(CoWorkSpace coWorkSpace) {
			return coWorkSpaceRepository.save(coWorkSpace);
			
		}

		public List<CoWorkSpace> getAllCoWorkSpace(){
			return ( List<CoWorkSpace>)coWorkSpaceRepository.findAll();
	    }
		
		public void deleteCoWorkSpace(Long id) {
			coWorkSpaceRepository.deleteById(id);
		}


	}

