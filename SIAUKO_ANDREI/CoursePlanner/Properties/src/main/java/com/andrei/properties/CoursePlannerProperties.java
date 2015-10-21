package com.andrei.properties;

import java.util.Properties;

public class CoursePlannerProperties {
	
	private final String FILE_NAME = "lecture.properties";
	
	private Properties properties;
	private PropertiesOperations operationsWithLectureProperties;
	
	public CoursePlannerProperties(){
		operationsWithLectureProperties = new PropertiesOperations();
		properties = operationsWithLectureProperties.readProperties(FILE_NAME);
	}
	
	public String getValue(String key){
		return (String)properties.get(key);
	}

}
