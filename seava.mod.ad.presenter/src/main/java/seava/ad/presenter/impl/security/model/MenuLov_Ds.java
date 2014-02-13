/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;
import seava.ad.domain.impl.security.Menu;

@Ds(entity = Menu.class, sort = {@SortField(field = MenuLov_Ds.f_name)})
public class MenuLov_Ds extends AbstractTypeLov_Ds<Menu> {
	public static final String f_title = "title";

	@DsField
	private String title;

	public MenuLov_Ds() {
		super();
	}

	public MenuLov_Ds(Menu e) {
		super(e);
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
