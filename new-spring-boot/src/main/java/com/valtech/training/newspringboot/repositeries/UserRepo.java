package com.valtech.training.newspringboot.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.valtech.training.newspringboot.entity.User;

 @Repository
public interface UserRepo  extends JpaRepository<User, Long>{

 	User findByUsername(String username);
	
	

}
