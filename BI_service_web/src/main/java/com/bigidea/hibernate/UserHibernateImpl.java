package com.bigidea.hibernate;

import org.springframework.stereotype.Repository;

import com.bigidea.entity.Users;

@Repository
public class UserHibernateImpl extends BaseDao<Users, Integer>  implements UserHibernate{

	
	public Users getUser(String email) {
		String hql = "select u from Users u  where u.email = ?";
		return (Users)getSession().createQuery(hql).setParameter(0, email).uniqueResult();
	}
	
}
