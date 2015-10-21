package com.andrei.ui.entity;

import com.andrei.ui.FormatInputEnum;

public class MenuItem {
	
	private String content;
	private Menu menu;
	private String nameMethod;
	private FormatInputEnum paramEnum;
	private String param;
	
	public MenuItem(String content){
		this.setContent(content);
	}
	
	public MenuItem(String content, String nameMethod){
		this.setContent(content);
		this.nameMethod = nameMethod;
		}
	
	public MenuItem(String content, String nameMethod, String param){
		this.setContent(content);
		this.nameMethod = nameMethod;
		this.setParam(param);
		paramEnum = FormatInputEnum.valueOf(param);
		}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getNameMethod() {
		return nameMethod;
	}
	

	public FormatInputEnum getParamEnum() {
		return paramEnum;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * 
	 */
	@Override
	public String toString(){
		return content;
	}
	
	
}
