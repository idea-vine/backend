package com.bigidea.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigidea.entity.Ideas;

@Repository
public class IdeaHibernateImpl extends BaseDao<Ideas, Integer> implements IdeaHibernate {
	
	@SuppressWarnings("unchecked")
	public List<Ideas> getAllIdeasByUser(Integer uid) {
		String hql = "select i from Ideas i  where i.userId = ?";
		return (List<Ideas>) find(hql, uid);
	}

	
	public void saveIdea(Ideas idea) {
		save(idea);
	}
	

	public List<Ideas> getAllIdeas() {
		return loadAll(Ideas.class);
	}


	public Ideas getIdeaByid(Integer id) {
		return find(Ideas.class, id);
	}


	public void deleteIdea(Ideas idea) {
		delete(idea);
	}




}
