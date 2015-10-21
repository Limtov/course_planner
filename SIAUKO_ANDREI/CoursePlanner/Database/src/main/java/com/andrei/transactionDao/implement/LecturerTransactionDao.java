package com.andrei.transactionDao.implement;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.andrei.api.transactionDao.ILecturerTransactionDao;
import com.andrei.dao.implement.LecturerDaoImpl;
import com.andrei.entity.Lecturer;
import com.andrei.transactionDao.abstractDao.AbstractTransactionDao;

public class LecturerTransactionDao extends AbstractTransactionDao<Lecturer> implements ILecturerTransactionDao {
	
	private final String FETCH_MODE_COURSE = "course"; 

	private static final Logger log = Logger.getLogger(LecturerTransactionDao.class);

	private LecturerDaoImpl lecturerDao;

	public LecturerTransactionDao() {
		super.abstractDao = new LecturerDaoImpl();
		this.lecturerDao = new LecturerDaoImpl();
	}

	@Override
	public List<Lecturer> getList() {
		Session session = null;
		List<Lecturer> lecturers = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lecturers = abstractDao.findAll(session, FETCH_MODE_COURSE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return lecturers;
	}

	@Override
	public Lecturer getById(int id) {
		Session session = null;
		Lecturer lecturer = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lecturer = abstractDao.findById(session, id, FETCH_MODE_COURSE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return lecturer;
	}

	@Override
	public void addLecturerInCourse(int idLecturer, int idCourse) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lecturerDao.addLecturerInCourse(session, idLecturer, idCourse);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public void deleteLecturerFromCourse(int idCourse) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lecturerDao.deleteLecturerFromCourse(session, idCourse);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

}
