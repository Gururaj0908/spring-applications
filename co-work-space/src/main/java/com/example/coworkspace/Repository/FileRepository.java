package com.example.coworkspace.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.FileEntity;

@Repository
public interface FileRepository extends CrudRepository<FileEntity, Long> {
    // Additional methods can be added here if needed
}