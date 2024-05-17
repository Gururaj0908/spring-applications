package com.example.coworkspace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coworkspace.Entity.Role;
import com.example.coworkspace.Repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	public Role createNewRole(Role role) {
		return roleRepo.save(role);
	}
}
