package com.bigidea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bigidea.entity.Users;
import com.bigidea.hibernate.UserHibernate;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserHibernate userHibernate;

	@Transactional(propagation=Propagation.REQUIRED)
	public Users save(Users users) {
		save(users);
		return userHibernate.getUser(users.getId());
	}

	@Transactional
	public Users get(Integer id) {
		return userHibernate.getUser(id);
	}

	@Transactional
	public Users getUserByEmail(String email) {
		return userHibernate.getUser(email);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteUser(Users users) {
		deleteUser(users);

	}

}
