package com.useronetoone.exception;

/**
 * @author jyotheesh.b
 *
 */
public class UserNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message){
		super(message);
	}

}
