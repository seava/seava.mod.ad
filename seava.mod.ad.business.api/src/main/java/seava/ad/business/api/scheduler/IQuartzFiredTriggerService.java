/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.scheduler;

import seava.ad.domain.impl.scheduler.QuartzFiredTrigger;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link QuartzFiredTrigger} domain
 * entity.
 */
public interface IQuartzFiredTriggerService
		extends
			IEntityService<QuartzFiredTrigger> {
}
