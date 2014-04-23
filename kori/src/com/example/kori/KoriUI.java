package com.example.kori;

import javax.servlet.annotation.WebServlet;

import com.backend.kori.database.Database;
import com.backend.kori.database.Database.IReader;
import com.backend.kori.database.Database.IWriter;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("kori")
public class KoriUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = KoriUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
				
				Database database = Database.getDatabase("C:\\JavaDev\\test");
				
				for(int i=0;i<database.getSize();i++){
					IReader reader = database.getReader(i);
					String t = "";
					for(int o=0;o<reader.getLength();o++){
						t += reader.getValue(o);
					}
					layout.addComponent(new Label(t));
				}
				
			}
		});
		layout.addComponent(button);
	}

}