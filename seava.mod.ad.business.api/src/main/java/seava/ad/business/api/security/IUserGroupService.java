/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.security;

import java.util.List;
import seava.ad.domain.impl.security.User;
import seava.ad.domain.impl.security.UserGroup;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link UserGroup} domain
 * entity.
 */
public interface IUserGroupService extends IEntityService<UserGroup> {

	/**
	 * Find by unique key
	 */
	public UserGroup findByCode(String code);

	/**
	 * Find by unique key
	 */
	public UserGroup findByName(String name);

	/**
	 * Find by reference: users
	 */
	public List<UserGroup> findByUsers(User users);

	/**
	 * Find by ID of reference: users.id
	 */
	public List<UserGroup> findByUsersId(String usersId);
}
