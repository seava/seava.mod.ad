/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.impl.model.AbstractTypeWithCode_Ds;
import seava.ad.domain.impl.security.UserGroup;

@Ds(entity = UserGroup.class, sort = {@SortField(field = UserGroup_Ds.f_code)})
public class UserGroup_Ds extends AbstractTypeWithCode_Ds<UserGroup> {

	public UserGroup_Ds() {
		super();
	}

	public UserGroup_Ds(UserGroup e) {
		super(e);
	}
}
