/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.security.IAccessControlService;
import seava.ad.domain.impl.security.AccessControl;
import seava.ad.domain.impl.security.AccessControlDs;
import seava.ad.domain.impl.security.Role;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link AccessControl} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccessControl_Service extends AbstractEntityService<AccessControl>
		implements
			IAccessControlService {

	public AccessControl_Service() {
		super();
	}

	public AccessControl_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccessControl> getEntityClass() {
		return AccessControl.class;
	}
	/**
	 * Find by unique key
	 */
	public AccessControl findByName(String name) {
		return (AccessControl) this
				.getEntityManager()
				.createNamedQuery(AccessControl.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: dsRules
	 */
	public List<AccessControl> findByDsRules(AccessControlDs dsRules) {
		return this.findByDsRulesId(dsRules.getId());
	}
	/**
	 * Find by ID of reference: dsRules.id
	 */
	public List<AccessControl> findByDsRulesId(String dsRulesId) {
		return (List<AccessControl>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from AccessControl e, IN (e.dsRules) c where e.clientId = :clientId and c.id = :dsRulesId",
						AccessControl.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("dsRulesId", dsRulesId).getResultList();
	}
	/**
	 * Find by reference: roles
	 */
	public List<AccessControl> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}
	/**
	 * Find by ID of reference: roles.id
	 */
	public List<AccessControl> findByRolesId(String rolesId) {
		return (List<AccessControl>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from AccessControl e, IN (e.roles) c where e.clientId = :clientId and c.id = :rolesId",
						AccessControl.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("rolesId", rolesId).getResultList();
	}
}
