package com.example.tkb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tkb.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Long> {

	
List<Comment> getCommentsById(Long id);
}
