package com.example.coworkspace.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coworkspace.Entity.Role;
import com.example.coworkspace.Service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/roles")
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
}

