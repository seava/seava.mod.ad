/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.impl.model.AbstractTypeNTLov_Ds;
import seava.ad.domain.impl.system.DateFormat;

@Ds(entity = DateFormat.class, sort = {@SortField(field = DateFormatLov_Ds.f_name)})
public class DateFormatLov_Ds extends AbstractTypeNTLov_Ds<DateFormat> {

	public DateFormatLov_Ds() {
		super();
	}

	public DateFormatLov_Ds(DateFormat e) {
		super(e);
	}
}
