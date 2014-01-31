/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.MenuItem;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeLov;

@Ds(entity = MenuItem.class, sort = {@SortField(field = MenuItemLov_Ds.f_name)})
public class MenuItemLov_Ds extends AbstractTypeLov<MenuItem> {
	public static final String f_title = "title";

	@DsField
	private String title;

	public MenuItemLov_Ds() {
		super();
	}

	public MenuItemLov_Ds(MenuItem e) {
		super(e);
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
