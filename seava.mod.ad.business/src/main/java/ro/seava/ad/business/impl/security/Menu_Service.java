/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.ad.business.api.security.IMenuService;
import ro.seava.ad.domain.impl.security.Menu;
import ro.seava.ad.domain.impl.security.Role;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link Menu} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Menu_Service extends AbstractEntityService<Menu>
		implements
			IMenuService {

	public Menu_Service() {
		super();
	}

	public Menu_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Menu> getEntityClass() {
		return Menu.class;
	}
	/**
	 * Find by unique key
	 */
	public Menu findByName(String name) {
		return (Menu) this
				.getEntityManager()
				.createNamedQuery(Menu.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: roles
	 */
	public List<Menu> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}
	/**
	 * Find by ID of reference: roles.id
	 */
	public List<Menu> findByRolesId(String rolesId) {
		return (List<Menu>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Menu e, IN (e.roles) c where e.clientId = :clientId and c.id = :rolesId",
						Menu.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("rolesId", rolesId).getResultList();
	}
}
