/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.AccessControl;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeDs;

@Ds(entity = AccessControl.class, sort = {@SortField(field = AccessControl_Ds.f_name)})
public class AccessControl_Ds extends AbstractTypeDs<AccessControl> {

	public AccessControl_Ds() {
		super();
	}

	public AccessControl_Ds(AccessControl e) {
		super(e);
	}
}
