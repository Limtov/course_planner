package com.andrei;

public class Convertator {
	
	public static String convertTo(String line){
		return line.replace( "\r\n", "||");
	}

	public static String convertFrom(String line){
		return line.replace("||", "\r\n");
	}
}
