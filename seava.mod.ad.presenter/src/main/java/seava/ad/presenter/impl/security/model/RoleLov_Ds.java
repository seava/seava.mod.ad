/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.Role;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCodeLov_Ds;

@Ds(entity = Role.class, sort = {@SortField(field = RoleLov_Ds.f_code)})
public class RoleLov_Ds extends AbstractTypeWithCodeLov_Ds<Role> {

	public RoleLov_Ds() {
		super();
	}

	public RoleLov_Ds(Role e) {
		super(e);
	}
}
