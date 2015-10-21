package com.andrei;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.andrei.properties.PropertiesOperations;

public class DependencyInjectionUtility {

	private static Logger log = Logger.getLogger(DependencyInjectionUtility.class);

	private static final String FILE_NAME = "api.properties";
	private static Properties properties;

	private DependencyInjectionUtility() {

	}

	public static <T extends Class> Object getObjectByInterface(T t) {
		if (t != null) {
			if (properties == null || properties.isEmpty()) {
				properties = new PropertiesOperations().readProperties(FILE_NAME);
			}
			String objectName = properties.getProperty(t.getName());
			Object result = null;
			try {
				result = Class.forName(objectName).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				log.error(e);
			}
			return result;
		}
		return null;
	}

}
