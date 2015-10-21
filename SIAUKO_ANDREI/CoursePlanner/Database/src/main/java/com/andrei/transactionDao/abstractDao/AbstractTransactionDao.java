package com.andrei.transactionDao.abstractDao;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.andrei.api.transactionDao.ITransactionDao;
import com.andrei.connection.HibernateUtil;
import com.andrei.dao.abstractDao.AbstractDao;
import com.andrei.transactionDao.implement.LecturerTransactionDao;

public abstract class AbstractTransactionDao<T> implements ITransactionDao<T> {

	private static final Logger log = Logger.getLogger(LecturerTransactionDao.class);

	protected AbstractDao<T> abstractDao;
	protected HibernateUtil hibernateUtil;

	public AbstractTransactionDao() {
		hibernateUtil = HibernateUtil.getInstance();
	}

	@Override
	public void add(T entity) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			abstractDao.insert(session, entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public void update(T entity) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			abstractDao.update(session, entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public void delete(int id) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			abstractDao.delete(session, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public void setSortBy(String sortBy) {
		try {
			abstractDao.setSortBy(sortBy);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
