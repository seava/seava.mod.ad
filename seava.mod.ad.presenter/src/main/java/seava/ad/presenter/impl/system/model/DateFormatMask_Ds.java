/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.DateFormat;
import seava.ad.domain.impl.system.DateFormatMask;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractAuditableNT_Ds;

@Ds(entity = DateFormatMask.class, sort = {
		@SortField(field = DateFormatMask_Ds.f_dateFormat),
		@SortField(field = DateFormatMask_Ds.f_mask)})
@RefLookups({@RefLookup(refId = DateFormatMask_Ds.f_dateFormatId, namedQuery = DateFormat.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = DateFormatMask_Ds.f_dateFormat)})})
public class DateFormatMask_Ds extends AbstractAuditableNT_Ds<DateFormatMask> {

	public static final String ALIAS = "ad_DateFormatMask_Ds";

	public static final String f_mask = "mask";
	public static final String f_value = "value";
	public static final String f_dateFormatId = "dateFormatId";
	public static final String f_dateFormat = "dateFormat";

	@DsField
	private String mask;

	@DsField
	private String value;

	@DsField(join = "left", path = "dateFormat.id")
	private String dateFormatId;

	@DsField(join = "left", path = "dateFormat.name")
	private String dateFormat;

	public DateFormatMask_Ds() {
		super();
	}

	public DateFormatMask_Ds(DateFormatMask e) {
		super(e);
	}

	public String getMask() {
		return this.mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDateFormatId() {
		return this.dateFormatId;
	}

	public void setDateFormatId(String dateFormatId) {
		this.dateFormatId = dateFormatId;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
