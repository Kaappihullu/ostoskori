package com.kori.frontend;

import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class Content extends CustomComponent implements View {
	
	@WebServlet(value = "/content", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = NavigatorUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@AutoGenerated
	private AbsoluteLayout mainLayout;

	@AutoGenerated
	private Button osta;

	@AutoGenerated
	private Label saldo;

	@AutoGenerated
	private TextField ostokset;

	@AutoGenerated
	private Button logout;

	Navigator navigator;
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public Content() {
		Page.getCurrent().setTitle("Ostoskori - Riskin raksukori!");
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		/*
		 * napin painalluksella logout ja takaisin login ruutuun
		 */
		logout.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO logout here
				navigator.navigateTo("login");
			}
		}); 
		
		
	} 

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO mika taa on hei?
		
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// logout
		logout = new Button();
		logout.setCaption("Logout");
		logout.setImmediate(true);
		logout.setWidth("-1px");
		logout.setHeight("-1px");
		mainLayout.addComponent(logout, "top:20.0px;left:20.0px;");
		
		// ostokset
		ostokset = new TextField();
		ostokset.setCaption("Ostokset");
		ostokset.setImmediate(false);
		ostokset.setWidth("-1px");
		ostokset.setHeight("-1px");
		mainLayout.addComponent(ostokset, "top:196.0px;left:200.0px;");
		
		// saldo
		saldo = new Label();
		saldo.setCaption("Tili");
		saldo.setImmediate(false);
		saldo.setWidth("-1px");
		saldo.setHeight("-1px");
		saldo.setValue("0000");
		mainLayout.addComponent(saldo, "top:122.0px;left:200.0px;");
		
		// osta
		osta = new Button();
		osta.setCaption("Hyvaksy ostokset");
		osta.setImmediate(false);
		osta.setWidth("-1px");
		osta.setHeight("-1px");
		mainLayout.addComponent(osta, "top:194.0px;left:380.0px;");
		
		return mainLayout;
	}

}
