package com.andrei.dao.implement;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.andrei.dao.ILectureDao;
import com.andrei.dao.abstractDao.AbstractDao;
import com.andrei.entity.Course;
import com.andrei.entity.Lecture;

public class LectureDaoImpl extends AbstractDao<Lecture> implements ILectureDao {

	private final String FETCH_MODE_COURSE = "course"; 
	
	private CourseDaoImpl courseDao;

	public LectureDaoImpl() {
		super(Lecture.class);
		courseDao = new CourseDaoImpl();
	}

	/**
	 * 
	 * @param idLecture
	 * @param idCourse
	 */
	@Override
	public void addLectureInCourse(Session session, int idLecture, int idCourse) {
		Lecture lecture = super.findById(session, idLecture);
		Course course = courseDao.findById(session, idCourse);
		lecture.setCourse(course);
		super.update(session, lecture);
	}

	/**
	 * 
	 * @param idLecture
	 */
	@Override
	public void deleteLectureFromCourse(Session session, int idLecture) {
		Lecture lecture = super.findById(session, idLecture);
		lecture.setCourse(null);
		super.update(session, lecture);
	}

	/**
	 * 
	 * @param date
	 * @param idLecture
	 */
	@Override
	public void addDateInLecture(Session session, java.util.Date date, int idLecture) {
		Lecture lecture = super.findById(session, idLecture);
		lecture.setDate(date);
		super.update(session, lecture);
	}

	/**
	 * 
	 * @param idLecture
	 */
	@Override
	public void deleteDateInLecture(Session session, int idLecture) {
		Lecture lecture = super.findById(session, idLecture);
		lecture.setDate(null);
		super.update(session, lecture);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lecture> getLectureOnDate(Session session, java.util.Date date) {
		Criteria cr = session.createCriteria(Lecture.class);
		cr.setFetchMode(FETCH_MODE_COURSE, FetchMode.JOIN);
		cr.add(Restrictions.eq("date", date));
		return (List<Lecture>) cr.list();
	}

}
