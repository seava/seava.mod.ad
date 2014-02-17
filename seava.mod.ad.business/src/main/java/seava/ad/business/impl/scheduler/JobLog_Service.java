/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.scheduler.IJobLogService;
import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobLog;
import seava.ad.domain.impl.scheduler.JobLogMessage;
import seava.ad.domain.impl.scheduler.JobTimer;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link JobLog} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobLog_Service extends AbstractEntityService<JobLog>
		implements
			IJobLogService {

	public JobLog_Service() {
		super();
	}

	public JobLog_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobLog> getEntityClass() {
		return JobLog.class;
	}
	/**
	 * Find by reference: jobContext
	 */
	public List<JobLog> findByJobContext(JobContext jobContext) {
		return this.findByJobContextId(jobContext.getId());
	}
	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobLog> findByJobContextId(String jobContextId) {
		return (List<JobLog>) this
				.getEntityManager()
				.createQuery(
						"select e from JobLog e where e.clientId = :clientId and e.jobContext.id = :jobContextId",
						JobLog.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobContextId", jobContextId).getResultList();
	}
	/**
	 * Find by reference: jobTimer
	 */
	public List<JobLog> findByJobTimer(JobTimer jobTimer) {
		return this.findByJobTimerId(jobTimer.getId());
	}
	/**
	 * Find by ID of reference: jobTimer.id
	 */
	public List<JobLog> findByJobTimerId(String jobTimerId) {
		return (List<JobLog>) this
				.getEntityManager()
				.createQuery(
						"select e from JobLog e where e.clientId = :clientId and e.jobTimer.id = :jobTimerId",
						JobLog.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobTimerId", jobTimerId).getResultList();
	}
	/**
	 * Find by reference: messages
	 */
	public List<JobLog> findByMessages(JobLogMessage messages) {
		return this.findByMessagesId(messages.getId());
	}
	/**
	 * Find by ID of reference: messages.id
	 */
	public List<JobLog> findByMessagesId(String messagesId) {
		return (List<JobLog>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from JobLog e, IN (e.messages) c where e.clientId = :clientId and c.id = :messagesId",
						JobLog.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("messagesId", messagesId).getResultList();
	}
}
