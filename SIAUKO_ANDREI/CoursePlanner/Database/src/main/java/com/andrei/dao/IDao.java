package com.andrei.dao;

import java.util.List;

import org.hibernate.Session;

public interface IDao<T> {

	public void insert(Session session, T entity);

	public void update(Session session, T entity);

	public void delete(Session session, int id);

	public List<T> findAll(Session session, String... strings);

	public T findById(Session session, int id, String... strings);

	public void setSortBy(final String sortBy);

}
