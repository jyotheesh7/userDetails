package com.useronetoone.model;

import java.sql.Date;
import java.util.List;

public class UserDetailsDTO {
	
	private Integer id;

	private String firstName;

	private String lastName;

	private String occupation;

	private Date dateOfBirth;

	private Integer age;

    private List<UserAddressDto> userAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<UserAddressDto> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddressDto> userAddress) {
		this.userAddress = userAddress;
	}
    
    
    


}
