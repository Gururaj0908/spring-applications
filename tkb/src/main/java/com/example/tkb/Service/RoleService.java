package com.example.tkb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tkb.Entity.Role;
import com.example.tkb.Repository.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	public Role createNewRole(Role role) {
		return roleRepo.save(role);
	}
}
