package com.andrei.ui;

import java.util.ArrayList;
import java.util.List;

import com.andrei.ui.entity.Menu;
import com.andrei.ui.entity.MenuItem;

public class CreatingManyMenu {
	
	/**
	 * 
	 * @return
	 * @throws ParseException
	 */
	public Menu create() {
		
	
//menuGetterLecturesOnDate	
		List<MenuItem> menuItemsGetterLecturesOnDate = new ArrayList<MenuItem>();
		menuItemsGetterLecturesOnDate.add(new MenuItem("Get Lectures on date", "getLecturesOnDate", "DATE"));
		menuItemsGetterLecturesOnDate.add(new MenuItem("Back", ""));
		
		Menu menuGetterLecturesOnDate = new Menu(menuItemsGetterLecturesOnDate);
		
// menuGetterCoursesOnDate	
		List<MenuItem> menuItemsGetterCoursesOnDate= new ArrayList<MenuItem>();
		menuItemsGetterCoursesOnDate.add(new MenuItem("Get active Courses", "getActiveCourses"));
		menuItemsGetterCoursesOnDate.add(new MenuItem("Get Courses after date", "getCoursesAfterDate", "DATE"));
		menuItemsGetterCoursesOnDate.add(new MenuItem("Get Courses interval in past", "getCoursesIntervalInPast", "TWO_DATE"));
		menuItemsGetterCoursesOnDate.add(new MenuItem("Back"));

		Menu menuGetterCoursesOnDate = new Menu(menuItemsGetterCoursesOnDate);
		
// menuSortingCourses	
		List<MenuItem> menuItemsSortingCourses= new ArrayList<MenuItem>();
		menuItemsSortingCourses.add(new MenuItem("Sort by name", "sortCourseByName"));
		menuItemsSortingCourses.add(new MenuItem("Sort by section", "sortCourseBySection"));
		menuItemsSortingCourses.add(new MenuItem("Sort by start date", "sortCourseByStartDate"));
		menuItemsSortingCourses.add(new MenuItem("Sort by Lecturer", "sortCourseByLecturer"));
		menuItemsSortingCourses.add(new MenuItem("Back"));
		
		Menu menuSortingCourses = new Menu(menuItemsSortingCourses);
		
//	menuSortingLectures
		List<MenuItem> menuItemsSortingLectures= new ArrayList<MenuItem>();
		menuItemsSortingLectures.add(new MenuItem("Sort by name", "sortLecturesByName"));
		menuItemsSortingLectures.add(new MenuItem("Sort by date", "sortLecturesByDate"));
		menuItemsSortingLectures.add(new MenuItem("Back"));
		
		Menu menuSortingLectures = new Menu(menuItemsSortingLectures);
		
//menuSortingLecturers
		List<MenuItem> menuItemsSortingLecturers= new ArrayList<MenuItem>();
		menuItemsSortingLecturers.add(new MenuItem("Sort by name", "sortLecturersByName"));
		menuItemsSortingLecturers.add(new MenuItem("Back"));
		
		Menu menuSortingLecturers = new Menu(menuItemsSortingLecturers);
		
//menuOperationsWithStudent			
		List<MenuItem> menuItemsOperationsWithStudent= new ArrayList<MenuItem>();
		menuItemsOperationsWithStudent.add(new MenuItem("Add Student in Course", "addStudentInCourse", "TWO_ITEM"));
		menuItemsOperationsWithStudent.add(new MenuItem("Delete Student from Course", "deleteStudentFromCourse", "ITEM"));
		menuItemsOperationsWithStudent.add(new MenuItem("Add Student in CourseInformation", "addStudentInCourseInformation", "STUDENT"));
		menuItemsOperationsWithStudent.add(new MenuItem("Show Student", "showStudent", "ITEM"));
		menuItemsOperationsWithStudent.add(new MenuItem("Show list Student", "showListStudents"));
		menuItemsOperationsWithStudent.add(new MenuItem("Back"));
		
		Menu menuOperationsWithStudent = new Menu(menuItemsOperationsWithStudent);
			
//menuOperationsWithLecturer			
		List<MenuItem> menuItemsOperationsWithLecturer= new ArrayList<MenuItem>();
		menuItemsOperationsWithLecturer.add(new MenuItem("Add Lecturer in Course", "addLecturerInCourse", "TWO_ITEM"));
		menuItemsOperationsWithLecturer.add(new MenuItem("Delete Lecturer from Course", "deleteLecturerFromCourse", "ITEM"));
		menuItemsOperationsWithLecturer.add(new MenuItem("Add Lecturer in CourseInformation", "addLecturerInCourseInformation", "LECTURER"));
		menuItemsOperationsWithLecturer.add(new MenuItem("Show Lecturer", "showLecturer", "ITEM"));
		menuItemsOperationsWithLecturer.add(new MenuItem("Show list Lecturer", "showListLecturers"));
		menuItemsOperationsWithLecturer.add(new MenuItem("Back"));
		
		Menu menuOperationsWithLecturer = new Menu(menuItemsOperationsWithLecturer);
		
//menuOperationsWithLecture				
		List<MenuItem> menuItemsOperationsWithLecture= new ArrayList<MenuItem>();
		menuItemsOperationsWithLecture.add(new MenuItem("Add Lecture in Course", "addLectureInCourse", "TWO_ITEM"));
		menuItemsOperationsWithLecture.add(new MenuItem("Delete Lecture from Course", "deleteLectureFromCourse", "ITEM"));
		menuItemsOperationsWithLecture.add(new MenuItem("Add Lecture in CourseInformation", "addLectureInCourseInformation", "LECTURE"));
		menuItemsOperationsWithLecture.add(new MenuItem("Add date in Lecture", "addDateInLecture", "DATE_AND_ITEM"));
		menuItemsOperationsWithLecture.add(new MenuItem("Delete date from Lecture", "deleteDateFromLecture", "ITEM"));
		menuItemsOperationsWithLecture.add(new MenuItem("Show Lecture", "showLecture", "ITEM"));
		menuItemsOperationsWithLecture.add(new MenuItem("Show list Lecture", "showListLectures"));
		menuItemsOperationsWithLecture.add(new MenuItem("Back"));
		
		Menu menuOperationsWithLecture = new Menu(menuItemsOperationsWithLecture);
			
//menuOperationsWithCourse 					
		List<MenuItem> menuItemsOperationsWithCourse= new ArrayList<MenuItem>();
		menuItemsOperationsWithCourse.add(new MenuItem("Add Course in CourseInformation", "addCourseInCourseInformation", "COURSE"));
		menuItemsOperationsWithCourse.add(new MenuItem("Delete Course from CourseInformation", "deleteCourseFromCourseInformation", "ITEM"));
		menuItemsOperationsWithCourse.add(new MenuItem("Show Course", "showCourse", "ITEM"));
		menuItemsOperationsWithCourse.add(new MenuItem("Show list Courses", "showListCourses"));
		menuItemsOperationsWithCourse.add(new MenuItem("Clone Course", "cloneCourse", "ITEM"));
		menuItemsOperationsWithCourse.add(new MenuItem("Back"));
		
		Menu menuOperationsWithCourse = new Menu(menuItemsOperationsWithCourse);
		
//menuGetter		
		List<MenuItem> menuItemsGetter = new ArrayList<MenuItem>();
		menuItemsGetter.add(new MenuItem("Getter Courses on date"));
		menuItemsGetter.add(new MenuItem("Getter Lectures on date"));
		menuItemsGetter.add(new MenuItem("Back"));
		
		menuItemsGetter.get(0).setMenu(menuGetterCoursesOnDate);
		menuItemsGetter.get(1).setMenu(menuGetterLecturesOnDate);
		
		Menu menuGetter = new Menu(menuItemsGetter);
		
		menuGetterLecturesOnDate.getMenuItems().get(menuGetterLecturesOnDate.getMenuItems().size() - 1).setMenu(menuGetter);
		menuGetterCoursesOnDate.getMenuItems().get(menuGetterCoursesOnDate.getMenuItems().size() - 1).setMenu(menuGetter);
			
//menuSorting		
		List<MenuItem> menuItemsSorting= new ArrayList<MenuItem>();
		menuItemsSorting.add(new MenuItem("Sorting Lecturers"));
		menuItemsSorting.add(new MenuItem("Sorting Lectures"));
		menuItemsSorting.add(new MenuItem("Sorting Courses"));
		menuItemsSorting.add(new MenuItem("Back"));
		
		menuItemsSorting.get(0).setMenu(menuSortingLecturers);
		menuItemsSorting.get(1).setMenu(menuSortingLectures);
		menuItemsSorting.get(2).setMenu(menuSortingCourses);
		
		Menu menuSorting = new Menu(menuItemsSorting);
		
		menuSortingCourses.getMenuItems().get(menuSortingCourses.getMenuItems().size() - 1).setMenu(menuSorting);
		menuSortingLectures.getMenuItems().get(menuSortingLectures.getMenuItems().size() - 1).setMenu(menuSorting);
		menuSortingLecturers.getMenuItems().get(menuSortingLecturers.getMenuItems().size() - 1).setMenu(menuSorting);

// menuOperations 			
		List<MenuItem> menuItemsOperations= new ArrayList<MenuItem>();
		menuItemsOperations.add(new MenuItem("Operations with Course"));
		menuItemsOperations.add(new MenuItem("Operations with Lecture"));
		menuItemsOperations.add(new MenuItem("Operations with Lecturer"));
		menuItemsOperations.add(new MenuItem("Operations with Student"));
		menuItemsOperations.add(new MenuItem("Back"));
		
		menuItemsOperations.get(0).setMenu(menuOperationsWithCourse);
		menuItemsOperations.get(1).setMenu(menuOperationsWithLecture);
		menuItemsOperations.get(2).setMenu(menuOperationsWithLecturer);
		menuItemsOperations.get(3).setMenu(menuOperationsWithStudent);
		
		Menu menuOperations = new Menu(menuItemsOperations);
		
		menuOperationsWithStudent.getMenuItems().get(menuOperationsWithStudent.getMenuItems().size() - 1).setMenu(menuOperations);
		menuOperationsWithLecturer.getMenuItems().get(menuOperationsWithLecturer.getMenuItems().size() - 1).setMenu(menuOperations);
		menuOperationsWithLecture.getMenuItems().get(menuOperationsWithLecture.getMenuItems().size() - 1).setMenu(menuOperations);
		menuOperationsWithCourse.getMenuItems().get(menuOperationsWithCourse.getMenuItems().size() - 1).setMenu(menuOperations);
		
// menuManager			
		List<MenuItem> menuItemsManager = new ArrayList<MenuItem>();
		menuItemsManager.add(new MenuItem("Operations"));
		menuItemsManager.add(new MenuItem("Sorting"));
		menuItemsManager.add(new MenuItem("Getter"));
		menuItemsManager.add(new MenuItem("Back"));
		
		menuItemsManager.get(0).setMenu(menuOperations);
		menuItemsManager.get(1).setMenu(menuSorting);
		menuItemsManager.get(2).setMenu(menuGetter);
		
		Menu menuManager = new Menu(menuItemsManager);
		
		menuGetter.getMenuItems().get(menuGetter.getMenuItems().size() - 1).setMenu(menuManager);
		menuSorting.getMenuItems().get(menuSorting.getMenuItems().size() - 1).setMenu(menuManager);
		menuOperations.getMenuItems().get(menuOperations.getMenuItems().size() - 1).setMenu(menuManager);
		
// menuGeneral		
		List<MenuItem> menuItemsGeneral = new ArrayList<MenuItem>();
		menuItemsGeneral.add(new MenuItem("Manager"));
		menuItemsGeneral.add(new MenuItem("Close", "exit"));
		
		menuItemsGeneral.get(0).setMenu(menuManager);
		
		Menu menuGeneral = new Menu(menuItemsGeneral);
		
		menuManager.getMenuItems().get(menuManager.getMenuItems().size() - 1).setMenu(menuGeneral);;

		return menuGeneral;
	}
	
	/**
	 * 
	 * @param activeMenu
	 * @return
	 * @throws ParseException
	 */
	public Menu getMenuLast(Menu activeMenu) {
		List<MenuItem> menuItemsLast = new ArrayList<MenuItem>();
		menuItemsLast.add(new MenuItem("Back"));
		Menu menuLast = new Menu(menuItemsLast);
		menuLast.getMenuItems().get(0).setMenu(activeMenu);
		return menuLast;
	}

}
