package com.useronetoone.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.useronetoone.model.UserDetailsDTO;
import com.useronetoone.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateUser(){
		UserDetailsDTO userDetails = new UserDetailsDTO();
		Mockito.when(this.userService.addUser(userDetails)).thenReturn(userDetails);
		this.userController.addUser(userDetails);
	}
	
	@After
	public void tearDown(){
		this.userController = null;
	}

}
