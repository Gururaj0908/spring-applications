package com.example.tkb.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tkb.Entity.User;
import com.example.tkb.Repository.UserRepository;
import com.example.tkb.Service.UserService;



@RestController
@CrossOrigin("*")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private UserRepository userRepository;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}
	
	@PostMapping("/tkb/users")
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}
	
	@GetMapping("/forAdmin")
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This url is only accessible to admin";
	}
	
	@GetMapping("/forUser")
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This url is only accessible to user";
	}
	
	@GetMapping("/currentUser")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new RuntimeException("User not found: " + username);
            }
            return user;
        } else {
            throw new IllegalStateException("User not authenticated or not found");
        }
    }
	
}
