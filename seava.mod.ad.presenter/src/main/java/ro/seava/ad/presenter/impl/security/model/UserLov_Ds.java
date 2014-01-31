/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.model;

import ro.seava.ad.domain.impl.security.User;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeWithCodeLov;

@Ds(entity = User.class, sort = {@SortField(field = UserLov_Ds.f_code)})
public class UserLov_Ds extends AbstractTypeWithCodeLov<User> {

	public UserLov_Ds() {
		super();
	}

	public UserLov_Ds(User e) {
		super(e);
	}
}
