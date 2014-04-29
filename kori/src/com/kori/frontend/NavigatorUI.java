package com.kori.frontend;

import javax.servlet.annotation.WebServlet;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.ui.UI;

public class NavigatorUI extends UI {
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = NavigatorUI.class)
	public static class Servlet extends VaadinServlet {
		
	}
	
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
		
		//aloitetaan login ruudusta.. menee registeriin
		navigator.navigateTo("login");
		
	}
}
