package com.frontend.kori;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class NavigatorUI extends UI {
	protected static Navigator navigator;
	protected static final String LOGIN = "login";
	protected static final String CONTENT = "content";
	protected static final String REGISTER = "register";
	
	@Override
	protected void init(VaadinRequest request) {
		navigator = new Navigator(this,this);
		navigator.addView(LOGIN, new Login());
		navigator.addView(CONTENT,new Content());
		navigator.addView(REGISTER, new Register());
	}
}
