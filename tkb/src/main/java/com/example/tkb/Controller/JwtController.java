package com.example.tkb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tkb.Model.JwtRequest;
import com.example.tkb.Model.JwtResponse;
import com.example.tkb.Service.JwtService;



@RestController
@CrossOrigin
public class JwtController {
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}
}