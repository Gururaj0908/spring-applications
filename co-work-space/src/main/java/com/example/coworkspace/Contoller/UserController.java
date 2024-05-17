package com.example.coworkspace.Contoller;


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

import com.example.coworkspace.Entity.User;
import com.example.coworkspace.Repository.UserRepository;
import com.example.coworkspace.Service.CustomUserDetailsService;
import com.example.coworkspace.Service.UserService;

@RestController
@CrossOrigin("*")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public CustomUserDetailsService userDetailService;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}
	
	@PostMapping("/users")
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

	@Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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









