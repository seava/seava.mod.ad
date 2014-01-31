/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.api.scheduler;

import ro.seava.ad.domain.impl.scheduler.QuartzBlobTrigger;
import ro.seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link QuartzBlobTrigger} domain
 * entity.
 */
public interface IQuartzBlobTriggerService
		extends
			IEntityService<QuartzBlobTrigger> {
}
