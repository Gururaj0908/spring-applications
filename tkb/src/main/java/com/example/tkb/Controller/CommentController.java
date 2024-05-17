package com.example.tkb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tkb.Service.CommentService;

@RestController
@CrossOrigin("*")

public class CommentController {

	@Autowired
	public CommentService commentService;
	
	
	@PostMapping("/comment")
	public ResponseEntity<?> postComment(@RequestParam Long id,@RequestParam String postedBy ,@RequestParam String content){
		try {
		return	ResponseEntity.ok(commentService.postComment(id, content, postedBy));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}
	
	
	@GetMapping("/comment/{id}")
	public ResponseEntity<?> getCommentsById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(commentService.getAllComments(id));

		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());

		}
	}
}
