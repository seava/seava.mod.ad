/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.ad.business.api.scheduler.IQuartzSchedulerStateService;
import ro.seava.ad.domain.impl.scheduler.QuartzSchedulerState;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link QuartzSchedulerState} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSchedulerState_Service
		extends
			AbstractEntityService<QuartzSchedulerState>
		implements
			IQuartzSchedulerStateService {

	public QuartzSchedulerState_Service() {
		super();
	}

	public QuartzSchedulerState_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSchedulerState> getEntityClass() {
		return QuartzSchedulerState.class;
	}
}
