/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import seava.ad.business.api.scheduler.IQuartzLockService;
import seava.ad.domain.impl.scheduler.QuartzLock;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link QuartzLock} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzLock_Service extends AbstractEntityService<QuartzLock>
		implements
			IQuartzLockService {

	public QuartzLock_Service() {
		super();
	}

	public QuartzLock_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzLock> getEntityClass() {
		return QuartzLock.class;
	}
}
