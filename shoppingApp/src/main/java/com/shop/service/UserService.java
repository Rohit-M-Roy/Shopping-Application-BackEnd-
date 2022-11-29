package com.shop.service;

import com.shop.enums.UserRole;
import com.shop.model.User;

public interface UserService {
	
	public User addUser(User user);
	public User deleteUser(String email);
	public User viewAllUsers();
	public User viewUserByRole(UserRole role);

}
