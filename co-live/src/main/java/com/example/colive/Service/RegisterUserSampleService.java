package com.example.colive.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colive.Entity.RegisterUserSample;
import com.example.colive.Repository.UserSampleRepository;



@Service
public class RegisterUserSampleService {

	@Autowired
	public UserSampleRepository registerUserSamplRepo;
	
	public RegisterUserSample registerUser( RegisterUserSample registerUserSample) {
		return registerUserSamplRepo.save(registerUserSample);
	}
}

