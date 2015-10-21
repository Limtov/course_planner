package com.andrei.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {

	public Connection getConnection() throws SQLException;

	public void closeConnection() throws SQLException;

}
