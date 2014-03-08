/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.attachment;

import javax.persistence.EntityManager;
import seava.ad.business.api.attachment.IAttachmentTypeService;
import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link AttachmentType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttachmentType_Service
		extends
			AbstractEntityService<AttachmentType>
		implements
			IAttachmentTypeService {

	public AttachmentType_Service() {
		super();
	}

	public AttachmentType_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttachmentType> getEntityClass() {
		return AttachmentType.class;
	}
	/**
	 * Find by unique key
	 */
	public AttachmentType findByName(String name) {
		return (AttachmentType) this
				.getEntityManager()
				.createNamedQuery(AttachmentType.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
