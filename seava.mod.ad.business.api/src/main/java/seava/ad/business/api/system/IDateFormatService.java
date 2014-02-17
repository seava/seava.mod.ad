/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.system;

import java.util.List;
import seava.ad.domain.impl.system.DateFormat;
import seava.ad.domain.impl.system.DateFormatMask;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link DateFormat} domain
 * entity.
 */
public interface IDateFormatService extends IEntityService<DateFormat> {

	/**
	 * Find by unique key
	 */
	public DateFormat findByName(String name);

	/**
	 * Find by reference: masks
	 */
	public List<DateFormat> findByMasks(DateFormatMask masks);

	/**
	 * Find by ID of reference: masks.id
	 */
	public List<DateFormat> findByMasksId(String masksId);
}
