package com.andrei.transactionDao.implement;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.andrei.api.transactionDao.ILectureTransactionDao;
import com.andrei.dao.implement.LectureDaoImpl;
import com.andrei.entity.Lecture;
import com.andrei.transactionDao.abstractDao.AbstractTransactionDao;

public class LectureTransactionDao extends AbstractTransactionDao<Lecture> implements ILectureTransactionDao {
	
	private final String FETCH_MODE_COURSE = "course"; 

	private static final Logger log = Logger.getLogger(LecturerTransactionDao.class);

	private LectureDaoImpl lectureDao;

	public LectureTransactionDao() {
		super.abstractDao = new LectureDaoImpl();
		this.lectureDao = new LectureDaoImpl();
	}

	@Override
	public List<Lecture> getList() {
		Session session = null;
		List<Lecture> lectures = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lectures = abstractDao.findAll(session, FETCH_MODE_COURSE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return lectures;
	}

	@Override
	public Lecture getById(int id) {
		Session session = null;
		Lecture lecture = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lecture = abstractDao.findById(session, id, FETCH_MODE_COURSE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return lecture;
	}

	@Override
	public void addLectureInCourse(int idLecture, int idCourse) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lectureDao.addLectureInCourse(session, idLecture, idCourse);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public void deleteLectureFromCourse(int idLecture) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lectureDao.deleteLectureFromCourse(session, idLecture);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public void addDateInLecture(Date date, int idLecture) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lectureDao.addDateInLecture(session, date, idLecture);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public void deleteDateInLecture(int idLecture) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lectureDao.deleteDateInLecture(session, idLecture);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public List<Lecture> getLectureOnDate(Date date) {
		Session session = null;
		List<Lecture> lectures = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			lectures = lectureDao.getLectureOnDate(session, date);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return lectures;
	}

}
