/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.JobParam;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeNTDs;

@Ds(entity = JobParam.class, sort = {@SortField(field = JobParam_Ds.f_name)})
public class JobParam_Ds extends AbstractTypeNTDs<JobParam> {
	public static final String f_dataType = "dataType";
	public static final String f_jobId = "jobId";
	public static final String f_job = "job";

	@DsField
	private String dataType;

	@DsField(join = "left", path = "job.id")
	private String jobId;

	@DsField(join = "left", path = "job.name")
	private String job;

	public JobParam_Ds() {
		super();
	}

	public JobParam_Ds(JobParam e) {
		super(e);
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
