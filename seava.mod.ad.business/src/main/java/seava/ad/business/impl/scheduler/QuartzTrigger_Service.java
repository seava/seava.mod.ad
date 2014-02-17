/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import seava.ad.business.api.scheduler.IQuartzTriggerService;
import seava.ad.domain.impl.scheduler.QuartzTrigger;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link QuartzTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzTrigger_Service extends AbstractEntityService<QuartzTrigger>
		implements
			IQuartzTriggerService {

	public QuartzTrigger_Service() {
		super();
	}

	public QuartzTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzTrigger> getEntityClass() {
		return QuartzTrigger.class;
	}
}
