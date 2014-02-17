/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.Job;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeNTLov_Ds;

@Ds(entity = Job.class, sort = {@SortField(field = JobLov_Ds.f_name)})
public class JobLov_Ds extends AbstractTypeNTLov_Ds<Job> {

	public JobLov_Ds() {
		super();
	}

	public JobLov_Ds(Job e) {
		super(e);
	}
}
