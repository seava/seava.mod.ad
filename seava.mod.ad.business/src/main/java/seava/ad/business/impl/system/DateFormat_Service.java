/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.system.IDateFormatService;
import seava.ad.domain.impl.system.DateFormat;
import seava.ad.domain.impl.system.DateFormatMask;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link DateFormat} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DateFormat_Service extends AbstractEntityService<DateFormat>
		implements
			IDateFormatService {

	public DateFormat_Service() {
		super();
	}

	public DateFormat_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DateFormat> getEntityClass() {
		return DateFormat.class;
	}
	/**
	 * Find by unique key
	 */
	public DateFormat findByName(String name) {
		return (DateFormat) this.getEntityManager()
				.createNamedQuery(DateFormat.NQ_FIND_BY_NAME)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: masks
	 */
	public List<DateFormat> findByMasks(DateFormatMask masks) {
		return this.findByMasksId(masks.getId());
	}
	/**
	 * Find by ID of reference: masks.id
	 */
	public List<DateFormat> findByMasksId(String masksId) {
		return (List<DateFormat>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from DateFormat e, IN (e.masks) c where  c.id = :masksId",
						DateFormat.class).setParameter("masksId", masksId)
				.getResultList();
	}
}
