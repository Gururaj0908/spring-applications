package com.example.tkb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tkb.Entity.NewPost;

@Repository
public interface NewPostRepository extends JpaRepository<NewPost, Long>{

}
