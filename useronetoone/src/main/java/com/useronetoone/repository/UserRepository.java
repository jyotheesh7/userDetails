package com.useronetoone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.useronetoone.model.UserDetails;
@Repository
public interface UserRepository extends CrudRepository<UserDetails,Integer>{

}
