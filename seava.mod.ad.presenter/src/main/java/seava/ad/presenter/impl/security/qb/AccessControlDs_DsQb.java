/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.qb;

import seava.ad.presenter.impl.security.model.AccessControlDs_Ds;
import seava.ad.presenter.impl.security.model.AccessControlDs_DsParam;
import seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import seava.j4e.api.session.Session;

public class AccessControlDs_DsQb
		extends
			QueryBuilderWithJpql<AccessControlDs_Ds, AccessControlDs_Ds, AccessControlDs_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getWithRoleId() != null
				&& !"".equals(this.params.getWithRoleId())) {
			addFilterCondition("  e.accessControl.id in ( select p.id from  AccessControl p, IN (p.roles) c where c.id = :withRoleId )  ");
			addCustomFilterItem("withRoleId", this.params.getWithRoleId());
		}
	}
}
