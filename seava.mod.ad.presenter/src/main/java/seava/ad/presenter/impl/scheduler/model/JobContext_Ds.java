/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.scheduler.model;

import seava.ad.domain.impl.scheduler.JobContext;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = JobContext.class, sort = {@SortField(field = JobContext_Ds.f_name)})
public class JobContext_Ds extends AbstractType_Ds<JobContext> {

	public static final String ALIAS = "ad_JobContext_Ds";

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
