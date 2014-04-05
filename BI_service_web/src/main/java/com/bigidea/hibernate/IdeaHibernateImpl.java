package com.bigidea.hibernate;

import java.util.List;

import com.bigidea.entity.Ideas;

public class IdeaHibernateImpl extends BaseDao<Ideas, Integer> implements IdeaHibernate {
	
	@SuppressWarnings("unchecked")
	public List<Ideas> getAllIdeasByUser(Integer uid) {
		String hql = "select i from Ideas i  where i.userId = ?";
		return (List<Ideas>) find(hql, uid);
	}

}
