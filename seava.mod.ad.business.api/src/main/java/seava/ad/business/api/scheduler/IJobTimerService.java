/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.scheduler;

import java.util.List;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobTimer;

/**
 * Interface to expose business functions specific for {@link JobTimer} domain
 * entity.
 */
public interface IJobTimerService extends IEntityService<JobTimer> {

	/**
	 * Find by unique key
	 */
	public JobTimer findByName(JobContext jobContext, String name);

	/**
	 * Find by unique key
	 */
	public JobTimer findByName(Long jobContextId, String name);

	/**
	 * Find by reference: jobContext
	 */
	public List<JobTimer> findByJobContext(JobContext jobContext);

	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobTimer> findByJobContextId(String jobContextId);
}
