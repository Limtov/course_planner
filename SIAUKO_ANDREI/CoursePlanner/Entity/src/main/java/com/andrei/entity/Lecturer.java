package com.andrei.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.andrei.entity.api.IBaseEntity;

@Entity
@Table
public class Lecturer implements IBaseEntity, Comparable<Lecturer>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private final String NAME = "name: ";

	@Transient
	private final String COURSE = ", courses: ";

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@Column
	private String name;

	@OneToMany
	@JoinColumn(name = "id_lecturer")
	private List<Course> courses;

	public Lecturer() {

	}

	public Lecturer(String name) {
		this.setName(name);
		this.courses = new ArrayList<Course>();
	}

	public Lecturer(int id, String name) {
		this.setId(id);
		this.setName(name);
		this.courses = new ArrayList<Course>();
	}

	public Lecturer(int id, String name, List<Course> courses) {
		this.setId(id);
		this.setName(name);
		this.setCourses(courses);
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setCourses(Course course) {
		this.courses.add(course);
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(Lecturer o) {
		return this.getName().compareTo(o.getName());
	}

	/** 
	 * 
	 */
	@Override
	public Lecturer clone() throws CloneNotSupportedException {
		return (Lecturer) super.clone();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		Lecturer other = (Lecturer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String s = NAME + name;
		if (courses != null && !courses.isEmpty()) {
			s += COURSE;
			for (Course course : courses) {
				s += course.getName() + SEMICOLON;
			}
		}
		return s;
	}

}
