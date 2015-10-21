package com.andrei.api.transactionDao;

import java.util.List;

public interface ITransactionDao<T> {

	public void add(T entity);

	public void update(T entity);

	public void delete(int id);

	public List<T> getList();

	public T getById(int id);

	public void setSortBy(final String sortBy);

}
