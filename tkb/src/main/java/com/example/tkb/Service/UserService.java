package com.example.tkb.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tkb.Entity.Group1;
import com.example.tkb.Entity.Role;
import com.example.tkb.Entity.User;
import com.example.tkb.Repository.Group1Repository;
import com.example.tkb.Repository.RoleRepository;
import com.example.tkb.Repository.UserRepository;

import javassist.NotFoundException;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerNewUser(User user) {
		Role role = roleRepo.findById("User").get();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		return userRepo.save(user);
	}
	
	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleRepo.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleRepo.save(userRole);
		
		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserPassword(getEncodedPassword("admin@12345"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);	
		adminUser.setRoles(adminRoles);
		userRepo.save(adminUser);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	 @Autowired
	    private Group1Repository groupRepository;


	 @Transactional
	    public void addUserToGroup(String userName, Long groupId) throws Exception {
	        User user = userRepo.findByUsername(userName);
	        if (user == null) {
	            throw new Exception("User not found with username: " + userName);
	        }

	        Optional<Group1> groupOptional = groupRepository.findById(groupId);
	        if (groupOptional.isEmpty()) {
	            throw new Exception("Group not found with id: " + groupId);
	        }

	        Group1 group = groupOptional.get();

	        // Check if the group is valid
	        if (!group.getId().equals(groupId)) {
	            throw new Exception("Invalid group id: " + groupId);
	        }

	        if (user.getGroups().contains(group)) {
	            throw new Exception("User " + userName + " is already a member of the group with id: " + groupId);
	        }

	        try {
	            user.getGroups().add(group);
	            userRepo.save(user);
	        } catch (DataIntegrityViolationException e) {
	            // Handle the constraint violation
	            throw new Exception("Group not found with id: " + groupId, e);
	        }
	    }
	    @Autowired
	    private Group1Repository group1Repository;

	    public void registerNewUser(User user, Long groupId) {
	        Optional<Group1> group = group1Repository.findById(groupId);
	        if (!group.isPresent()) {
	            throw new IllegalArgumentException("Group ID does not exist");
	        }
	        user.getGroups().add(group.get());
	        userRepo.save(user);
	    }
	    
}
