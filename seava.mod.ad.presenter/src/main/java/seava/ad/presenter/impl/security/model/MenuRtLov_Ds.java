/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.Menu;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;

@Ds(entity = Menu.class, sort = {@SortField(field = MenuRtLov_Ds.f_sequenceNo)})
public class MenuRtLov_Ds extends AbstractTypeLov_Ds<Menu> {

	public static final String ALIAS = "ad_MenuRtLov_Ds";

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_title = "title";
	public static final String f_tag = "tag";

	@DsField
	private Integer sequenceNo;

	@DsField
	private String title;

	@DsField
	private String tag;

	public MenuRtLov_Ds() {
		super();
	}

	public MenuRtLov_Ds(Menu e) {
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

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
