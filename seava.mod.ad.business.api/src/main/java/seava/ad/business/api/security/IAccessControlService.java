/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.security;

import java.util.List;
import seava.ad.domain.impl.security.AccessControl;
import seava.ad.domain.impl.security.AccessControlDs;
import seava.ad.domain.impl.security.Role;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link AccessControl} domain
 * entity.
 */
public interface IAccessControlService extends IEntityService<AccessControl> {

	/**
	 * Find by unique key
	 */
	public AccessControl findByName(String name);

	/**
	 * Find by reference: dsRules
	 */
	public List<AccessControl> findByDsRules(AccessControlDs dsRules);

	/**
	 * Find by ID of reference: dsRules.id
	 */
	public List<AccessControl> findByDsRulesId(String dsRulesId);

	/**
	 * Find by reference: roles
	 */
	public List<AccessControl> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<AccessControl> findByRolesId(String rolesId);
}
