package com.example.tkb.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tkb.Entity.Role;



@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
	
	
}