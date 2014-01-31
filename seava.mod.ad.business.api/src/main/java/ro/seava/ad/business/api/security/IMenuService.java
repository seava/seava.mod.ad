/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.api.security;

import java.util.List;
import ro.seava.ad.domain.impl.security.Menu;
import ro.seava.ad.domain.impl.security.Role;
import ro.seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link Menu} domain
 * entity.
 */
public interface IMenuService extends IEntityService<Menu> {

	/**
	 * Find by unique key
	 */
	public Menu findByName(String name);

	/**
	 * Find by reference: roles
	 */
	public List<Menu> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<Menu> findByRolesId(String rolesId);
}
