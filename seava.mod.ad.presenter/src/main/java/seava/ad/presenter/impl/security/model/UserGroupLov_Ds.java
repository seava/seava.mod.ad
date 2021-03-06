/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.UserGroup;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCodeLov_Ds;

@Ds(entity = UserGroup.class, sort = {@SortField(field = UserGroupLov_Ds.f_code)})
public class UserGroupLov_Ds extends AbstractTypeWithCodeLov_Ds<UserGroup> {

	public static final String ALIAS = "ad_UserGroupLov_Ds";

	public UserGroupLov_Ds() {
		super();
	}

	public UserGroupLov_Ds(UserGroup e) {
		super(e);
	}
}
