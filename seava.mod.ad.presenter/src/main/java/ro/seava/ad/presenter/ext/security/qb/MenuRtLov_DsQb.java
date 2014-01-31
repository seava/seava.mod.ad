/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package ro.seava.ad.presenter.ext.security.qb;

import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import ro.seava.ad.presenter.impl.security.model.MenuRtLov_Ds;

public class MenuRtLov_DsQb extends
		QueryBuilderWithJpql<MenuRtLov_Ds, MenuRtLov_Ds, Object> {

	@Override
	protected void beforeBuildWhere() throws Exception {

		if (!Session.user.get().getProfile().isAdministrator()) {
			addFilterCondition("  e.id in ( select p.id from  Menu p, IN (p.roles) c where c.code in :pRoles )  ");
			this.addCustomFilterItem("pRoles", Session.user.get().getProfile()
					.getRoles());
		}
	}
}
