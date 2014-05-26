/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.AccessControl;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;

@Ds(entity = AccessControl.class, sort = {@SortField(field = AccessControlLov_Ds.f_name)})
public class AccessControlLov_Ds extends AbstractTypeLov_Ds<AccessControl> {

	public static final String ALIAS = "ad_AccessControlLov_Ds";

	public AccessControlLov_Ds() {
		super();
	}

	public AccessControlLov_Ds(AccessControl e) {
		super(e);
	}
}
