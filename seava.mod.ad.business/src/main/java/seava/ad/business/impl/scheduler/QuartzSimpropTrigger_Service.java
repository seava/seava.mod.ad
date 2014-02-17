/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import seava.ad.business.api.scheduler.IQuartzSimpropTriggerService;
import seava.ad.domain.impl.scheduler.QuartzSimpropTrigger;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link QuartzSimpropTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSimpropTrigger_Service
		extends
			AbstractEntityService<QuartzSimpropTrigger>
		implements
			IQuartzSimpropTriggerService {

	public QuartzSimpropTrigger_Service() {
		super();
	}

	public QuartzSimpropTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSimpropTrigger> getEntityClass() {
		return QuartzSimpropTrigger.class;
	}
}
