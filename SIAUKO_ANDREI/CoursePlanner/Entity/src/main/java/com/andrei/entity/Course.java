package com.andrei.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.andrei.entity.api.IBaseEntity;

@Entity
@Table
public class Course implements IBaseEntity, Comparable<Course>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private final String NAME = "name: ";

	@Transient
	private final String SECTION = "\r\nsection:";

	@Transient
	private final String START_DATE = "\r\nstart data: ";

	@Transient
	private final String END_DATE = "\r\nend data: ";

	@Transient
	private final String LECTURES = "\r\nlectures: ";

	@Transient
	private final String LECTURER = "\r\nlecturer: ";

	@Transient
	private final String STUDENTS = "\r\nstudents: ";

	@Transient
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	@Transient
	private final SimpleDateFormat FORMAT = new SimpleDateFormat(DATE_FORMAT);

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@Column
	private String name;

	@Column
	private String section;

	@Column(name = "end_date")
	private Date startDate;

	@Column(name = "start_date")
	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "id_lecturer")
	private Lecturer lecturer;

	@OneToMany
	@JoinColumn(name = "id_course")
	private List<Student> students;

	@OneToMany
	@JoinColumn(name = "id_course")
	private List<Lecture> lectures;

	public Course() {

	}

	public Course(String name, String section, Date startDate, Date endDate) {
		this.setName(name);
		this.setSection(section);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.students = new ArrayList<Student>();
		this.lectures = new ArrayList<Lecture>();
	}

	public Course(int id, String name, String section, Date startDate, Date endDate) {
		this.setId(id);
		this.setName(name);
		this.setSection(section);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.students = new ArrayList<Student>();
		this.lectures = new ArrayList<Lecture>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
		for (Student student : students) {
			student.setCourse(this);
		}
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
		for (Lecture lecture : lectures) {
			lecture.setCourse(this);
		}
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		Course other = (Course) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	/** 
	 * 
	 */
	@Override
	public int compareTo(Course o) {
		return this.name.compareTo(o.getName());
	}

	/**
	 * 
	 */
	@Override
	public Course clone() throws CloneNotSupportedException {
		Course course = (Course) super.clone();
		course.students = new ArrayList<Student>();
		course.lecturer = null;
		course.setId(0);
		course.lectures = new ArrayList<Lecture>();
		if (lectures.size() != 0) {
			for (Lecture lecture : this.lectures) {
				course.lectures.add(lecture);
			}
		}
		return course;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String s = NAME + name + SECTION + section + START_DATE + FORMAT.format(startDate) + END_DATE + FORMAT.format(endDate);
		if (lecturer != null) {
			s += LECTURER + lecturer.getName();
		}
		if (lectures != null && !lectures.isEmpty()) {
			s += LECTURES;
			for (Lecture lecture : lectures) {
				s += lecture.getName() + "; ";
			}
		}
		return s + "\r\n";
	}

}
