package com.example.tkb.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.tkb.Entity.NewPost;
import com.example.tkb.Repository.NewPostRepository;

@Service
public class NewPostService {

	@Autowired
	public NewPostRepository newPostRepository;
	
	public NewPost createNewPost(MultipartFile file,String name,String content,String postedBy,
			int likeCount, int viewCount, Date date  ) throws IOException {
		
	
		
		NewPost newPost= new NewPost();
		newPost.setName(name);
		newPost.setContent(content);
		newPost.setPostedBy(postedBy);
		newPost.setImage(file.getBytes());
		newPost.setLikeCount(0);
		newPost.setViewCount(0);
		newPost.setDate(new java.util.Date());
		newPostRepository.save(newPost);
		return newPost;
	}
	
	
	  public List<NewPost> getAllPosts() {
	        return newPostRepository.findAll();
	    }
	  
	  public NewPost getPostById(Long postId) {
		  Optional<NewPost> excistingPost= newPostRepository.findById(postId);
		  
		  if(excistingPost.isPresent()) {
			  NewPost newPost=excistingPost.get();
			  newPost.setViewCount(newPost.getViewCount()+1);
			  return newPostRepository.save(newPost);
		  }else {
			  throw new EntityNotFoundException("post nat founf");
		  }
		  
	  }
	  public void likePost(Long postId ) {
		  Optional<NewPost> excistingPost = newPostRepository.findById(postId);
		  
		  if(excistingPost.isPresent()) {

		  NewPost newPost= excistingPost.get();
		  newPost.setLikeCount(newPost.getLikeCount()+1);
		   newPostRepository.save(newPost);
		  }else {
			  throw new EntityNotFoundException("post nat founf");
		  }
	  }
	  
}
