package com.bigidea.hibernate;

import com.bigidea.entity.Users;

public interface UserHibernate {
	
	public Users getUser(String email) ;
	
	public void save (Users users);
	
	public Users getUser (Integer id);
	
	public void deleteUser (Users users);

}
