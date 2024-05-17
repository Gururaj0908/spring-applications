package com.example.colive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colive.Entity.RegisterUserSample;

@Repository
public interface UserSampleRepository extends JpaRepository<RegisterUserSample , Long> {

}
