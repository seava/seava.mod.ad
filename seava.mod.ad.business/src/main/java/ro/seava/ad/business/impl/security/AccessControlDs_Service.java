/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.ad.business.api.security.IAccessControlDsService;
import ro.seava.ad.domain.impl.security.AccessControl;
import ro.seava.ad.domain.impl.security.AccessControlDs;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link AccessControlDs} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccessControlDs_Service
		extends
			AbstractEntityService<AccessControlDs>
		implements
			IAccessControlDsService {

	public AccessControlDs_Service() {
		super();
	}

	public AccessControlDs_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccessControlDs> getEntityClass() {
		return AccessControlDs.class;
	}
	/**
	 * Find by unique key
	 */
	public AccessControlDs findByUnique(AccessControl accessControl,
			String dsName) {
		return (AccessControlDs) this
				.getEntityManager()
				.createNamedQuery(AccessControlDs.NQ_FIND_BY_UNIQUE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControl", accessControl)
				.setParameter("dsName", dsName).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AccessControlDs findByUnique(Long accessControlId, String dsName) {
		return (AccessControlDs) this
				.getEntityManager()
				.createNamedQuery(AccessControlDs.NQ_FIND_BY_UNIQUE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControlId", accessControlId)
				.setParameter("dsName", dsName).getSingleResult();
	}
	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlDs> findByAccessControl(AccessControl accessControl) {
		return this.findByAccessControlId(accessControl.getId());
	}
	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlDs> findByAccessControlId(String accessControlId) {
		return (List<AccessControlDs>) this
				.getEntityManager()
				.createQuery(
						"select e from AccessControlDs e where e.clientId = :clientId and e.accessControl.id = :accessControlId",
						AccessControlDs.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControlId", accessControlId)
				.getResultList();
	}
}
