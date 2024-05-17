package com.example.coworkspace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coworkspace.Entity.RegisterUserSample;
import com.example.coworkspace.Repository.RegisterUserSamplRepo;

@Service
public class RegisterUserSampleService {

	@Autowired
	public RegisterUserSamplRepo registerUserSamplRepo;
	
	public RegisterUserSample registerUser( RegisterUserSample registerUserSample) {
		return registerUserSamplRepo.save(registerUserSample);
	}
}
