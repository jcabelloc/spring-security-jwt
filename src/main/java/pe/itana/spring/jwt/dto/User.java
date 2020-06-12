package pe.itana.spring.jwt.dto;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	String username;
	
	String firstName;
	
	String lastName;
	
	String token;
	
	

	public User() {
	}

	public User(String username, String firstName, String lastName, String token) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
