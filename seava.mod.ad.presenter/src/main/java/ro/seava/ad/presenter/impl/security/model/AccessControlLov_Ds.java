/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.AccessControl;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeLov;

@Ds(entity = AccessControl.class, sort = {@SortField(field = AccessControlLov_Ds.f_name)})
public class AccessControlLov_Ds extends AbstractTypeLov<AccessControl> {

	public AccessControlLov_Ds() {
		super();
	}

	public AccessControlLov_Ds(AccessControl e) {
		super(e);
	}
}
