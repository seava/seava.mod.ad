/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.system;

import seava.ad.domain.impl.system.FrameExtension;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link FrameExtension} domain
 * entity.
 */
public interface IFrameExtensionService extends IEntityService<FrameExtension> {

	/**
	 * Find by unique key
	 */
	public FrameExtension findByName(String frame, String fileLocation);
}
