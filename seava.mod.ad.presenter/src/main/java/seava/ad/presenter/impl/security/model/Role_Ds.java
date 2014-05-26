/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.Role;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCode_Ds;

@Ds(entity = Role.class, sort = {@SortField(field = Role_Ds.f_code)})
public class Role_Ds extends AbstractTypeWithCode_Ds<Role> {

	public static final String ALIAS = "ad_Role_Ds";

	public Role_Ds() {
		super();
	}

	public Role_Ds(Role e) {
		super(e);
	}
}
