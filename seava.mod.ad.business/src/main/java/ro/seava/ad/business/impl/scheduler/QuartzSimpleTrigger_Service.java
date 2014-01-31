/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.ad.business.api.scheduler.IQuartzSimpleTriggerService;
import ro.seava.ad.domain.impl.scheduler.QuartzSimpleTrigger;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link QuartzSimpleTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSimpleTrigger_Service
		extends
			AbstractEntityService<QuartzSimpleTrigger>
		implements
			IQuartzSimpleTriggerService {

	public QuartzSimpleTrigger_Service() {
		super();
	}

	public QuartzSimpleTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSimpleTrigger> getEntityClass() {
		return QuartzSimpleTrigger.class;
	}
}
