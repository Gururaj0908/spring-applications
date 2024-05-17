package com.example.colive.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colive.Entity.Role;
import com.example.colive.Repository.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	public Role createNewRole(Role role) {
		return roleRepo.save(role);
	}
}
