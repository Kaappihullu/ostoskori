package com.frontend.kori;

import java.io.File;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Image;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.frontend.kori.NavigatorUI;

public class Register extends CustomComponent implements View {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button cancel;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Button register;
	@AutoGenerated
	private PasswordField passwordConfirm;
	@AutoGenerated
	private PasswordField password;
	@AutoGenerated
	private TextField name;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public Register() {
		Page.getCurrent().setTitle("Rekisteroidy - Ostoskori");
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/asteriski-logo.jpg"));
		Image riskilogo = new Image("Asteriskin logo",resource);
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		//tarkoituksena navigoida takaisin login nakymaan
		cancel.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				navigator.navigateTo("login");
				// TODO jotenkin saatava navigator toimimaan NavigatorUI luokasta 
				
			}
		});
		// TODO add user code here
	}
	
	public void cancelRegistration() {
		
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
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1, "top:100.0px;left:100.0px;");
		
		// cancel
		cancel = new Button();
		cancel.setCaption("Cancel");
		cancel.setImmediate(true);
		cancel.setWidth("-1px");
		cancel.setHeight("-1px");
		mainLayout.addComponent(cancel, "top:20.0px;left:20.0px;");
		
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("-1px");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(false);
		verticalLayout_1.setSpacing(true);
		
		// name
		name = new TextField();
		name.setCaption("Anna nimesi");
		name.setImmediate(false);
		name.setWidth("-1px");
		name.setHeight("-1px");
		name.setRequired(true);
		verticalLayout_1.addComponent(name);
		
		// password
		password = new PasswordField();
		password.setCaption("Anna salasana");
		password.setImmediate(false);
		password.setWidth("-1px");
		password.setHeight("-1px");
		password.setRequired(true);
		verticalLayout_1.addComponent(password);
		
		// passwordConfirm
		passwordConfirm = new PasswordField();
		passwordConfirm.setCaption("Vahvista salasana");
		passwordConfirm.setImmediate(false);
		passwordConfirm.setWidth("-1px");
		passwordConfirm.setHeight("-1px");
		passwordConfirm.setRequired(true);
		verticalLayout_1.addComponent(passwordConfirm);
		
		// register
		register = new Button();
		register.setCaption("Register");
		register.setImmediate(true);
		register.setWidth("-1px");
		register.setHeight("-1px");
		verticalLayout_1.addComponent(register);
		verticalLayout_1.setComponentAlignment(register, new Alignment(48));
		
		return verticalLayout_1;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
		

}