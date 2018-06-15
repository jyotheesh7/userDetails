package com.useronetoone.service;

import com.useronetoone.model.UserDetailsDTO;

/**
 * @author jyotheesh.b
 *
 */
public interface UserService {
	
	public UserDetailsDTO addUser(UserDetailsDTO userDetails);

	public UserDetailsDTO getUser(Integer id);
	
	public UserDetailsDTO updateUser(UserDetailsDTO userDetails);
	
	public Boolean deleteUser(Integer id);
}
