/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.asgn.model;

import ro.seava.ad.domain.impl.security.MenuItem;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractAsgnModel;

@Ds(entity=MenuItem.class, sort={@SortField(field=Role_MenuItem_Asgn.f_name)})
public class Role_MenuItem_Asgn extends AbstractAsgnModel<MenuItem> {
	
	public static final String f_id = "id";
	public static final String f_name = "name";
	public static final String f_title = "title";
	
	@DsField(path="id")
	private String  id;
	
	@DsField(path="name")
	private String  name;
	
	@DsField(path="title")
	private String  title;
	
	public Role_MenuItem_Asgn() {
	}
	
	public Role_MenuItem_Asgn(MenuItem e) {
		super();
		this.id = e.getId();
		this.name = e.getName();
		this.title = e.getTitle();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
