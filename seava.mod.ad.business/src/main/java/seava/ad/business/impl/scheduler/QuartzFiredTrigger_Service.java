/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.scheduler.IQuartzFiredTriggerService;
import seava.ad.domain.impl.scheduler.QuartzFiredTrigger;

/**
 * Repository functionality for {@link QuartzFiredTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzFiredTrigger_Service
		extends
			AbstractEntityService<QuartzFiredTrigger>
		implements
			IQuartzFiredTriggerService {

	public QuartzFiredTrigger_Service() {
		super();
	}

	public QuartzFiredTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzFiredTrigger> getEntityClass() {
		return QuartzFiredTrigger.class;
	}
}
