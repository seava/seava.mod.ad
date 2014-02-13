/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.scheduler.IQuartzPausedTriggerGroupService;
import seava.ad.domain.impl.scheduler.QuartzPausedTriggerGroup;

/**
 * Repository functionality for {@link QuartzPausedTriggerGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzPausedTriggerGroup_Service
		extends
			AbstractEntityService<QuartzPausedTriggerGroup>
		implements
			IQuartzPausedTriggerGroupService {

	public QuartzPausedTriggerGroup_Service() {
		super();
	}

	public QuartzPausedTriggerGroup_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzPausedTriggerGroup> getEntityClass() {
		return QuartzPausedTriggerGroup.class;
	}
}
