package com.bigidea.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bigidea.entity.Users;
import com.bigidea.hibernate.UserHibernate;

public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserHibernate userHibernate;

	public Users save(Users users) {
		save(users);
		return userHibernate.getUser(users.getId());
	}

	public Users get(Integer id) {
		return userHibernate.getUser(id);
	}

	public Users getUserByEmail(String email) {
		return userHibernate.getUser(email);
	}

	public void deleteUser(Users users) {
		deleteUser(users);

	}

}
