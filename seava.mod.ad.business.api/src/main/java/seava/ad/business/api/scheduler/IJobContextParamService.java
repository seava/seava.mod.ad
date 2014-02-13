/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.scheduler;

import java.util.List;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobContextParam;

/**
 * Interface to expose business functions specific for {@link JobContextParam} domain
 * entity.
 */
public interface IJobContextParamService
		extends
			IEntityService<JobContextParam> {

	/**
	 * Find by unique key
	 */
	public JobContextParam findByName(JobContext jobContext, String paramName);

	/**
	 * Find by unique key
	 */
	public JobContextParam findByName(Long jobContextId, String paramName);

	/**
	 * Find by reference: jobContext
	 */
	public List<JobContextParam> findByJobContext(JobContext jobContext);

	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobContextParam> findByJobContextId(String jobContextId);
}
