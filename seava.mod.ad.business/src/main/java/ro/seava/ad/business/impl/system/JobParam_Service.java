/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.ad.business.api.system.IJobParamService;
import ro.seava.ad.domain.impl.system.Job;
import ro.seava.ad.domain.impl.system.JobParam;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link JobParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobParam_Service extends AbstractEntityService<JobParam>
		implements
			IJobParamService {

	public JobParam_Service() {
		super();
	}

	public JobParam_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobParam> getEntityClass() {
		return JobParam.class;
	}
	/**
	 * Find by unique key
	 */
	public JobParam findByName(Job job, String name) {
		return (JobParam) this.getEntityManager()
				.createNamedQuery(JobParam.NQ_FIND_BY_NAME)
				.setParameter("job", job).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public JobParam findByName(Long jobId, String name) {
		return (JobParam) this.getEntityManager()
				.createNamedQuery(JobParam.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("jobId", jobId).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by reference: job
	 */
	public List<JobParam> findByJob(Job job) {
		return this.findByJobId(job.getId());
	}
	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobParam> findByJobId(String jobId) {
		return (List<JobParam>) this
				.getEntityManager()
				.createQuery(
						"select e from JobParam e where  e.job.id = :jobId",
						JobParam.class).setParameter("jobId", jobId)
				.getResultList();
	}
}
