/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.qb;

import ro.seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import seava.ad.presenter.impl.security.model.User_Ds;
import seava.ad.presenter.impl.security.model.User_DsParam;
import ro.seava.j4e.api.session.Session;

public class User_DsQb
		extends
			QueryBuilderWithJpql<User_Ds, User_Ds, User_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getWithRoleId() != null
				&& !"".equals(this.params.getWithRoleId())) {
			addFilterCondition("  e.id in ( select p.id from  User p, IN (p.roles) c where c.id = :withRoleId )  ");
			addCustomFilterItem("withRoleId", this.params.getWithRoleId());
		}
		if (this.params != null && this.params.getInGroupId() != null
				&& !"".equals(this.params.getInGroupId())) {
			addFilterCondition("  e.id in ( select p.id from  User p, IN (p.groups) c where c.id = :inGroupId )  ");
			addCustomFilterItem("inGroupId", this.params.getInGroupId());
		}
	}
}
