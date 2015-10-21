package com.andrei.ui;

public enum FormatInputEnum {
	
	DATE ("Enter the Date in format: yyyy-mm-dd"),
	COURSE ("Enter the Course in format: name;section;startDate(yyyy-mm-dd);endDate(yyyy-mm-dd)"),
	LECTURE ("Enter the Lecture in format: name;date(yyyy-mm-dd)"),
	STUDENT ("Enter the Student in format: name"),
	LECTURER ("Enter the Lecturer in format: name"),
	ITEM ("Enter the Item"),
	TWO_ITEM ("Enter the twoItem in format: item1; item2"),
	TWO_DATE ("Enter the twoDate in format: Date1(yyyy-mm-dd); Date2(yyyy-mm-dd)"),
	DATE_AND_ITEM ("Enter the DateAndItem in format: Date(yyyy-mm-dd); item");
	
	private String message;
	
	private FormatInputEnum(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	
}
