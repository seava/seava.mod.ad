/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.asgn.model;

import seava.ad.domain.impl.security.UserGroup;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.model.AbstractAsgnModel;

@Ds(entity=UserGroup.class, sort={@SortField(field=User_UserGroup_Asgn.f_code)})
public class User_UserGroup_Asgn extends AbstractAsgnModel<UserGroup> {
	
	public static final String ALIAS = "ad_User_UserGroup_Asgn";
	
	
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
	
	public User_UserGroup_Asgn() {
	}
	
	public User_UserGroup_Asgn(UserGroup e) {
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
