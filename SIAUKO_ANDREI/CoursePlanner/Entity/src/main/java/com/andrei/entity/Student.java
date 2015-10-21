package com.andrei.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.andrei.entity.api.IBaseEntity;

@Entity
@Table
public class Student implements IBaseEntity, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private final String NAME = "name: ";

	@Transient
	private final String COURSE = ", course: ";

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@Column()
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_course")
	private Course course;

	public Student() {

	}

	public Student(String name) {
		this.setName(name);
	}

	public Student(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public Student(int id, String name, Course course) {
		this.setId(id);
		this.setName(name);
		this.setCourse(course);
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		Student other = (Student) obj;
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
	public Student clone() throws CloneNotSupportedException {
		return (Student) super.clone();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String s = NAME + name;
		if (course != null) {
			s += COURSE + course.getName();
		}
		return s;
	}

}
