package com.andrei.ui.io;

import java.util.Scanner;

public class Input {
	
	private Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @return
	 */
	public int readItem(){
		return Integer.parseInt(scanner.nextLine());
	}
	
	/**
	 * 
	 * @return
	 */
	public String readParams(){
		return scanner.nextLine();
	}
}
