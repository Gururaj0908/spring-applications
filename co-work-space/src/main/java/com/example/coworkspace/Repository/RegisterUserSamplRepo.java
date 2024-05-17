package com.example.coworkspace.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.RegisterUserSample;

@Repository
public interface RegisterUserSamplRepo extends CrudRepository<RegisterUserSample, Long>{

}
