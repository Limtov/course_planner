package com.andrei.ui.entity;

import java.util.List;

public class Menu {
	
	private String NEW_LINE = "\r\n";
	private String POINT = ". ";
	
	private List<MenuItem> menuItems;

	public Menu(List<MenuItem> menuItems) {
		this.setMenuItems(menuItems);
	}
	
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	/**
	 * 
	 */
	@Override
	public String toString(){
		String string = "";
		int i = 1;
		for(MenuItem menuItem : menuItems) {
			string += i + POINT + menuItem.toString() + NEW_LINE;
			i++;
		}
		return string;
	}
	
	
	

}
