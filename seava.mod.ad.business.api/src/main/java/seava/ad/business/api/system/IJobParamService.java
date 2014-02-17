/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.system;

import java.util.List;
import seava.ad.domain.impl.system.Job;
import seava.ad.domain.impl.system.JobParam;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link JobParam} domain
 * entity.
 */
public interface IJobParamService extends IEntityService<JobParam> {

	/**
	 * Find by unique key
	 */
	public JobParam findByName(Job job, String name);

	/**
	 * Find by unique key
	 */
	public JobParam findByName(Long jobId, String name);

	/**
	 * Find by reference: job
	 */
	public List<JobParam> findByJob(Job job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobParam> findByJobId(String jobId);
}
