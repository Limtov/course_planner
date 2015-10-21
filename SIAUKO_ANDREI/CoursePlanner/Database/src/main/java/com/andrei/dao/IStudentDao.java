package com.andrei.dao;

import org.hibernate.Session;

import com.andrei.entity.Student;

public interface IStudentDao extends IDao<Student> {

	public void addStudentInCourse(Session session, int idStudent, int idCourse);

	public void deleteStudentFromCourse(Session session, int idStudent);

}
