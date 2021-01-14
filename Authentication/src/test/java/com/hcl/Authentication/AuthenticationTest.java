package com.hcl.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hcl.model.User;

public class AuthenticationTest 
{
	@BeforeEach
	public void setup()
	{
		User a = new User("Admin", "password");
		User b = new User("Bill", "bill");
		
		Authentication.users.add(a);
		Authentication.users.add(b);
	}
	
	@Test
	public void loginTest()
	{
		Authentication auth = new Authentication();
		assertEquals(true, auth.login("Admin", "password"));
	}
	
	@Test
	public void badPasswordTest()
	{
		Authentication auth = new Authentication();
		assertEquals(false, auth.login("Admin", "p"));
	}
	
	@Test
	public void badUsernameTest()
	{
		Authentication auth = new Authentication();
		assertEquals(false, auth.login("Madmin", "password"));
	}
	
	@Test
	public void logoutTest()
	{
		Authentication auth = new Authentication();
		auth.login("Admin", "password");
		assertNotNull(auth.user);
		auth.logout();
		assertNull(auth.user);
	}
}
