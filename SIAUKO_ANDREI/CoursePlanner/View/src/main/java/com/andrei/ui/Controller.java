package com.andrei.ui;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.andrei.ui.entity.Menu;
import com.andrei.ui.entity.Navigator;
import com.andrei.ui.io.Input;
import com.andrei.ui.io.Output;

public class Controller {

	private static final Logger log = Logger.getLogger(Controller.class);

	private CreatingManyMenu creating = new CreatingManyMenu();
	private Menu menuGeneral;
	private Navigator navigator;
	private Output output;
	private Input input;
	private String param;

	public Controller() {
		this.menuGeneral = creating.create();
		this.navigator = new Navigator(menuGeneral);
		this.output = new Output();
		this.input = new Input();
		this.param = null;
	}

	public Menu getMenus() {
		return menuGeneral;
	}

	public Navigator getNavigator() {
		return navigator;
	}

	/**
	 * 
	 * @param i
	 * @throws ParseException
	 */
	public String perform(int i) {
		if (navigator.getMenu().getMenuItems().get(i - 1).getMenu() != null) {
			navigator.setMenu(navigator.getMenu().getMenuItems().get(i - 1).getMenu());
		} else {
			try {

				if (navigator.getMenu().getMenuItems().get(i - 1).getParamEnum() == null) {
					return navigator.getMenu().getMenuItems().get(i - 1).getNameMethod();
				} else {
					output.show(navigator.getMenu().getMenuItems().get(i - 1).getParamEnum().getMessage());
					param = input.readParams();
					return navigator.getMenu().getMenuItems().get(i - 1).getNameMethod() + "<>" + param;
				}
			} catch (Exception e) {
				log.info(e);
			}
			navigator.setMenu(creating.getMenuLast(navigator.getMenu()));
		}
		return null;
	}

	/**
	 * 
	 */
	public void printMenu() {
		if (this.navigator.isCheck()) {
			output.show(this.navigator.getMenu().toString());
		}
	}

}
