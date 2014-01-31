/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.Menu;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeDs;

@Ds(entity = Menu.class, sort = {@SortField(field = Menu_Ds.f_name)})
public class Menu_Ds extends AbstractTypeDs<Menu> {
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_title = "title";

	@DsField
	private Integer sequenceNo;

	@DsField
	private String title;

	public Menu_Ds() {
		super();
	}

	public Menu_Ds(Menu e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
