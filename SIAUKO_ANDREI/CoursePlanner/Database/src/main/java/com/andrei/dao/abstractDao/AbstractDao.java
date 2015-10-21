package com.andrei.dao.abstractDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.andrei.dao.IDao;

public abstract class AbstractDao<T> implements IDao<T> {

	protected String sortBy = null;

	private Class<?> entityClass;

	public AbstractDao(Class<?> entity) {
		this.entityClass = entity;
	}

	public void setSortBy(final String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * 
	 */
	@Override
	public void insert(Session session, T entity) {
		session.save(entity);
	}

	/**
	 * 
	 */
	@Override
	public void update(Session session, T entity) {
		session.update(entity);
	}

	/**
	 * 
	 */
	@Override
	public void delete(Session session, int id) {
		session.delete(this.findById(session, id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Session session, int id, String... fetchModes) {
		Criteria cr = session.createCriteria(entityClass);
		cr.add(Restrictions.eq("id", id));
		if (fetchModes != null && fetchModes.length >= 1) {
			for (String fetchMode : fetchModes) {
				cr.setFetchMode(fetchMode, FetchMode.JOIN);
			}
		}
		return (T) cr.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Session session, String... fetchModes) {
		Criteria cr = session.createCriteria(entityClass);
		if (fetchModes != null && fetchModes.length >= 1) {
			for (String fetchMode : fetchModes) {
				cr.setFetchMode(fetchMode, FetchMode.JOIN);
			}
		}
		if (sortBy != null && !sortBy.isEmpty()) {
			cr.addOrder(Order.asc(sortBy));
		}
		return (List<T>) cr.list();
	}

}
