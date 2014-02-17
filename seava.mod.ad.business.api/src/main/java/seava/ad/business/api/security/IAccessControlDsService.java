/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.security;

import java.util.List;
import seava.ad.domain.impl.security.AccessControl;
import seava.ad.domain.impl.security.AccessControlDs;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link AccessControlDs} domain
 * entity.
 */
public interface IAccessControlDsService
		extends
			IEntityService<AccessControlDs> {

	/**
	 * Find by unique key
	 */
	public AccessControlDs findByUnique(AccessControl accessControl,
			String dsName);

	/**
	 * Find by unique key
	 */
	public AccessControlDs findByUnique(Long accessControlId, String dsName);

	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlDs> findByAccessControl(AccessControl accessControl);

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlDs> findByAccessControlId(String accessControlId);
}
