/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.scheduler.model;

import java.util.Date;
import seava.ad.domain.impl.scheduler.JobLog;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = JobLog.class, sort = {@SortField(field = JobLog_Ds.f_startTime, desc = true)})
public class JobLog_Ds extends AbstractAuditable_Ds<JobLog> {

	public static final String ALIAS = "ad_JobLog_Ds";

	public static final String f_startTime = "startTime";
	public static final String f_endTime = "endTime";
	public static final String f_jobContextId = "jobContextId";
	public static final String f_jobContext = "jobContext";
	public static final String f_jobName = "jobName";
	public static final String f_jobTimerId = "jobTimerId";
	public static final String f_jobTimer = "jobTimer";

	@DsField
	private Date startTime;

	@DsField
	private Date endTime;

	@DsField(join = "left", path = "jobContext.id")
	private String jobContextId;

	@DsField(join = "left", path = "jobContext.name")
	private String jobContext;

	@DsField(join = "left", path = "jobContext.jobName")
	private String jobName;

	@DsField(join = "left", path = "jobTimer.id")
	private String jobTimerId;

	@DsField(join = "left", path = "jobTimer.name")
	private String jobTimer;

	public JobLog_Ds() {
		super();
	}

	public JobLog_Ds(JobLog e) {
		super(e);
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public String getJobTimerId() {
		return this.jobTimerId;
	}

	public void setJobTimerId(String jobTimerId) {
		this.jobTimerId = jobTimerId;
	}

	public String getJobTimer() {
		return this.jobTimer;
	}

	public void setJobTimer(String jobTimer) {
		this.jobTimer = jobTimer;
	}
}
