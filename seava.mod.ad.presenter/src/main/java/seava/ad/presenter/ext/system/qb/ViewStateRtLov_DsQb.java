/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package seava.ad.presenter.ext.system.qb;

import seava.ad.presenter.impl.system.model.ViewStateRtLov_Ds;
import seava.ad.presenter.impl.system.model.ViewStateRtLov_DsParam;
import seava.j4e.api.session.Session;
import seava.j4e.presenter.action.query.QueryBuilderWithJpql;

public class ViewStateRtLov_DsQb
		extends
		QueryBuilderWithJpql<ViewStateRtLov_Ds, ViewStateRtLov_Ds, ViewStateRtLov_DsParam> {

	@Override
	protected void beforeBuildWhere() throws Exception {
		String userCode = Session.user.get().getCode();

		if (this.params.getHideMine() != null
				&& this.params.getHideMine() == true) {
			addFilterCondition("  e.createdBy <> :userCode ");
			addCustomFilterItem("userCode", userCode);
		}

		if (this.params.getHideOthers() != null
				&& this.params.getHideOthers() == true) {
			addFilterCondition("  e.createdBy = :userCode ");
			addCustomFilterItem("userCode", userCode);
		}
	}

}
