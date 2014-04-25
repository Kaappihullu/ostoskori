package com.example.kori;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.*;

@SuppressWarnings("serial")
@Theme("kori")
public class KoriUI extends UI {
	//servletin configuraatio
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = KoriUI.class)
	public static class Servlet extends VaadinServlet {}
	
	//varsinainen elementtien asettelu
	@Override 
	protected void init(VaadinRequest request) {
		//layoutin maarittely
		final VerticalLayout layoutv = new VerticalLayout();
		layoutv.setMargin(true);
		setContent(layoutv);
		
		Button blogin = new Button("Avaa login ikkuna");
		Button bluettelo = new Button("Avaa luettelo kikkuna");
		
		blogin.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		bluettelo.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
//kts. classit Login.java ja Luettelo.java
	
//koodi toistaiseksi DEPRECATED
			
//		//elementit
//		Button btalleta = new Button("Talleta rahaa"); //lisaa saldoon
//		Button bhyvaksy = new Button("Hyvaksy ostokset"); //miinustaa saldosta
//		Button blogout = new Button("Kirjaudu ulos"); //joko...
//		Button blogin = new Button("Kirjaudu sisaan"); //...tai
//		TextField tsaldo = new TextField("Saldo"); //nayttaa kayttajan
//		
//		//listenerit elementeille
//		btalleta.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//			layoutv.addComponent(new Label(""));
//		}});
//		
//		bhyvaksy.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//			layoutv.addComponent(new Label("Thank you for clicking"));
//		}});
//		
//		blogout.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//			layoutv.addComponent(new Label("Thank you for clicking"));
//		}});
//		
//		blogin.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//			layoutv.addComponent(new Label("Thank you for clicking"));
//		}});
//		
//	}
//	
//	
//	//hello buttonin oikeaoppinen tekeminen
//	@Override
//	protected void init(VaadinRequest request) {
//		final VerticalLayout layout = new VerticalLayout();
//		layout.setMargin(true);
//		setContent(layout);
//
//		Button button = new Button("Click Me");
//		button.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//				layout.addComponent(new Label("Thank you for clicking"));
//			}
//		});
//		layout.addComponent(button);
//	}

}