package com.useronetoone.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.useronetoone.mapper.UserRecordMapper;
import com.useronetoone.model.UserAddress;
import com.useronetoone.model.UserDetails;
import com.useronetoone.model.UserDetailsDTO;
import com.useronetoone.repository.UserAddressRepository;
import com.useronetoone.repository.UserRepository;
import com.useronetoone.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserAddressRepository userAddressRepository;

	@Autowired
	private UserRecordMapper userRecordMapper;

	@Override
	public UserDetailsDTO addUser(UserDetailsDTO userDetailsDto) {

		UserDetails userDetails = this.userRecordMapper
				.userDetailsDTOToUserDetails(userDetailsDto);

		List<UserAddress> userAddresslist1 = new ArrayList<UserAddress>();

		for (UserAddress userAddresslist : userDetails.getUserAddress()) {
			UserAddress userAddress = new UserAddress();
			userAddress.setUserDetailsId(userDetails);
			userAddress.setAddressLine1(userAddresslist.getAddressLine1());
			userAddress.setAddressLine2(userAddresslist.getAddressLine2());
			userAddress.setCity(userAddresslist.getCity());
			userAddress.setCountry(userAddresslist.getCountry());
			userAddress.setPincode(userAddresslist.getPincode());
			userAddress.setState(userAddresslist.getState());

			userAddresslist1.add(userAddress);

		}
		userDetails.setUserAddress(userAddresslist1);
		UserDetails userDetailsResult = userRepository.save(userDetails);

		return this.userRecordMapper
				.userCustomerRecordToCustomerRecordDto(userDetailsResult);

	}

	@Override
	public UserDetailsDTO getUser(Integer id) {

		Optional<UserDetails> userDetailsResult = userRepository.findById(id);

		if (userDetailsResult.isPresent()) {
			return this.userRecordMapper
					.userCustomerRecordToCustomerRecordDto(userDetailsResult
							.get());
		} else {

			return null;
		}

	}

	@Override
	public UserDetailsDTO updateUser(UserDetailsDTO userDetailsDto) {

		UserDetails userDetails = this.userRecordMapper
				.userDetailsDTOToUserDetails(userDetailsDto);

		List<UserAddress> userAddresslist1 = new ArrayList<UserAddress>();

		for (UserAddress userAddresslist : userDetails.getUserAddress()) {
			UserAddress userAddress = new UserAddress();
			userAddress.setUserDetailsId(userDetails);
			userAddress.setAddressLine1(userAddresslist.getAddressLine1());
			userAddress.setAddressLine2(userAddresslist.getAddressLine2());
			userAddress.setCity(userAddresslist.getCity());
			userAddress.setCountry(userAddresslist.getCountry());
			userAddress.setPincode(userAddresslist.getPincode());
			userAddress.setState(userAddresslist.getState());

			userAddresslist1.add(userAddress);

		}
		userDetails.setUserAddress(userAddresslist1);
		if (userRepository.existsById(userDetails.getId())) {

			UserDetails userDetailsResult = userRepository.save(userDetails);

			return this.userRecordMapper
					.userCustomerRecordToCustomerRecordDto(userDetailsResult);

		}
		return null;
	}

	@Override
	public Boolean deleteUser(Integer id) {
		try {
			userRepository.deleteById(id);

			return true;
		} catch (Exception e) {

			return false;
		}

	}

}
