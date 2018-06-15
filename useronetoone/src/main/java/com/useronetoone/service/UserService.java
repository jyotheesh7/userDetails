package com.useronetoone.service;

import com.useronetoone.exception.UserNotFoundException;
import com.useronetoone.model.UserDetailsDTO;

/**
 * @author jyotheesh.b
 *
 */
public interface UserService {
	
	public UserDetailsDTO addUser(UserDetailsDTO userDetails);

	public UserDetailsDTO getUser(Integer id) throws UserNotFoundException;
	
	public UserDetailsDTO updateUser(UserDetailsDTO userDetails) throws UserNotFoundException;
	
	public Boolean deleteUser(Integer id) throws UserNotFoundException;
}
