package com.example.colive.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.colive.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}