/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.qb;

import ro.seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import seava.ad.presenter.impl.security.model.MyUser_Ds;
import ro.seava.j4e.api.session.Session;

public class MyUser_DsQb
		extends
			QueryBuilderWithJpql<MyUser_Ds, MyUser_Ds, Object> {

	@Override
	public void setFilter(MyUser_Ds filter) {
		filter.setCode(Session.user.get().getCode());
		super.setFilter(filter);
	}
}
