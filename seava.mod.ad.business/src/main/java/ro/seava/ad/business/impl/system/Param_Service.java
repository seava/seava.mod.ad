/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.system;

import javax.persistence.EntityManager;
import ro.seava.ad.domain.impl.system.Param;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link Param} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Param_Service extends AbstractEntityService<Param> {

	public Param_Service() {
		super();
	}

	public Param_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Param> getEntityClass() {
		return Param.class;
	}
	/**
	 * Find by unique key
	 */
	public Param findByCode(String code) {
		return (Param) this.getEntityManager()
				.createNamedQuery(Param.NQ_FIND_BY_CODE)
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Param findByName(String name) {
		return (Param) this.getEntityManager()
				.createNamedQuery(Param.NQ_FIND_BY_NAME)
				.setParameter("name", name).getSingleResult();
	}
}
