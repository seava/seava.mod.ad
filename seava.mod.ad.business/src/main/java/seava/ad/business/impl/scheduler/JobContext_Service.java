/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.domain.impl.scheduler.JobContext;
import seava.ad.domain.impl.scheduler.JobContextParam;

/**
 * Repository functionality for {@link JobContext} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobContext_Service extends AbstractEntityService<JobContext> {

	public JobContext_Service() {
		super();
	}

	public JobContext_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobContext> getEntityClass() {
		return JobContext.class;
	}
	/**
	 * Find by unique key
	 */
	public JobContext findByName(String name) {
		return (JobContext) this
				.getEntityManager()
				.createNamedQuery(JobContext.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: params
	 */
	public List<JobContext> findByParams(JobContextParam params) {
		return this.findByParamsId(params.getId());
	}
	/**
	 * Find by ID of reference: params.id
	 */
	public List<JobContext> findByParamsId(String paramsId) {
		return (List<JobContext>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from JobContext e, IN (e.params) c where e.clientId = :clientId and c.id = :paramsId",
						JobContext.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("paramsId", paramsId).getResultList();
	}
}
