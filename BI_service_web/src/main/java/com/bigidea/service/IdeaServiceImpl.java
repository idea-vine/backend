package com.bigidea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bigidea.entity.Ideas;
import com.bigidea.entity.Users;
import com.bigidea.hibernate.IdeaHibernate;

@Service(value="ideaService")
public class IdeaServiceImpl implements IdeaService {
	
	@Autowired
	public IdeaHibernate ideaHibernate;

	@Transactional
	public Ideas getIdea(Integer id) {
		return ideaHibernate.getIdeaByid(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Ideas saveIdeas(Ideas ideas) {
		ideaHibernate.saveIdea(ideas);
		return ideas;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteIdea(Ideas ideas) {
		ideaHibernate.deleteIdea(ideas);

	}

	@Transactional
	public List<Ideas> getIdeasByUser(Users users) {
	
		return ideaHibernate.getAllIdeasByUser(users.getId());
		
	}

	@Transactional
	public List<Ideas> getAllIdeas() {
		return ideaHibernate.getAllIdeas();
	}

}
