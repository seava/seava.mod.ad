/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.JobParam;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeNT_Ds;

@Ds(entity = JobParam.class, sort = {@SortField(field = JobParamLov_Ds.f_name)})
public class JobParamLov_Ds extends AbstractTypeNT_Ds<JobParam> {

	public static final String ALIAS = "ad_JobParamLov_Ds";

	public JobParamLov_Ds() {
		super();
	}

	public JobParamLov_Ds(JobParam e) {
		super(e);
	}
}
