package com.andrei.dao.implement;

import org.hibernate.Session;

import com.andrei.dao.ILecturerDao;
import com.andrei.dao.abstractDao.AbstractDao;
import com.andrei.entity.Course;
import com.andrei.entity.Lecturer;

public class LecturerDaoImpl extends AbstractDao<Lecturer> implements ILecturerDao {

	CourseDaoImpl courseDao = new CourseDaoImpl();

	public LecturerDaoImpl() {
		super(Lecturer.class);
	}

	@Override
	public void addLecturerInCourse(Session session, int idLecturer, int idCourse) {
		Lecturer lecturer = super.findById(session, idLecturer);
		Course course = courseDao.findById(session, idCourse);
		lecturer.getCourses().add(course);
		super.update(session, lecturer);
	}

	@Override
	public void deleteLecturerFromCourse(Session session, int idCourse) {
		Course course = courseDao.findById(session, idCourse);
		course.setLecturer(null);
		courseDao.update(session, course);
	}

}
