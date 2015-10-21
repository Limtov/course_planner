package com.andrei.ui;

import org.apache.log4j.Logger;

import com.andrei.ui.io.Input;

public class Starter {

	private static final Logger log = Logger.getLogger(Starter.class);

	private Input input;
	private Controller controller;
	private int item;

	public Starter() {
		this.input = new Input();
		this.controller = new Controller();
	}

	/**
	 * 
	 */
	public void start() {
		while (true) {
			try {
				controller.printMenu();
				item = input.readItem();
				controller.perform(item);
			} catch (IndexOutOfBoundsException | NumberFormatException e) {
				log.info(e);
				System.out.println("Not valid value. Enter value again");
			} catch (Exception e) {
				log.error(e);
				System.out.println(e.getMessage());
			}
		}
	}

}
