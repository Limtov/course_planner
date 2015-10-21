package com.andrei.api.transactionDao;

import java.util.List;

import com.andrei.entity.Lecture;

public interface ILectureTransactionDao extends ITransactionDao<Lecture> {

	public void addLectureInCourse(int idLecture, int idCourse);

	public void deleteLectureFromCourse(int idLecture);

	public void addDateInLecture(java.util.Date date, int idLecture);

	public void deleteDateInLecture(int idLecture);

	public List<Lecture> getLectureOnDate(java.util.Date date);

/*	public int getNumberOfStudentOnDay(java.util.Date date);

	public int getCourseNumber(int idLecture);*/

}
