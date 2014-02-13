/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.scheduler.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;
import seava.ad.domain.impl.scheduler.JobContext;

@Ds(entity = JobContext.class, sort = {@SortField(field = JobContextLov_Ds.f_name)})
public class JobContextLov_Ds extends AbstractTypeLov_Ds<JobContext> {
	public static final String f_jobName = "jobName";

	@DsField
	private String jobName;

	public JobContextLov_Ds() {
		super();
	}

	public JobContextLov_Ds(JobContext e) {
		super(e);
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
