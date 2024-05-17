package com.example.tkb.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tkb.Entity.Comment;
import com.example.tkb.Entity.NewPost;
import com.example.tkb.Repository.CommentRepository;
import com.example.tkb.Repository.NewPostRepository;

@Service
public class CommentService {

	@Autowired
	public CommentRepository commentRepository;
	
	@Autowired
	public NewPostRepository newPostRepository;
	
	public Comment postComment(Long id, String content,String postedBy) {
		
		Optional<NewPost> excistingPost= newPostRepository.findById(id);
		
		if(excistingPost.isPresent()) {
		Comment comment = new Comment();
		
		comment.setNewpost(excistingPost.get());
		comment.setContent(content);
		comment.setPostedBy(postedBy);
		comment.setCreatedAt(new Date());
		return commentRepository.save(comment) ;
	}
		throw new EntityNotFoundException();
	}
	
	public List<Comment> getAllComments(Long id){
		return commentRepository.getCommentsById(id);
	}
}
