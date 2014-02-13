/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.security;

import java.util.List;
import ro.seava.j4e.api.exceptions.BusinessException;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.security.Role;
import seava.ad.domain.impl.security.User;
import seava.ad.domain.impl.security.UserGroup;
import seava.ad.domain.impl.system.DateFormat;

/**
 * Interface to expose business functions specific for {@link User} domain
 * entity.
 */
public interface IUserService extends IEntityService<User> {

	public void doChangePassword(String userId, String newPassword)
			throws BusinessException;

	/**
	 * Find by unique key
	 */
	public User findByCode(String code);

	/**
	 * Find by unique key
	 */
	public User findByLogin(String loginName);

	/**
	 * Find by reference: dateFormat
	 */
	public List<User> findByDateFormat(DateFormat dateFormat);

	/**
	 * Find by ID of reference: dateFormat.id
	 */
	public List<User> findByDateFormatId(String dateFormatId);

	/**
	 * Find by reference: roles
	 */
	public List<User> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<User> findByRolesId(String rolesId);

	/**
	 * Find by reference: groups
	 */
	public List<User> findByGroups(UserGroup groups);

	/**
	 * Find by ID of reference: groups.id
	 */
	public List<User> findByGroupsId(String groupsId);
}
