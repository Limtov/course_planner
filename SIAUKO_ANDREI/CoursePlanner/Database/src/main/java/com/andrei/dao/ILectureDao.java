package com.andrei.dao;

import java.util.List;

import org.hibernate.Session;

import com.andrei.entity.Lecture;

public interface ILectureDao extends IDao<Lecture> {

	public void addLectureInCourse(Session session, int idLecture, int idCourse);

	public void deleteLectureFromCourse(Session session, int idLecture);

	public void addDateInLecture(Session session, java.util.Date date, int idLecture);

	public void deleteDateInLecture(Session session, int idLecture);

	public List<Lecture> getLectureOnDate(Session session, java.util.Date date);

/*	public int getNumberOfStudentOnDay(Session session, java.util.Date date);

	public int getCourseNumber(Session session, int idLecture);*/
}
