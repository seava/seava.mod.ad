/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.attachment;

import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link AttachmentType} domain
 * entity.
 */
public interface IAttachmentTypeService extends IEntityService<AttachmentType> {

	/**
	 * Find by unique key
	 */
	public AttachmentType findByName(String name);
}
