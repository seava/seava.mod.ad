/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.UserGroup;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeWithCodeLov;

@Ds(entity = UserGroup.class, sort = {@SortField(field = UserGroupLov_Ds.f_code)})
public class UserGroupLov_Ds extends AbstractTypeWithCodeLov<UserGroup> {

	public UserGroupLov_Ds() {
		super();
	}

	public UserGroupLov_Ds(UserGroup e) {
		super(e);
	}
}
