/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.scheduler;

import java.util.List;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobLog;
import seava.ad.domain.impl.scheduler.JobLogMessage;
import seava.ad.domain.impl.scheduler.JobTimer;

/**
 * Interface to expose business functions specific for {@link JobLog} domain
 * entity.
 */
public interface IJobLogService extends IEntityService<JobLog> {

	/**
	 * Find by reference: jobContext
	 */
	public List<JobLog> findByJobContext(JobContext jobContext);

	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobLog> findByJobContextId(String jobContextId);

	/**
	 * Find by reference: jobTimer
	 */
	public List<JobLog> findByJobTimer(JobTimer jobTimer);

	/**
	 * Find by ID of reference: jobTimer.id
	 */
	public List<JobLog> findByJobTimerId(String jobTimerId);

	/**
	 * Find by reference: messages
	 */
	public List<JobLog> findByMessages(JobLogMessage messages);

	/**
	 * Find by ID of reference: messages.id
	 */
	public List<JobLog> findByMessagesId(String messagesId);
}
