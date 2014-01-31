/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.Job;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeNTLov;

@Ds(entity = Job.class, sort = {@SortField(field = JobLov_Ds.f_name)})
public class JobLov_Ds extends AbstractTypeNTLov<Job> {

	public JobLov_Ds() {
		super();
	}

	public JobLov_Ds(Job e) {
		super(e);
	}
}
