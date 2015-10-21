package com.andrei.dao;

import org.hibernate.Session;

import com.andrei.entity.Lecturer;

public interface ILecturerDao extends IDao<Lecturer> {

	public void addLecturerInCourse(Session session, int idLecturer, int idCourse);

	public void deleteLecturerFromCourse(Session session, int idCourse);
}
