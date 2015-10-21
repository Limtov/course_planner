package com.andrei.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.andrei.dao.ICourseDao;
import com.andrei.dao.abstractDao.AbstractDao;
import com.andrei.entity.Course;
import com.andrei.entity.Lecture;
import com.andrei.entity.Student;

public class CourseDaoImpl extends AbstractDao<Course> implements ICourseDao {

	private final String FETCH_MODE_LECRURER = "lecrurer";
	private final String FETCH_MODE_LECTURE = "lectures";

	public CourseDaoImpl() {
		super(Course.class);
	}

	/**
	 * 
	 * @param idCourse
	 */
	@Override
	public void cloneCourse(Session session, int idCourse) {
		Course course = super.findById(session, idCourse);
		session.evict(course);
		course.setId(0);
		course.setLecturer(null);
		course.setLectures(new ArrayList<Lecture>());
		course.setStudents(new ArrayList<Student>());
		super.insert(session, course);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCoursesAfterDate(Session session, Date date) {
		Criteria cr = session.createCriteria(Course.class);
		cr.setFetchMode(FETCH_MODE_LECRURER, FetchMode.JOIN);
		cr.setFetchMode(FETCH_MODE_LECTURE, FetchMode.JOIN);
		cr.add(Restrictions.ge("startDate", date));
		return (List<Course>) cr.list();
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCoursesIntervalInPast(Session session, Date startDate, Date endDate) {
		Criteria cr = session.createCriteria(Course.class);
		cr.setFetchMode(FETCH_MODE_LECRURER, FetchMode.JOIN);
		cr.setFetchMode(FETCH_MODE_LECTURE, FetchMode.JOIN);
		cr.add(Restrictions.ge("startDate", startDate));
		cr.add(Restrictions.le("endDate", endDate));
		return (List<Course>) cr.list();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getActiveCourses(Session session) {
		Criteria cr = session.createCriteria(Course.class);
		cr.setFetchMode(FETCH_MODE_LECRURER, FetchMode.JOIN);
		cr.setFetchMode(FETCH_MODE_LECTURE, FetchMode.JOIN);
		cr.add(Restrictions.ge("startDate", new Date()));
		cr.add(Restrictions.le("endDate", new Date()));
		return (List<Course>) cr.list();
	}

}
