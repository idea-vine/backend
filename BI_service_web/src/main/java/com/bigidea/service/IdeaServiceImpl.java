package com.bigidea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bigidea.entity.Ideas;
import com.bigidea.entity.Users;
import com.bigidea.hibernate.IdeaHibernate;

public class IdeaServiceImpl implements IdeaService {
	
	@Autowired
	public IdeaHibernate ideaHibernate;

	public Ideas getIdea(Integer id) {
		return ideaHibernate.getIdeaByid(id);
	}

	public Ideas saveIdeas(Ideas ideas) {
		ideaHibernate.saveIdea(ideas);
		return ideaHibernate.getIdeaByid(ideas.getId());
	}

	public void deleteIdea(Ideas ideas) {
		ideaHibernate.deleteIdea(ideas);

	}

	public List<Ideas> getIdeasByUser(Users users) {
	
		return ideaHibernate.getAllIdeasByUser(users.getId());
		
	}

	public List<Ideas> getAllIdeas() {
		return ideaHibernate.getAllIdeas();
	}

}
