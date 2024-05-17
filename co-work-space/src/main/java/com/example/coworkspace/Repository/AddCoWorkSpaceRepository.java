package com.example.coworkspace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.AddCoWorkSpace;

@Repository
public interface AddCoWorkSpaceRepository extends JpaRepository<AddCoWorkSpace, Long>{

}
