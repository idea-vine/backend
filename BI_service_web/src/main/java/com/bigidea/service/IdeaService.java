package com.bigidea.service;

import java.util.List;

import com.bigidea.entity.Ideas;
import com.bigidea.entity.Users;

public interface IdeaService {
	
	public Ideas getIdea(Integer id);
	
	public Ideas saveIdeas (Ideas ideas);
	
	public void deleteIdea (Ideas ideas);
	
	public List<Ideas>  getIdeasByUser (Users users);
	
	public List<Ideas>  getAllIdeas();

}
