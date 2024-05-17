package com.example.tkb.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tkb.Entity.Group1;
import com.example.tkb.Entity.User;
import com.example.tkb.Service.Group1Service;
import com.example.tkb.Service.UserService;


@RestController
@CrossOrigin("*")
public class Group1Controller {


    @Autowired
    private Group1Service groupService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/tkb/group/create")
    public ResponseEntity<Group1> createGroup(@RequestBody Group1 group) {
        Group1 createdGroup = groupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @GetMapping("/tkb/group/{groupId}")
    public ResponseEntity<Group1> getGroup(@PathVariable Long groupId) {
        Group1 group = groupService.getGroup(groupId);
        return ResponseEntity.ok(group);
    }
    
    @GetMapping("/tkb/getAllGroups")
    public ResponseEntity<List<Group1>> getAllGroups() {
        List<Group1> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    /*
    @PostMapping("/tkb/{groupId}/join")
    public ResponseEntity<Group1> joinGroup(@PathVariable Long groupId, @RequestBody User user) {
        
    	Group1 group = groupService.getGroup(groupId);
        group.getMembers().add(user);
        groupService.saveGroup(group);
        return ResponseEntity.ok(group);
    }
    */
    
    @PostMapping("/tkb/{groupId}/join")
    public ResponseEntity<Group1> joinGroup(@PathVariable Long groupId, @RequestBody User user) {
        Group1 group = groupService.getGroup(groupId);
        if (group == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if group not found
        }
        
        // Ensure cascade settings are correctly configured
        Set<User> members = group.getMembers();
        members.add(user);
        group.setMembers(members); // Update the members set in Group1

        // Update the groups set in User
        Set<Group1> userGroups = user.getGroups();
        userGroups.add(group);
        user.setGroups(userGroups);

        // Save the user and group
        try {
            groupService.saveGroup(group);
            userService.registerNewUser(user);
            return ResponseEntity.ok(group);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Return 500 if error occurs
        }
    }


    // Endpoint to get the number of users joined the group with their names
    @GetMapping("/tkb/{groupId}/users")
    public ResponseEntity<Map<String, List<String>>> getUsersInGroup(@PathVariable Long groupId) {
        Map<String, List<String>> usersInGroup = groupService.getUsersInGroup(groupId);
        return ResponseEntity.ok(usersInGroup);
    }

    @GetMapping("/tkb/{groupId}/total-users")
    public ResponseEntity<Integer> getTotalUsersInGroup(@PathVariable Long groupId) {
        int totalUsersInGroup = groupService.getTotalUsersInGroup(groupId);
        return ResponseEntity.ok(totalUsersInGroup);
    }

}
