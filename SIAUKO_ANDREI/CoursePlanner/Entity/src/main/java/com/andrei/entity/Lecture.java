package com.andrei.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class Lecture implements IBaseEntity, Comparable<Lecture>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	@Transient
	private final SimpleDateFormat FORMAT = new SimpleDateFormat(DATE_FORMAT);

	@Transient
	private final String NAME = "name: ";

	@Transient
	private final String DATE = ", date: ";

	@Transient
	private final String COURSE = ", course: ";

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@Column
	private String name;

	@Column
	private Date date;

	@ManyToOne
	@JoinColumn(name = "id_course")
	private Course course;

	public Lecture() {

	}

	public Lecture(String name, Date date) {
		this.setName(name);
		this.setDate(date);
	}

	public Lecture(int id, String name, Date date) {
		this.setId(id);
		this.setName(name);
		this.setDate(date);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		Lecture other = (Lecture) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Lecture o) {
		return this.name.compareTo(o.getName());
	}

	/**
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 */
	@Override
	public Lecture clone() throws CloneNotSupportedException {
		return (Lecture) super.clone();
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
		if (date != null) {
			s += DATE + FORMAT.format(date);
		}
		return s;

	}

}
