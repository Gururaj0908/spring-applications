package com.example.colive.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.colive.Entity.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
	
	
}