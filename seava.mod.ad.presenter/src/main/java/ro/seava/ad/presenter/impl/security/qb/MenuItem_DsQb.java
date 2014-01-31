/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.security.qb;

import ro.seava.ad.presenter.impl.security.model.MenuItem_Ds;
import ro.seava.ad.presenter.impl.security.model.MenuItem_DsParam;
import ro.seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import ro.seava.j4e.api.session.Session;

public class MenuItem_DsQb
		extends
			QueryBuilderWithJpql<MenuItem_Ds, MenuItem_Ds, MenuItem_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getFoldersOnly() != null
				&& !"".equals(this.params.getFoldersOnly())) {
			addFilterCondition("  (  (:foldersOnly = false  ) or (e.frame is null ) ) ");
			addCustomFilterItem("foldersOnly", this.params.getFoldersOnly());
		}
		if (this.params != null && this.params.getFramesOnly() != null
				&& !"".equals(this.params.getFramesOnly())) {
			addFilterCondition("  (  (:framesOnly = false  ) or (e.frame is not  null ) ) ");
			addCustomFilterItem("framesOnly", this.params.getFramesOnly());
		}
	}
}
