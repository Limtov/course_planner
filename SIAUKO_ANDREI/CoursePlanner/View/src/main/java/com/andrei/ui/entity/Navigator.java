package com.andrei.ui.entity;


public class Navigator {
	
	private boolean check = false;
	private Menu menu;

	public Navigator(Menu menu) {
		this.setMenu(menu);
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
		if(menu != null){
			check = true;
		}
		else{
			check = false;
		}
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	

	

}
