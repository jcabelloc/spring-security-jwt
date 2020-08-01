package pe.itana.spring.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserBuilder userBuilder = null;
		userBuilder = User.withUsername(username);
		String encryptedPassword = "$2a$10$970HH/81YH5.n..ZGg2l2.7X00nanFySBOxu5z0E62OuKdrMxZNjW";
		userBuilder.password(encryptedPassword).roles("GENERICO");
		return userBuilder.build();
	}
	
	/*
	 * 
	 * 
	 * 	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario;
		try {
			usuario = usuarioService.findById(username);
		} catch (NoSuchElementException e) {
			throw new UsernameNotFoundException(username);
		} 

		UserBuilder builder = null;
		builder = User.withUsername(username);
		builder.password(usuario.getClave()).roles("GENERICO");
		return builder.build();
	}
	 * 
	 * 
	 */

}
