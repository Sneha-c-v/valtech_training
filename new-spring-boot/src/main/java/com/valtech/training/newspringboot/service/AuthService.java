package com.valtech.training.newspringboot.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.valtech.training.newspringboot.entity.User;
import com.valtech.training.newspringboot.model.ChangePasswordModel;
import com.valtech.training.newspringboot.model.RegisterUserModel;

public interface AuthService {

	User createUser(RegisterUserModel regUserModel);

	boolean changePassword(ChangePasswordModel passwordModel);

	void upgradeUserToAdmin(long id);

	void enableUser(long id);

	void disableUser(long id);

	Collection<? extends GrantedAuthority> getAuthorities();

	String getPassword();

	String getUsername();

	boolean isAccountNonExpired();

	boolean isAccountNonLocked();

	boolean isCredentialsNonExpired();

	boolean isEnabled();

}