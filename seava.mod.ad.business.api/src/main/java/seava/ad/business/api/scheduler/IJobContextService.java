/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.scheduler;

import java.util.List;
import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobContextParam;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link JobContext} domain
 * entity.
 */
public interface IJobContextService extends IEntityService<JobContext> {

	/**
	 * Find by unique key
	 */
	public JobContext findByName(String name);

	/**
	 * Find by reference: params
	 */
	public List<JobContext> findByParams(JobContextParam params);

	/**
	 * Find by ID of reference: params.id
	 */
	public List<JobContext> findByParamsId(String paramsId);
}
