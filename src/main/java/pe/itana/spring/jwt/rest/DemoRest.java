package pe.itana.spring.jwt.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.itana.spring.jwt.dto.AuthenticationRequest;
import pe.itana.spring.jwt.dto.AuthenticationResponse;
import pe.itana.spring.jwt.service.JwtUtilService;
import pe.itana.spring.jwt.service.MyUserDetailsService;

@RestController
public class DemoRest {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtilService jwtUtilService;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	
	
	@GetMapping("/message")
	public String getMessage(Principal principal) {
		System.out.println(principal.getName());
		/* SecurityContextHolder: By default the SecurityContextHolder uses a ThreadLocal to store these details, 
		 * which means that the SecurityContext is always available to methods in the same thread of execution,
		*/
		SecurityContext context = SecurityContextHolder.getContext();
		
		/*
		 * Authentication: Represents the currently authenticated user
		 * The Authentication contains:
		 * principal - identifies the user. When authenticating with a username/password this is often an instance of UserDetails.
		 * credentials - Often a password. In many cases this will be cleared after the user is authenticated to ensure it is not leaked.
		 * authorities - the GrantedAuthoritys are high level permissions the user is granted. A few examples are roles or scopes.
		 */

		Authentication authentication = context.getAuthentication();
		String username = authentication.getName();
		System.out.println("username: " + username);
		
		return "Hello World";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Invalid username or password", e);
		}


		final UserDetails userDetails = myUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtUtilService.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
