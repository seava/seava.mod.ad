/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.MenuItem;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;

@Ds(entity = MenuItem.class, sort = {@SortField(field = MenuItemLov_Ds.f_name)})
public class MenuItemLov_Ds extends AbstractTypeLov_Ds<MenuItem> {

	public static final String ALIAS = "ad_MenuItemLov_Ds";

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
