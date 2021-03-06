/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.security;

import java.util.List;
import seava.ad.domain.impl.security.AccessControl;
import seava.ad.domain.impl.security.AccessControlAsgn;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link AccessControlAsgn} domain
 * entity.
 */
public interface IAccessControlAsgnService
		extends
			IEntityService<AccessControlAsgn> {

	/**
	 * Find by unique key
	 */
	public AccessControlAsgn findByUnique(AccessControl accessControl,
			String asgnName);

	/**
	 * Find by unique key
	 */
	public AccessControlAsgn findByUnique(Long accessControlId, String asgnName);

	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlAsgn> findByAccessControl(
			AccessControl accessControl);

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlAsgn> findByAccessControlId(String accessControlId);
}
