package com.andrei.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.andrei.entity.Course;

public interface ICourseDao extends IDao<Course> {

	public void cloneCourse(Session session, int idCourse);

	public List<Course> getCoursesAfterDate(Session session, Date date);

	public List<Course> getCoursesIntervalInPast(Session session, Date startDate, Date endDate);

	public List<Course> getActiveCourses(Session session);

	/* public int getNumberOfStudentsInCourse(Session session, int idCourse); */
}
