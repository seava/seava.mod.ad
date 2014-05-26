/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.scheduler.model;

import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobContextParam;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = JobContextParam.class)
@RefLookups({@RefLookup(refId = JobContextParam_Ds.f_jobContextId, namedQuery = JobContext.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = JobContextParam_Ds.f_jobContext)})})
public class JobContextParam_Ds extends AbstractAuditable_Ds<JobContextParam> {

	public static final String ALIAS = "ad_JobContextParam_Ds";

	public static final String f_paramName = "paramName";
	public static final String f_dataType = "dataType";
	public static final String f_value = "value";
	public static final String f_jobContextId = "jobContextId";
	public static final String f_jobContext = "jobContext";
	public static final String f_jobName = "jobName";

	@DsField
	private String paramName;

	@DsField
	private String dataType;

	@DsField
	private String value;

	@DsField(join = "left", path = "jobContext.id")
	private String jobContextId;

	@DsField(join = "left", path = "jobContext.name")
	private String jobContext;

	@DsField(join = "left", path = "jobContext.jobName")
	private String jobName;

	public JobContextParam_Ds() {
		super();
	}

	public JobContextParam_Ds(JobContextParam e) {
		super(e);
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getJobContextId() {
		return this.jobContextId;
	}

	public void setJobContextId(String jobContextId) {
		this.jobContextId = jobContextId;
	}

	public String getJobContext() {
		return this.jobContext;
	}

	public void setJobContext(String jobContext) {
		this.jobContext = jobContext;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
