package com.andrei.api;

import java.sql.SQLException;
import java.text.ParseException;

public interface IManager {
		
	public String addCourseInCourseInformation(String string) throws ParseException, SQLException;
	public String deleteCourseFromCourseInformation(String string) throws SQLException;
	public String showCourse(String string) throws SQLException;
	public String showListCourses() throws SQLException;
	public String cloneCourse(String string) throws SQLException;
	
	public String addLectureInCourse(String string) throws SQLException;
 	public String deleteLectureFromCourse(String string) throws SQLException;
 	public String addLectureInCourseInformation(String string) throws ParseException, SQLException;
 	public String addDateInLecture(String string) throws ParseException, SQLException;
 	public String deleteDateFromLecture(String string) throws SQLException;
 	public String showLecture(String string) throws SQLException;
	public String showListLectures() throws SQLException;
	
	public String addLecturerInCourse(String string) throws SQLException;
 	public String deleteLecturerFromCourse(String string) throws SQLException;
 	public String addLecturerInCourseInformation(String string) throws SQLException;
 	public String showLecturer(String string) throws SQLException;
	public String showListLecturers() throws SQLException;
	
	public String addStudentInCourse(String string) throws SQLException;
 	public String deleteStudentFromCourse(String string) throws SQLException;
 	public String addStudentInCourseInformation(String string) throws SQLException;
 	public String showStudent(String string) throws SQLException;
	public String showListStudents() throws SQLException;
	
	public String sortLecturersByName();
	
	public String sortLecturesByName();
	public String sortLecturesByDate();
	
	public String sortCourseByName();
	public String sortCourseBySection();
	public String sortCourseByStartDate();
	public String sortCourseByLecturer();
	
	public String getActiveCourses() throws SQLException;
	public String getCoursesAfterDate(String string) throws ParseException, SQLException;
	public String getCoursesIntervalInPast(String string) throws ParseException, SQLException;
	
	public String getLecturesOnDate(String string) throws ParseException, SQLException;

	

}
