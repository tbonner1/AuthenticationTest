package com.hcl.Authentication;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.hcl.model.User;

import lombok.Getter;

@Getter
public class Authentication 
{
	public static Set<User> users = new HashSet<>();
	
	public User user = null;
	
	//Authenticates the username and password 
	public Boolean login(String username, String password)
	{
		AtomicBoolean authenticated = new AtomicBoolean(false);
		
		//if the user exists in the users return true and update user
		users.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
		.findFirst().ifPresent(u -> {	authenticated.set(true); 
										user = u;});
		
		return authenticated.get();
	}
	
	public void logout()
	{
		user = null;
	}
}
