package com.example.tkb.Controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.tkb.Entity.NewPost;
import com.example.tkb.Service.NewPostService;

@RestController
@CrossOrigin("*")

public class NewPostController {

	@Autowired
	public NewPostService newPostService;
	
	@PostMapping("/tkb/save")
	public NewPost newPost(@RequestParam("file") MultipartFile file,
			@RequestParam("name")String name,
			@RequestParam("content")String content,
			@RequestParam("postedBy")String postedBy ) throws IOException {
						
		return newPostService.createNewPost(file, name, content, postedBy, 0, 0, null);
		
	}
	
	
	  @GetMapping("/tkb/all")
	    public List<NewPost> getAllPosts() {
	        return newPostService.getAllPosts();
	    }
	  
	  @GetMapping("/tkb/{postId}")
	  public ResponseEntity<?> getPostById(@PathVariable Long postId) {
		  try {
			  NewPost post= newPostService.getPostById(postId);
			  return ResponseEntity.ok(post);
		  }catch(EntityNotFoundException e) {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		  }
	  }
	  
	 @PutMapping("/{postId}/likes")
	  public ResponseEntity<?> getLikes( @PathVariable Long postId){
		  try {
			  newPostService.likePost(postId);
			  return ResponseEntity.ok(new String[] {"post like succesfully"});
		  }catch(EntityNotFoundException e) {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		  }
		  
	  }
	  
}
