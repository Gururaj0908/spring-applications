
	package com.example.coworkspace.Service;

	import java.util.Set;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.authentication.BadCredentialsException;
	import org.springframework.security.authentication.DisabledException;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.authority.SimpleGrantedAuthority;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.stereotype.Service;

	import com.example.coworkspace.Config.JwtUtil;
	import com.example.coworkspace.Entity.User;
	import com.example.coworkspace.Model.JwtRequest;
	import com.example.coworkspace.Model.JwtResponse;
	import com.example.coworkspace.Repository.UserRepository;

	@Service
	public class JwtService implements UserDetailsService{

	    @Autowired
	    private UserRepository userReop;
	    
	    @Autowired
	    private JwtUtil jwtUtil;
	    
	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private CustomUserDetailsService customUserDetailsService;
	    
	    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
	        String userName = jwtRequest.getUserName();
	        String userPassword = jwtRequest.getUserPassword();
	        authenticate(userName, userPassword);
	        final UserDetails userDetails = loadUserByUsername(userName);
	        String newGeneratedToken = jwtUtil.generateToken(userDetails);
	        User user = userReop.findById(userName).get();
	        return new JwtResponse(user, newGeneratedToken);
	    }
	    
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userReop.findById(username).orElse(null);
	        if (user == null) {
	            throw new UsernameNotFoundException("Username is not valid");
	        }
	        
	        // Delegate to CustomUserDetailsService to get authorities
	        Set<SimpleGrantedAuthority> authorities = customUserDetailsService.getAuthorities(user);
	        
	        return new org.springframework.security.core.userdetails.User(
	            user.getUserName(), 
	            user.getUserPassword(), 
	            authorities
	        );
	    }
	    
	    private void authenticate(String userName, String userPassword) throws Exception{
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
	        } catch (DisabledException e) {
	            throw new Exception("User is disabled");
	        } catch(BadCredentialsException e) {
	            throw new Exception("Bad credentials from user");
	        }
	    }
	    
	}


