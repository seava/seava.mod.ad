/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import ro.seava.ad.domain.impl.security.Role;
import ro.seava.ad.domain.impl.security.User;
import ro.seava.ad.domain.impl.security.UserGroup;
import ro.seava.ad.domain.impl.system.DateFormat;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link User} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class User_Service extends AbstractEntityService<User> {

	public User_Service() {
		super();
	}

	public User_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
	/**
	 * Find by unique key
	 */
	public User findByCode(String code) {
		return (User) this
				.getEntityManager()
				.createNamedQuery(User.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public User findByLogin(String loginName) {
		return (User) this
				.getEntityManager()
				.createNamedQuery(User.NQ_FIND_BY_LOGIN)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("loginName", loginName).getSingleResult();
	}
	/**
	 * Find by reference: dateFormat
	 */
	public List<User> findByDateFormat(DateFormat dateFormat) {
		return this.findByDateFormatId(dateFormat.getId());
	}
	/**
	 * Find by ID of reference: dateFormat.id
	 */
	public List<User> findByDateFormatId(String dateFormatId) {
		return (List<User>) this
				.getEntityManager()
				.createQuery(
						"select e from User e where e.clientId = :clientId and e.dateFormat.id = :dateFormatId",
						User.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("dateFormatId", dateFormatId).getResultList();
	}
	/**
	 * Find by reference: roles
	 */
	public List<User> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}
	/**
	 * Find by ID of reference: roles.id
	 */
	public List<User> findByRolesId(String rolesId) {
		return (List<User>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from User e, IN (e.roles) c where e.clientId = :clientId and c.id = :rolesId",
						User.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("rolesId", rolesId).getResultList();
	}
	/**
	 * Find by reference: groups
	 */
	public List<User> findByGroups(UserGroup groups) {
		return this.findByGroupsId(groups.getId());
	}
	/**
	 * Find by ID of reference: groups.id
	 */
	public List<User> findByGroupsId(String groupsId) {
		return (List<User>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from User e, IN (e.groups) c where e.clientId = :clientId and c.id = :groupsId",
						User.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("groupsId", groupsId).getResultList();
	}
}
