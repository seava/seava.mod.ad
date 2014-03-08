/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.system;

import javax.persistence.EntityManager;
import seava.ad.business.api.system.ITargetRuleService;
import seava.ad.domain.impl.system.TargetRule;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link TargetRule} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TargetRule_Service extends AbstractEntityService<TargetRule>
		implements
			ITargetRuleService {

	public TargetRule_Service() {
		super();
	}

	public TargetRule_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TargetRule> getEntityClass() {
		return TargetRule.class;
	}
}
