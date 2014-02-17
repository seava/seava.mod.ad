/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.User;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCodeLov_Ds;

@Ds(entity = User.class, sort = {@SortField(field = UserLov_Ds.f_code)})
public class UserLov_Ds extends AbstractTypeWithCodeLov_Ds<User> {

	public UserLov_Ds() {
		super();
	}

	public UserLov_Ds(User e) {
		super(e);
	}
}
