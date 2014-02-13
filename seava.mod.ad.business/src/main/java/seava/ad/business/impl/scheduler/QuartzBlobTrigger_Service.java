/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.scheduler.IQuartzBlobTriggerService;
import seava.ad.domain.impl.scheduler.QuartzBlobTrigger;

/**
 * Repository functionality for {@link QuartzBlobTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzBlobTrigger_Service
		extends
			AbstractEntityService<QuartzBlobTrigger>
		implements
			IQuartzBlobTriggerService {

	public QuartzBlobTrigger_Service() {
		super();
	}

	public QuartzBlobTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzBlobTrigger> getEntityClass() {
		return QuartzBlobTrigger.class;
	}
}
