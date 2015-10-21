package com.andrei.transactionDao.implement;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.andrei.api.transactionDao.IStudentTransactionDao;
import com.andrei.dao.implement.StudentDaoImpl;
import com.andrei.entity.Student;
import com.andrei.transactionDao.abstractDao.AbstractTransactionDao;

public class StudentTransactionDao extends AbstractTransactionDao<Student> implements IStudentTransactionDao {
	
	private final String FETCH_MODE_COURSE = "course"; 


	private static final Logger log = Logger.getLogger(LecturerTransactionDao.class);

	StudentDaoImpl studentDao = new StudentDaoImpl();

	public StudentTransactionDao() {
		super.abstractDao = new StudentDaoImpl();
	}

	/**
	 * 
	 */
	@Override
	public List<Student> getList() {
		Session session = null;
		List<Student> students = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			students = abstractDao.findAll(session, FETCH_MODE_COURSE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return students;
	}

	/**
	 * 
	 */
	@Override
	public Student getById(int id) {
		Session session = null;
		Student student = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			student = abstractDao.findById(session, id, FETCH_MODE_COURSE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return student;
	}

	/**
	 * 
	 */
	@Override
	public void addStudentInCourse(int idStudent, int idCourse) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			studentDao.addStudentInCourse(session, idStudent, idCourse);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	/**
	 * 
	 */
	@Override
	public void deleteStudentFromCourse(int idStudent) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			studentDao.deleteStudentFromCourse(session, idStudent);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

}
