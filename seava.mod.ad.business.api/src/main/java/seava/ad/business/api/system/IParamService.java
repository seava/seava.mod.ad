/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.system;

import ro.seava.j4e.api.exceptions.BusinessException;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.system.Param;

/**
 * Interface to expose business functions specific for {@link Param} domain
 * entity.
 */
public interface IParamService extends IEntityService<Param> {

	public void doSynchronizeCatalog() throws BusinessException;

	/**
	 * Find by unique key
	 */
	public Param findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Param findByName(String name);
}
