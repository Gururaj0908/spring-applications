package com.example.coworkspace.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
	
	
}