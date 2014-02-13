/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.security;

import java.util.List;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.security.Menu;
import seava.ad.domain.impl.security.MenuItem;
import seava.ad.domain.impl.security.Role;

/**
 * Interface to expose business functions specific for {@link MenuItem} domain
 * entity.
 */
public interface IMenuItemService extends IEntityService<MenuItem> {

	/**
	 * Find by unique key
	 */
	public MenuItem findByName(String name);

	/**
	 * Find by reference: menuItem
	 */
	public List<MenuItem> findByMenuItem(MenuItem menuItem);

	/**
	 * Find by ID of reference: menuItem.id
	 */
	public List<MenuItem> findByMenuItemId(String menuItemId);

	/**
	 * Find by reference: menu
	 */
	public List<MenuItem> findByMenu(Menu menu);

	/**
	 * Find by ID of reference: menu.id
	 */
	public List<MenuItem> findByMenuId(String menuId);

	/**
	 * Find by reference: roles
	 */
	public List<MenuItem> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<MenuItem> findByRolesId(String rolesId);
}
