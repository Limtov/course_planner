package com.andrei.transactionDao.implement;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.andrei.api.transactionDao.ICourseTransactionDao;
import com.andrei.dao.implement.CourseDaoImpl;
import com.andrei.dao.implement.LectureDaoImpl;
import com.andrei.entity.Course;
import com.andrei.entity.Lecture;
import com.andrei.transactionDao.abstractDao.AbstractTransactionDao;

public class CourseTransactionDao extends AbstractTransactionDao<Course> implements ICourseTransactionDao {
	
	private final String FETCH_MODE_LECTURER = "lecturer"; 
	private final String FETCH_MODE_LECTURE = "lectures"; 


	private static final Logger log = Logger.getLogger(CourseTransactionDao.class);

	private LectureDaoImpl lectureDao;
	private CourseDaoImpl courseDao;

	public CourseTransactionDao() {
		super.abstractDao = new CourseDaoImpl();
		this.lectureDao = new LectureDaoImpl();
		this.courseDao = new CourseDaoImpl();
	}

	public List<Course> getList() {
		Session session = null;
		List<Course> courses = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			courses = abstractDao.findAll(session, FETCH_MODE_LECTURER, FETCH_MODE_LECTURE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return courses;
	}

	@Override
	public void delete(int id) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Course course = abstractDao.findById(session, id);
			if (course.getLectures() != null) {
				for (Lecture lecture : course.getLectures()) {
					lectureDao.delete(session, lecture.getId());
				}
			}
			abstractDao.delete(session, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public Course getById(int id) {
		Course course = null;
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			course = abstractDao.findById(session, id, FETCH_MODE_LECTURER, FETCH_MODE_LECTURE);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return course;
	}

	@Override
	public void cloneCourse(int idCourse) {
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			courseDao.cloneCourse(session, idCourse);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
	}

	@Override
	public List<Course> getCoursesAfterDate(Date date) {
		Session session = null;
		List<Course> courses = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			courses = courseDao.getCoursesAfterDate(session, date);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return courses;
	}

	@Override
	public List<Course> getCoursesIntervalInPast(Date startDate, Date endDate) {
		Session session = null;
		List<Course> courses = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			courses = courseDao.getCoursesIntervalInPast(session, startDate, endDate);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return courses;
	}

	@Override
	public List<Course> getActiveCourses() {
		Session session = null;
		List<Course> courses = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			courses = courseDao.getActiveCourses(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e);
		}
		return courses;
	}

}
