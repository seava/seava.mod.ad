/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.system;

import java.util.List;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.system.Job;
import seava.ad.domain.impl.system.JobParam;

/**
 * Interface to expose business functions specific for {@link Job} domain
 * entity.
 */
public interface IJobService extends IEntityService<Job> {

	/**
	 * Find by unique key
	 */
	public Job findByName(String name);

	/**
	 * Find by unique key
	 */
	public Job findByJclass(String javaClass);

	/**
	 * Find by reference: params
	 */
	public List<Job> findByParams(JobParam params);

	/**
	 * Find by ID of reference: params.id
	 */
	public List<Job> findByParamsId(String paramsId);
}
