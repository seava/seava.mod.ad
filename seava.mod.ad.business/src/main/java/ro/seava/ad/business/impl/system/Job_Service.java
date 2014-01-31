/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.ad.business.api.system.IJobService;
import ro.seava.ad.domain.impl.system.Job;
import ro.seava.ad.domain.impl.system.JobParam;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link Job} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Job_Service extends AbstractEntityService<Job>
		implements
			IJobService {

	public Job_Service() {
		super();
	}

	public Job_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Job> getEntityClass() {
		return Job.class;
	}
	/**
	 * Find by unique key
	 */
	public Job findByName(String name) {
		return (Job) this.getEntityManager()
				.createNamedQuery(Job.NQ_FIND_BY_NAME)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Job findByJclass(String javaClass) {
		return (Job) this.getEntityManager()
				.createNamedQuery(Job.NQ_FIND_BY_JCLASS)
				.setParameter("javaClass", javaClass).getSingleResult();
	}
	/**
	 * Find by reference: params
	 */
	public List<Job> findByParams(JobParam params) {
		return this.findByParamsId(params.getId());
	}
	/**
	 * Find by ID of reference: params.id
	 */
	public List<Job> findByParamsId(String paramsId) {
		return (List<Job>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Job e, IN (e.params) c where  c.id = :paramsId",
						Job.class).setParameter("paramsId", paramsId)
				.getResultList();
	}
}
