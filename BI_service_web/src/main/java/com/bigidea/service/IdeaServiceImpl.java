package com.bigidea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bigidea.entity.Ideas;
import com.bigidea.entity.Users;
import com.bigidea.hibernate.IdeaHibernate;

@Service
public class IdeaServiceImpl implements IdeaService {
	
	@Autowired
	public IdeaHibernate ideaHibernate;

	@Transactional(propagation=Propagation.SUPPORTS)
	public Ideas getIdea(Integer id) {
		return ideaHibernate.getIdeaByid(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Ideas saveIdeas(Ideas ideas) {
		ideaHibernate.saveIdea(ideas);
		return ideaHibernate.getIdeaByid(ideas.getId());
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteIdea(Ideas ideas) {
		ideaHibernate.deleteIdea(ideas);

	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Ideas> getIdeasByUser(Users users) {
	
		return ideaHibernate.getAllIdeasByUser(users.getId());
		
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Ideas> getAllIdeas() {
		return ideaHibernate.getAllIdeas();
	}

}
