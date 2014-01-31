/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.scheduler.model;

import ro.seava.ad.domain.impl.scheduler.JobContext;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeDs;

@Ds(entity = JobContext.class, sort = {@SortField(field = JobContext_Ds.f_name)})
public class JobContext_Ds extends AbstractTypeDs<JobContext> {
	public static final String f_jobName = "jobName";

	@DsField(noUpdate = true)
	private String jobName;

	public JobContext_Ds() {
		super();
	}

	public JobContext_Ds(JobContext e) {
		super(e);
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
