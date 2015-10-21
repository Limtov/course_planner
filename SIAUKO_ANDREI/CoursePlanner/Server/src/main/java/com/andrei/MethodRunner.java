package com.andrei;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.andrei.DependencyInjectionUtility;
import com.andrei.api.IManager;

public class MethodRunner {

	private IManager manager;
	private String string;

	public MethodRunner() {
		manager = (IManager) DependencyInjectionUtility.getObjectByInterface(IManager.class);
		string = null;
	}

	/**
	 * 
	 * @param nameMethod
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public String run(String nameMethod) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class<?> c = manager.getClass();
		Method method = c.getMethod(nameMethod);
		if ((string = (String) method.invoke(manager)) != null) {
			return string;
		}
		return null;
	}

	/**
	 * 
	 * @param nameMethod
	 * @param param
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public String run(String nameMethod, String param) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class<?> c = manager.getClass();
		Class<?>[] paramTypes = new Class[] { String.class };
		Method method = c.getMethod(nameMethod, paramTypes);
		if ((string = (String) method.invoke(manager, param)) != null) {
			return string;
		}
		return null;
	}
}
