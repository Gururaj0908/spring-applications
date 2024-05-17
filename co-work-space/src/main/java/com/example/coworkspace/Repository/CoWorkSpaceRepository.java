package com.example.coworkspace.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.CoWorkSpace;

@Repository
public interface CoWorkSpaceRepository extends CrudRepository<CoWorkSpace, Long>{

	
}
