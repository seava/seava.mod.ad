/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.system;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.system.IParamValueService;
import seava.ad.domain.impl.system.ParamValue;

/**
 * Repository functionality for {@link ParamValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ParamValue_Service extends AbstractEntityService<ParamValue>
		implements
			IParamValueService {

	public ParamValue_Service() {
		super();
	}

	public ParamValue_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ParamValue> getEntityClass() {
		return ParamValue.class;
	}
}
