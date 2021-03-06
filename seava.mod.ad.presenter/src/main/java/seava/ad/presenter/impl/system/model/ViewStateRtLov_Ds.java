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
import seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;

@Ds(entity = ViewState.class, sort = {@SortField(field = ViewStateRtLov_Ds.f_name)})
public class ViewStateRtLov_Ds extends AbstractTypeLov_Ds<ViewState> {

	public static final String ALIAS = "ad_ViewStateRtLov_Ds";

	public static final String f_cmp = "cmp";
	public static final String f_cmpType = "cmpType";
	public static final String f_value = "value";
	public static final String f_owner = "owner";

	@DsField
	private String cmp;

	@DsField
	private String cmpType;

	@DsField
	private String value;

	@DsField(path = "createdBy")
	private String owner;

	public ViewStateRtLov_Ds() {
		super();
	}

	public ViewStateRtLov_Ds(ViewState e) {
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

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
