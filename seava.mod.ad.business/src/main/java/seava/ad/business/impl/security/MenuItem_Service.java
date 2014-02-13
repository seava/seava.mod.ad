/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.security.IMenuItemService;
import seava.ad.domain.impl.security.Menu;
import seava.ad.domain.impl.security.MenuItem;
import seava.ad.domain.impl.security.Role;

/**
 * Repository functionality for {@link MenuItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class MenuItem_Service extends AbstractEntityService<MenuItem>
		implements
			IMenuItemService {

	public MenuItem_Service() {
		super();
	}

	public MenuItem_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<MenuItem> getEntityClass() {
		return MenuItem.class;
	}
	/**
	 * Find by unique key
	 */
	public MenuItem findByName(String name) {
		return (MenuItem) this
				.getEntityManager()
				.createNamedQuery(MenuItem.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: menuItem
	 */
	public List<MenuItem> findByMenuItem(MenuItem menuItem) {
		return this.findByMenuItemId(menuItem.getId());
	}
	/**
	 * Find by ID of reference: menuItem.id
	 */
	public List<MenuItem> findByMenuItemId(String menuItemId) {
		return (List<MenuItem>) this
				.getEntityManager()
				.createQuery(
						"select e from MenuItem e where e.clientId = :clientId and e.menuItem.id = :menuItemId",
						MenuItem.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("menuItemId", menuItemId).getResultList();
	}
	/**
	 * Find by reference: menu
	 */
	public List<MenuItem> findByMenu(Menu menu) {
		return this.findByMenuId(menu.getId());
	}
	/**
	 * Find by ID of reference: menu.id
	 */
	public List<MenuItem> findByMenuId(String menuId) {
		return (List<MenuItem>) this
				.getEntityManager()
				.createQuery(
						"select e from MenuItem e where e.clientId = :clientId and e.menu.id = :menuId",
						MenuItem.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("menuId", menuId).getResultList();
	}
	/**
	 * Find by reference: roles
	 */
	public List<MenuItem> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}
	/**
	 * Find by ID of reference: roles.id
	 */
	public List<MenuItem> findByRolesId(String rolesId) {
		return (List<MenuItem>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from MenuItem e, IN (e.roles) c where e.clientId = :clientId and c.id = :rolesId",
						MenuItem.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("rolesId", rolesId).getResultList();
	}
}
