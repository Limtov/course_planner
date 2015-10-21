package com.andrei.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesOperations {

	private static final Logger log = Logger.getLogger(PropertiesOperations.class);

	public Properties readProperties(String fileName) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = getClass().getResource("/" + fileName).openStream();
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return properties;
	}

	public void writeProperties(Properties properties, String key, int quantity, String fileName) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			properties.setProperty(key, Integer.toString(quantity));
			properties.store(fileOutputStream, "");
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

}
