/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.scheduler.IQuartzCronTriggerService;
import seava.ad.domain.impl.scheduler.QuartzCronTrigger;

/**
 * Repository functionality for {@link QuartzCronTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzCronTrigger_Service
		extends
			AbstractEntityService<QuartzCronTrigger>
		implements
			IQuartzCronTriggerService {

	public QuartzCronTrigger_Service() {
		super();
	}

	public QuartzCronTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzCronTrigger> getEntityClass() {
		return QuartzCronTrigger.class;
	}
}
