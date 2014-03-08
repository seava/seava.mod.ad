/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.attachment;

import java.util.List;
import seava.ad.domain.impl.attachment.Attachment;
import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link Attachment} domain
 * entity.
 */
public interface IAttachmentService extends IEntityService<Attachment> {

	/**
	 * Find by reference: type
	 */
	public List<Attachment> findByType(AttachmentType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Attachment> findByTypeId(String typeId);
}
