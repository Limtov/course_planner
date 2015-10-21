package com.andrei.api.transactionDao;

import java.util.Date;
import java.util.List;

import com.andrei.entity.Course;

public interface ICourseTransactionDao extends ITransactionDao<Course> {

	public void cloneCourse(int idCourse);

	public List<Course> getCoursesAfterDate(Date date);

	public List<Course> getCoursesIntervalInPast(Date startDate, Date endDate);

	public List<Course> getActiveCourses();

	/* public int getNumberOfStudentsInCourse(int idCourse); */

}
