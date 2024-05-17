package com.example.colive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colive.Entity.Bengaluru;

@Repository
public interface BengaluruRepository  extends JpaRepository<Bengaluru , Long>{

}
