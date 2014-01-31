/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.system;

import javax.persistence.EntityManager;
import ro.seava.ad.business.api.system.IFrameExtensionService;
import ro.seava.ad.domain.impl.system.FrameExtension;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link FrameExtension} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FrameExtension_Service
		extends
			AbstractEntityService<FrameExtension>
		implements
			IFrameExtensionService {

	public FrameExtension_Service() {
		super();
	}

	public FrameExtension_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FrameExtension> getEntityClass() {
		return FrameExtension.class;
	}
	/**
	 * Find by unique key
	 */
	public FrameExtension findByName(String frame, String fileLocation) {
		return (FrameExtension) this
				.getEntityManager()
				.createNamedQuery(FrameExtension.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("frame", frame)
				.setParameter("fileLocation", fileLocation).getSingleResult();
	}
}
