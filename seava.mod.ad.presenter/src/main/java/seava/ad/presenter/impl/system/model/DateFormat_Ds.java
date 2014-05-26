/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.DateFormat;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeNT_Ds;

@Ds(entity = DateFormat.class, sort = {@SortField(field = DateFormat_Ds.f_name)})
public class DateFormat_Ds extends AbstractTypeNT_Ds<DateFormat> {

	public static final String ALIAS = "ad_DateFormat_Ds";

	public DateFormat_Ds() {
		super();
	}

	public DateFormat_Ds(DateFormat e) {
		super(e);
	}
}
