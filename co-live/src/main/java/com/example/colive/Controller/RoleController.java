package com.example.colive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.colive.Entity.Role;
import com.example.colive.Service.RoleService;


@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/roles")
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
}

