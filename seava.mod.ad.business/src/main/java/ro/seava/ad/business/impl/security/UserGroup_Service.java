/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.ad.business.api.security.IUserGroupService;
import ro.seava.ad.domain.impl.security.User;
import ro.seava.ad.domain.impl.security.UserGroup;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link UserGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UserGroup_Service extends AbstractEntityService<UserGroup>
		implements
			IUserGroupService {

	public UserGroup_Service() {
		super();
	}

	public UserGroup_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UserGroup> getEntityClass() {
		return UserGroup.class;
	}
	/**
	 * Find by unique key
	 */
	public UserGroup findByCode(String code) {
		return (UserGroup) this
				.getEntityManager()
				.createNamedQuery(UserGroup.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public UserGroup findByName(String name) {
		return (UserGroup) this
				.getEntityManager()
				.createNamedQuery(UserGroup.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: users
	 */
	public List<UserGroup> findByUsers(User users) {
		return this.findByUsersId(users.getId());
	}
	/**
	 * Find by ID of reference: users.id
	 */
	public List<UserGroup> findByUsersId(String usersId) {
		return (List<UserGroup>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from UserGroup e, IN (e.users) c where e.clientId = :clientId and c.id = :usersId",
						UserGroup.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("usersId", usersId).getResultList();
	}
}
