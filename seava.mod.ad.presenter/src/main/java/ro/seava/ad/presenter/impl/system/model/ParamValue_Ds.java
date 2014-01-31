/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import java.util.Date;
import ro.seava.ad.domain.impl.system.ParamValue;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.presenter.model.AbstractAuditableDs;

@Ds(entity = ParamValue.class)
public class ParamValue_Ds extends AbstractAuditableDs<ParamValue> {
	public static final String f_sysParam = "sysParam";
	public static final String f_value = "value";
	public static final String f_validFrom = "validFrom";
	public static final String f_validTo = "validTo";

	@DsField
	private String sysParam;

	@DsField
	private String value;

	@DsField
	private Date validFrom;

	@DsField
	private Date validTo;

	public ParamValue_Ds() {
		super();
	}

	public ParamValue_Ds(ParamValue e) {
		super(e);
	}

	public String getSysParam() {
		return this.sysParam;
	}

	public void setSysParam(String sysParam) {
		this.sysParam = sysParam;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
}
