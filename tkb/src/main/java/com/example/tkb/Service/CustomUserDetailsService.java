package com.example.tkb.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tkb.Entity.User;
import com.example.tkb.Repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("Username is not valid");
        }
        
        // Check if the user's roles are null or empty
        Set<SimpleGrantedAuthority> authorities;
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            authorities = getAuthorities(user);
        } else {
            // If the user does not have any roles, provide default authority
            authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return new org.springframework.security.core.userdetails.User(
            user.getUserName(), 
            user.getUserPassword(), 
            authorities
        );
    }

    public Set<SimpleGrantedAuthority> getAuthorities(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        if (user.getRoles() != null) {
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            });
        }
        return authorities;
    }


}


