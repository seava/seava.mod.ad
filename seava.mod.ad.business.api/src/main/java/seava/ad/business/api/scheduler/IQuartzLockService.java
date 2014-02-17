/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.scheduler;

import seava.ad.domain.impl.scheduler.QuartzLock;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link QuartzLock} domain
 * entity.
 */
public interface IQuartzLockService extends IEntityService<QuartzLock> {
}
