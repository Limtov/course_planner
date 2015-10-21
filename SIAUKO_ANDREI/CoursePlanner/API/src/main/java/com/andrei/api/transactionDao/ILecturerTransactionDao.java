package com.andrei.api.transactionDao;

import com.andrei.entity.Lecturer;

public interface ILecturerTransactionDao extends ITransactionDao<Lecturer> {

	public void addLecturerInCourse(int idLecturer, int idCourse);

	public void deleteLecturerFromCourse(int idCourse);

}
