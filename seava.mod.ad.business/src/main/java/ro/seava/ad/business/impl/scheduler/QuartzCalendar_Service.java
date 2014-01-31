/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.scheduler;

import javax.persistence.EntityManager;
import ro.seava.ad.business.api.scheduler.IQuartzCalendarService;
import ro.seava.ad.domain.impl.scheduler.QuartzCalendar;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link QuartzCalendar} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzCalendar_Service
		extends
			AbstractEntityService<QuartzCalendar>
		implements
			IQuartzCalendarService {

	public QuartzCalendar_Service() {
		super();
	}

	public QuartzCalendar_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzCalendar> getEntityClass() {
		return QuartzCalendar.class;
	}
}
