package com.example.tkb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tkb.Entity.Group1;

@Repository
public interface Group1Repository extends JpaRepository<Group1, Long>{

}
