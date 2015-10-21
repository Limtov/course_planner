package com.andrei.api.transactionDao;

import com.andrei.entity.Student;

public interface IStudentTransactionDao extends ITransactionDao<Student> {

	public void addStudentInCourse(int idStudent, int idCourse);

	public void deleteStudentFromCourse(int idStudent);

}
