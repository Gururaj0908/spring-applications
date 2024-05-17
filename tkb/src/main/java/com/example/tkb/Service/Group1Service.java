package com.example.tkb.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tkb.Entity.Group1;
import com.example.tkb.Entity.User;
import com.example.tkb.Repository.Group1Repository;
import com.example.tkb.Repository.UserRepository;

@Service
public class Group1Service {


    @Autowired
    private Group1Repository groupRepository;

    @Autowired
    private UserRepository userRepository;

    public Group1 createGroup(Group1 group) {
        return groupRepository.save(group);
    }

    public Group1 getGroup(Long groupId) {
        return groupRepository.findById(groupId)
                .orElse(null);
    }

	public List<Group1> getAllGroups() {
		// TODO Auto-generated method stub
		return groupRepository.findAll();
	}

	public void saveGroup(Group1 group) {
	    groupRepository.save(group);
	}
	 
	/*  // Method to get the number of users joined the group with their names
    public Map<String, List<String>> getUsersInGroup(Long groupId) {
        Optional<Group1> optionalGroup = groupRepository.findById(groupId);
        if (optionalGroup.isPresent()) {
            Group1 group = optionalGroup.get();
            List<String> userNames = group.getMembers().stream().map(User::getUserName).collect(Collectors.toList());
            Map<String, List<String>> result = new HashMap<>();
            result.put(group.getName(), userNames);
            return result;
        } else {
            throw new NoSuchElementException("Group not found");
        }
    }

    // Method to get the total number of users inside the group
    public int getTotalUsersInGroup(Long groupId) {
        Optional<Group1> optionalGroup = groupRepository.findById(groupId);
        if (optionalGroup.isPresent()) {
            Group1 group = optionalGroup.get();
            return group.getMembers().size();
        } else {
            throw new NoSuchElementException("Group not found");
        }
    }
    */

    public Map<String, List<String>> getUsersInGroup(Long groupId) {
        Group1 group = groupRepository.findById(groupId).orElseThrow();

        Map<String, List<String>> usersInGroup = new HashMap<>();
        List<String> usernames = group.getMembers().stream().map(User::getUserName).collect(Collectors.toList());
        usersInGroup.put(group.getName(), usernames);

        return usersInGroup;
    }

    public int getTotalUsersInGroup(Long groupId) {
        Group1 group = groupRepository.findById(groupId).orElseThrow();
        return group.getMembers().size();
    }

    @Transactional
    public void addUserToGroup(String userName, Long groupId) throws Exception {
        // Step 1: Check if the groupId corresponds to an existing group
        Optional<Group1> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) {
            throw new Exception("Group not found with id: " + groupId);
        }
        Group1 group = groupOptional.get();

        // Step 2: Retrieve the user from the database
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new Exception("User not found with username: " + userName);
        }

        // Step 3: Verify that the user is not already a member of the group
        if (user.getGroups().contains(group)) {
            throw new Exception("User " + userName + " is already a member of the group with id: " + groupId);
        }

        // Step 4: Add the user to the group
        user.getGroups().add(group);
        userRepository.save(user);
    }
}
