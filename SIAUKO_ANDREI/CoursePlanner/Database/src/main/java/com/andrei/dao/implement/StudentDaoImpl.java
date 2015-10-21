package com.andrei.dao.implement;

import org.hibernate.Session;

import com.andrei.dao.IStudentDao;
import com.andrei.dao.abstractDao.AbstractDao;
import com.andrei.entity.Course;
import com.andrei.entity.Student;

public class StudentDaoImpl extends AbstractDao<Student> implements IStudentDao {

	CourseDaoImpl courseDao = new CourseDaoImpl();

	public StudentDaoImpl() {
		super(Student.class);
	}

	/**
	 * 
	 * @param idStudent
	 * @param idCourse
	 */
	@Override
	public void addStudentInCourse(Session session, int idStudent, int idCourse) {
		Student student = super.findById(session, idStudent);
		Course course = courseDao.findById(session, idCourse);
		student.setCourse(course);
		super.update(session, student);
	}

	/**
	 * 
	 * @param idStudent
	 */
	@Override
	public void deleteStudentFromCourse(Session session, int idStudent) {
		Student student = super.findById(session, idStudent);
		student.setCourse(null);
		super.update(session, student);
	}

}
