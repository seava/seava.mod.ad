/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.scheduler;

import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.scheduler.QuartzCronTrigger;

/**
 * Interface to expose business functions specific for {@link QuartzCronTrigger} domain
 * entity.
 */
public interface IQuartzCronTriggerService
		extends
			IEntityService<QuartzCronTrigger> {
}
