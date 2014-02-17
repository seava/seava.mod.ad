/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.ViewState;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = ViewState.class, sort = {@SortField(field = ViewState_Ds.f_name)})
public class ViewState_Ds extends AbstractType_Ds<ViewState> {
	public static final String f_cmp = "cmp";
	public static final String f_cmpType = "cmpType";
	public static final String f_value = "value";

	@DsField
	private String cmp;

	@DsField
	private String cmpType;

	@DsField
	private String value;

	public ViewState_Ds() {
		super();
	}

	public ViewState_Ds(ViewState e) {
		super(e);
	}

	public String getCmp() {
		return this.cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public String getCmpType() {
		return this.cmpType;
	}

	public void setCmpType(String cmpType) {
		this.cmpType = cmpType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
