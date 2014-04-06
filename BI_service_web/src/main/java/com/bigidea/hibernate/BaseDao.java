package com.bigidea.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.SessionFactoryUtils;


public class BaseDao<T, PK extends Serializable> {

	private SessionFactory sessionFactory;

	public void delete(T persistentObject) {
		getSession().delete(persistentObject);
		getSession().flush();
	}

	public void save(T persistentObject) {
		getSession().saveOrUpdate(persistentObject);
		getSession().flush();
	}

	@SuppressWarnings("unchecked")
	public T find(Class<T> klass, PK id) {
		T o = (T) sessionFactory.getCurrentSession().get(klass, id);
		return o;
	}

	@SuppressWarnings("unchecked")
	public List<T> loadAll(Class<T> klass) {
		Criteria criteria = getCriteria(klass);
		//prepareCriteria(criteria);
		return criteria.list();
	}

	public List<?> find(String queryString, Object value) {
		Object[] values = null;
		if (value != null) {
			values = new Object[] { value };
		}
		return find(queryString, values);
	}

	public List<?> find(String queryString, Object[] values) {
		return find(queryString, values, true);
	}

	public List<?> find(final String queryString, final Object[] values,
			boolean isDistinct) throws DataAccessException {
		Query queryObject = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}

		if (isDistinct) {
			queryObject.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		}
		return queryObject.list();
	}

	public Criteria getCriteria(Class<?> klass) {
		return getSession().createCriteria(klass);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//	protected void prepareCriteria(Criteria criteria) {
//		SessionFactoryUtils.(criteria, sessionFactory);
//	}

}
