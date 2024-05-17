package com.example.colive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.colive.Entity.RegisterUserSample;
import com.example.colive.Service.RegisterUserSampleService;



@RestController
@CrossOrigin("*")
public class RegisterUserSampleController {

	@Autowired
	public RegisterUserSampleService registerUserSampleService;
	
	@PostMapping("/registerUserSample")
	public  RegisterUserSample register(@RequestBody RegisterUserSample registerUserSample ) {
		return registerUserSampleService.registerUser(registerUserSample);
	}
}

