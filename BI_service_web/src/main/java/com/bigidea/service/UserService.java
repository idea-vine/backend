package com.bigidea.service;

import com.bigidea.entity.Users;

public interface UserService {
	
	public Users save (Users users);
	
	public Users get (Integer id);
	
	public Users getUserByEmail (String email);
	
	public void deleteUser(Users users);

}
