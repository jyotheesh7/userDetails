package com.useronetoone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.useronetoone.model.UserDetails;
import com.useronetoone.model.UserDetailsDTO;

@Mapper(componentModel="spring",nullValueCheckStrategy=NullValueCheckStrategy.ALWAYS)
public interface UserRecordMapper {
	

	
	UserDetailsDTO userCustomerRecordToCustomerRecordDto(UserDetails userCustomerRecord);
	
	UserDetails userDetailsDTOToUserDetails(UserDetailsDTO userDetailsDTO);

}
