package com.andrei.manager;

import java.text.ParseException;
import java.util.Date;

import com.andrei.DependencyInjectionUtility;
import com.andrei.Parser;
import com.andrei.api.IManager;
import com.andrei.api.IOperations;
import com.andrei.api.transactionDao.ICourseTransactionDao;
import com.andrei.api.transactionDao.ILectureTransactionDao;
import com.andrei.api.transactionDao.ILecturerTransactionDao;
import com.andrei.api.transactionDao.IStudentTransactionDao;

public class Manager implements IManager {

	private final Parser parser;
	private final IOperations operations;
	private final ICourseTransactionDao courseService;
	private final ILecturerTransactionDao lecturerService;
	private final ILectureTransactionDao lectureService;
	private final IStudentTransactionDao studentService;

	public Manager() {
		this.parser = new Parser();
		this.operations = (IOperations) DependencyInjectionUtility.getObjectByInterface(IOperations.class);
		this.courseService = (ICourseTransactionDao) DependencyInjectionUtility.getObjectByInterface(ICourseTransactionDao.class);
		this.lecturerService = (ILecturerTransactionDao) DependencyInjectionUtility.getObjectByInterface(ILecturerTransactionDao.class);
		this.lectureService = (ILectureTransactionDao) DependencyInjectionUtility.getObjectByInterface(ILectureTransactionDao.class);
		this.studentService = (IStudentTransactionDao) DependencyInjectionUtility.getObjectByInterface(IStudentTransactionDao.class);
	}

	/**
	 * 
	 */
	@Override
	public String showListCourses() {
		return operations.listToString(courseService.getList());
	}

	/**
	 * 
	 */
	@Override
	public String showListLecturers() {
		return operations.listToString(lecturerService.getList());
	}

	/**
	 * 
	 */
	@Override
	public String showListLectures() {
		return operations.listToString(lectureService.getList());
	}

	/**
	 * 
	 */
	@Override
	public String showListStudents() {
		return operations.listToString(studentService.getList());
	}

	/**
	 * 
	 */
	@Override
	public synchronized String addCourseInCourseInformation(String stringCourse) throws ParseException {
		courseService.add(parser.parseStringToCourse(stringCourse));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String deleteCourseFromCourseInformation(String stringIdCourse) {
		courseService.delete(parser.parseToInt(stringIdCourse));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public String showCourse(String idCourse) {
		return operations.objectToString(courseService.getById(parser.parseToInt(idCourse)));
	}

	// when you add lecture in a course should not exceed the limit of students
	// on the day. не сделано
	/**
	 * 
	 */
	@Override
	public synchronized String addLectureInCourse(String string) {
		String[] mass = parser.split(string);
		int idLecture = parser.parseToInt(mass[0]);
		int idCourse = parser.parseToInt(mass[1]);
		lectureService.addLectureInCourse(idLecture, idCourse);
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String deleteLectureFromCourse(String idLecture) {
		lectureService.deleteLectureFromCourse(parser.parseToInt(idLecture));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String addLectureInCourseInformation(String stringLecture) throws ParseException {
		lectureService.add(parser.parseStringToLecture(stringLecture));
		return "";
	}

	// when you change date should not exceed the limit of students on the day
	/**
	 * 
	 */
	@Override
	public synchronized String addDateInLecture(String string) throws ParseException {
		String[] mass = parser.split(string);
		Date date = parser.parseDate(mass[0]);
		int idLecture = parser.parseToInt(mass[1]);
		lectureService.addDateInLecture(date, idLecture);
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String deleteDateFromLecture(String idLecture) {
		lectureService.deleteDateInLecture(parser.parseToInt(idLecture));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public String showLecture(String idLecture) {
		return operations.objectToString(lectureService.getById(parser.parseToInt(idLecture)));
	}

	/**
	 * 
	 */
	@Override
	public synchronized String addLecturerInCourse(String string) {
		String[] mass = parser.split(string);
		int idLecturer = parser.parseToInt(mass[0]);
		int idCourse = parser.parseToInt(mass[1]);
		lecturerService.addLecturerInCourse(idLecturer, idCourse);
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String deleteLecturerFromCourse(String idCourse) {
		lecturerService.deleteLecturerFromCourse(parser.parseToInt(idCourse));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String addLecturerInCourseInformation(String stringLecturer) {
		lecturerService.add(parser.parseStringToLecturer(stringLecturer));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public String showLecturer(String string) {
		return operations.objectToString(lecturerService.getById(parser.parseToInt(string)));
	}

	/**
	 * 
	 */
	@Override
	public synchronized String addStudentInCourse(String string) {
		String[] mass = parser.split(string);
		int idStudent = parser.parseToInt(mass[0]);
		int idCourse = parser.parseToInt(mass[1]);
		studentService.addStudentInCourse(idStudent, idCourse);
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String deleteStudentFromCourse(String idStudent) {
		studentService.deleteStudentFromCourse(parser.parseToInt(idStudent));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public synchronized String addStudentInCourseInformation(String stringStudent) {
		studentService.add(parser.parseStringToStudent(stringStudent));
		return "";
	}

	/**
	 * 
	 */
	@Override
	public String showStudent(String idStudent) {
		return operations.objectToString(studentService.getById(parser.parseToInt(idStudent)));
	}

	/**
	 * 
	 */
	@Override
	public synchronized String sortLecturersByName() {
		lecturerService.setSortBy("name");
		return "";
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public synchronized String sortLecturesByName() {
		lectureService.setSortBy("name");
		return "";
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public synchronized String sortLecturesByDate() {
		lectureService.setSortBy("date");
		return "";
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public synchronized String sortCourseByName() {
		courseService.setSortBy("name");
		return "";
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public synchronized String sortCourseBySection() {
		courseService.setSortBy("section");
		return "";
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public synchronized String sortCourseByStartDate() {
		courseService.setSortBy("startDate");
		return "";
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public synchronized String sortCourseByLecturer() {
		courseService.setSortBy("lecturer");
		return "";
	}

	/**
	 * 
	 */
	@Override
	public String getActiveCourses() {
		return operations.listToString(courseService.getActiveCourses());
	}

	/**
	 * 
	 */
	@Override
	public String getCoursesAfterDate(String date) throws ParseException {
		return operations.listToString(courseService.getCoursesAfterDate(parser.parseDate(date)));
	}

	/**
	 * 
	 */
	@Override
	public String getCoursesIntervalInPast(String dates) throws ParseException {
		String[] mass = parser.split(dates);
		Date startDate = parser.parseDate(mass[0]);
		Date endDate = parser.parseDate(mass[1]);
		return operations.listToString(courseService.getCoursesIntervalInPast(startDate, endDate));
	}

	/**
	 * 
	 */
	@Override
	public String getLecturesOnDate(String date) throws ParseException {
		return operations.listToString(lectureService.getLectureOnDate(parser.parseDate(date)));
	}

	/**
	 * 
	 */
	@Override
	public synchronized String cloneCourse(String idCourse) {
		courseService.cloneCourse(parser.parseToInt(idCourse));
		return "";
	}

}
