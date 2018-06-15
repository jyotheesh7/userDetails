package com.useronetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.useronetoone.model.UserDetailsDTO;
import com.useronetoone.service.UserService;

@RestController
@RequestMapping(value="/useroperations")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	@RequestMapping(value="/createUser")
	public ResponseEntity<?> addUser(@RequestBody UserDetailsDTO userDetails){
		
		UserDetailsDTO result = userService.addUser(userDetails);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
		
	}
	
	@GetMapping
	@RequestMapping(value="/getUsers/{id}")
	public ResponseEntity<UserDetailsDTO> getUsers(@PathVariable(name="id") Integer id){
		
		 UserDetailsDTO userDetailsDTO = userService.getUser(id);
		
			return new ResponseEntity<>(userDetailsDTO, HttpStatus.OK);
		
		
	}
	
	@PutMapping
	@RequestMapping(value="/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UserDetailsDTO userDetails){
		
		
		if(null != userDetails.getId()){
		UserDetailsDTO result = userService.updateUser(userDetails);
		if(null != result){
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
		}
		
		}else{
			return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping
	@RequestMapping(value="/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(name="id") Integer id){
		
		
		if(null != id){
		Boolean result = userService.deleteUser(id);
		if(result){
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
		}
		
		}else{
			return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
		}
		
	}

}
