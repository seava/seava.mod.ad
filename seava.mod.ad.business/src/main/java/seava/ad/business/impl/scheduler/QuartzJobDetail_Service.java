/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.scheduler.IQuartzJobDetailService;
import seava.ad.domain.impl.scheduler.QuartzJobDetail;

/**
 * Repository functionality for {@link QuartzJobDetail} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzJobDetail_Service
		extends
			AbstractEntityService<QuartzJobDetail>
		implements
			IQuartzJobDetailService {

	public QuartzJobDetail_Service() {
		super();
	}

	public QuartzJobDetail_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzJobDetail> getEntityClass() {
		return QuartzJobDetail.class;
	}
}
