/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.UserGroup;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeWithCodeDs;

@Ds(entity = UserGroup.class, sort = {@SortField(field = UserGroup_Ds.f_code)})
public class UserGroup_Ds extends AbstractTypeWithCodeDs<UserGroup> {

	public UserGroup_Ds() {
		super();
	}

	public UserGroup_Ds(UserGroup e) {
		super(e);
	}
}
