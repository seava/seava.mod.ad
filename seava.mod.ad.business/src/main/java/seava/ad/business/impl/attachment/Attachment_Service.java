/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.attachment;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.domain.impl.attachment.Attachment;
import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link Attachment} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Attachment_Service extends AbstractEntityService<Attachment> {

	public Attachment_Service() {
		super();
	}

	public Attachment_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Attachment> getEntityClass() {
		return Attachment.class;
	}
	/**
	 * Find by reference: type
	 */
	public List<Attachment> findByType(AttachmentType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<Attachment> findByTypeId(String typeId) {
		return (List<Attachment>) this
				.getEntityManager()
				.createQuery(
						"select e from Attachment e where e.clientId = :clientId and e.type.id = :typeId",
						Attachment.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
}
