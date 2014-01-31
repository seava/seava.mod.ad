/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.JobParam;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeNTDs;

@Ds(entity = JobParam.class, sort = {@SortField(field = JobParamLov_Ds.f_name)})
public class JobParamLov_Ds extends AbstractTypeNTDs<JobParam> {

	public JobParamLov_Ds() {
		super();
	}

	public JobParamLov_Ds(JobParam e) {
		super(e);
	}
}
