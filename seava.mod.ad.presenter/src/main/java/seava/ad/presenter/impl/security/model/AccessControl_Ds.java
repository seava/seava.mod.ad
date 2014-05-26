/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.AccessControl;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = AccessControl.class, sort = {@SortField(field = AccessControl_Ds.f_name)})
public class AccessControl_Ds extends AbstractType_Ds<AccessControl> {

	public static final String ALIAS = "ad_AccessControl_Ds";

	public AccessControl_Ds() {
		super();
	}

	public AccessControl_Ds(AccessControl e) {
		super(e);
	}
}
