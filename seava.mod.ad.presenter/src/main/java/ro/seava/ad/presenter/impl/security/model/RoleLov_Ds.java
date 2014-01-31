/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.Role;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeWithCodeLov;

@Ds(entity = Role.class, sort = {@SortField(field = RoleLov_Ds.f_code)})
public class RoleLov_Ds extends AbstractTypeWithCodeLov<Role> {

	public RoleLov_Ds() {
		super();
	}

	public RoleLov_Ds(Role e) {
		super(e);
	}
}
