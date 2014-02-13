/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.qb;

import ro.seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import seava.ad.presenter.impl.system.model.MyClient_Ds;
import ro.seava.j4e.api.session.Session;

public class MyClient_DsQb
		extends
			QueryBuilderWithJpql<MyClient_Ds, MyClient_Ds, Object> {

	@Override
	public void setFilter(MyClient_Ds filter) {
		filter.setId(Session.user.get().getClientId());
		super.setFilter(filter);
	}
}
