package com.bigidea.hibernate;

import java.util.List;

import com.bigidea.entity.Ideas;

public interface IdeaHibernate {

	
	public List<Ideas> getAllIdeasByUser(Integer uid);
	public void saveIdea(Ideas idea);
	public List<Ideas> getAllIdeas();
	public Ideas getIdeaByid(Integer id);
	public void deleteIdea(Ideas idea);
	

}
