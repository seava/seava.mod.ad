/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.qb;

import ro.seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import seava.ad.presenter.impl.system.model.ParamValue_Ds;
import seava.ad.presenter.impl.system.model.ParamValue_DsParam;
import ro.seava.j4e.api.session.Session;

public class ParamValue_DsQb
		extends
			QueryBuilderWithJpql<ParamValue_Ds, ParamValue_Ds, ParamValue_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getValidAt() != null
				&& !"".equals(this.params.getValidAt())) {
			addFilterCondition("  :validAt between e.validFrom and e.validTo ");
			addCustomFilterItem("validAt", this.params.getValidAt());
		}
	}
}
