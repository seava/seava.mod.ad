/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.api.scheduler;

import java.util.List;
import ro.seava.ad.domain.impl.scheduler.JobLog;
import ro.seava.ad.domain.impl.scheduler.JobLogMessage;
import ro.seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link JobLogMessage} domain
 * entity.
 */
public interface IJobLogMessageService extends IEntityService<JobLogMessage> {

	/**
	 * Find by reference: jobLog
	 */
	public List<JobLogMessage> findByJobLog(JobLog jobLog);

	/**
	 * Find by ID of reference: jobLog.id
	 */
	public List<JobLogMessage> findByJobLogId(String jobLogId);
}
