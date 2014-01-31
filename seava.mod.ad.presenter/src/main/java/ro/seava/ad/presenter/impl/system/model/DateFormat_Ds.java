/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.DateFormat;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeNTDs;

@Ds(entity = DateFormat.class, sort = {@SortField(field = DateFormat_Ds.f_name)})
public class DateFormat_Ds extends AbstractTypeNTDs<DateFormat> {

	public DateFormat_Ds() {
		super();
	}

	public DateFormat_Ds(DateFormat e) {
		super(e);
	}
}
