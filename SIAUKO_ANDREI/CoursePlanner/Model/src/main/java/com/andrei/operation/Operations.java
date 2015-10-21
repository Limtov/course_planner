package com.andrei.operation;

import java.util.List;

import com.andrei.api.IOperations;

public class Operations<T, U> implements IOperations {

	/**
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public String objectToString(Object object) {
		return object.toString();
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public String listToString(List<?> objects) {
		String s = "";
		for (Object object : objects) {
			s += object.toString() + "\r\n";
		}
		return s;
	}

}
