/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.asgn.model;

import ro.seava.ad.domain.impl.security.Role;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractAsgnModel;

@Ds(entity=Role.class, sort={@SortField(field=Menu_Role_Asgn.f_code)})
public class Menu_Role_Asgn extends AbstractAsgnModel<Role> {
	
	public static final String f_id = "id";
	public static final String f_code = "code";
	public static final String f_name = "name";
	public static final String f_description = "description";
	
	@DsField(path="id")
	private String  id;
	
	@DsField(path="code")
	private String  code;
	
	@DsField(path="name")
	private String  name;
	
	@DsField(path="description")
	private String  description;
	
	public Menu_Role_Asgn() {
	}
	
	public Menu_Role_Asgn(Role e) {
		super();
		this.id = e.getId();
		this.code = e.getCode();
		this.name = e.getName();
		this.description = e.getDescription();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
