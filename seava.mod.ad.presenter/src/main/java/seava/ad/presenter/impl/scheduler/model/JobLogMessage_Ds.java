/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.scheduler.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.presenter.impl.model.AbstractAuditable_Ds;
import seava.ad.domain.impl.scheduler.JobLogMessage;

@Ds(entity = JobLogMessage.class)
public class JobLogMessage_Ds extends AbstractAuditable_Ds<JobLogMessage> {
	public static final String f_messageType = "messageType";
	public static final String f_message = "message";
	public static final String f_jobLogId = "jobLogId";

	@DsField
	private String messageType;

	@DsField
	private String message;

	@DsField(join = "left", path = "jobLog.id")
	private String jobLogId;

	public JobLogMessage_Ds() {
		super();
	}

	public JobLogMessage_Ds(JobLogMessage e) {
		super(e);
	}

	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJobLogId() {
		return this.jobLogId;
	}

	public void setJobLogId(String jobLogId) {
		this.jobLogId = jobLogId;
	}
}
