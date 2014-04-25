package com.frontend.kori;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class UserCreate extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button bperuuta;
	@AutoGenerated
	private Button bvalmis;
	@AutoGenerated
	private PasswordField tpassword;
	@AutoGenerated
	private TextField tname;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public UserCreate() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
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
		
		// tname
		tname = new TextField();
		tname.setCaption("Nimi");
		tname.setImmediate(false);
		tname.setWidth("-1px");
		tname.setHeight("-1px");
		mainLayout.addComponent(tname, "top:80.0px;left:100.0px;");
		
		// tpassword
		tpassword = new PasswordField();
		tpassword.setCaption("Salasana");
		tpassword.setImmediate(false);
		tpassword.setWidth("-1px");
		tpassword.setHeight("-1px");
		mainLayout.addComponent(tpassword, "top:136.0px;left:100.0px;");
		
		// bvalmis
		bvalmis = new Button();
		bvalmis.setCaption("Valmis!");
		bvalmis.setImmediate(true);
		bvalmis.setWidth("-1px");
		bvalmis.setHeight("-1px");
		mainLayout.addComponent(bvalmis, "top:180.0px;left:143.0px;");
		
		bvalmis.
		
		// bperuuta
		bperuuta = new Button();
		bperuuta.setCaption("Peruuta");
		bperuuta.setImmediate(true);
		bperuuta.setWidth("-1px");
		bperuuta.setHeight("-1px");
		mainLayout.addComponent(bperuuta, "top:20.0px;left:20.0px;");
		
		return mainLayout;
	}

}

