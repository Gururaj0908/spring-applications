package com.example.coworkspace.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.userName = ?1")

    User findByUsername(String userName);

}