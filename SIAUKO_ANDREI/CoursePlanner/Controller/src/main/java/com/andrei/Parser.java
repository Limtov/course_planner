package com.andrei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.andrei.entity.Course;
import com.andrei.entity.Lecture;
import com.andrei.entity.Lecturer;
import com.andrei.entity.Student;

public class Parser {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private final SimpleDateFormat FORMAT = new SimpleDateFormat(DATE_FORMAT);
	private final int FILE_POSITION_NAME = 0;
	private final int FILE_LECTURE_POSITION_DATE = 1;
	private final int FILE_COURSE_POSITION_SECTION = 1;
	private final int FILE_COURSE_POSITION_START_DATE = 2;
	private final int FILE_COURSE_POSITION_END_DATE = 3;
	private final String SEPARATOR = ";";

	/**
	 * 
	 * @param string
	 * @return
	 * @throws ParseException
	 */
	public Date parseDate(String string) throws ParseException {
		return FORMAT.parse(string);
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public Student parseStringToStudent(String string) {
		String[] f = string.split(SEPARATOR);
		final String NAME = f[FILE_POSITION_NAME];
		return new Student(NAME);
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public Lecturer parseStringToLecturer(String string) {
		String[] f = string.split(SEPARATOR);
		final String NAME = f[FILE_POSITION_NAME];
		return new Lecturer(NAME);
	}

	/**
	 * 
	 * @param string
	 * @return
	 * @throws ParseException
	 */
	public Lecture parseStringToLecture(String string) throws ParseException {
		String[] f = string.split(SEPARATOR);
		final String NAME = f[FILE_POSITION_NAME];
		Date date = null;
		try {
			date = FORMAT.parse(f[FILE_LECTURE_POSITION_DATE]);
		} catch (ParseException e) {
			System.out.println("Not correct date format\r\n");
		}
		return new Lecture(NAME, date);
	}

	/**
	 * 
	 * @param string
	 * @return
	 * @throws ParseException
	 */
	public Course parseStringToCourse(String string) throws ParseException {
		String[] f = string.split(SEPARATOR);
		final String NAME = f[FILE_POSITION_NAME];
		final String SECTION = f[FILE_COURSE_POSITION_SECTION];
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = FORMAT.parse(f[FILE_COURSE_POSITION_START_DATE]);
			endDate = FORMAT.parse(f[FILE_COURSE_POSITION_END_DATE]);
		} catch (ParseException e) {
			System.out.println("Not correct date format\r\n");
		}
		return new Course(NAME, SECTION, startDate, endDate);
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public int parseToInt(String string) {
		return Integer.parseInt(string);
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public String[] split(String string) {
		return string.split(SEPARATOR);
	}

}
