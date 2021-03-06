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
 * Interface to expose business functions specific for {@link DateFormatMask} domain
 * entity.
 */
public interface IDateFormatMaskService extends IEntityService<DateFormatMask> {

	/**
	 * Find by unique key
	 */
	public DateFormatMask findByName(DateFormat dateFormat, String mask);

	/**
	 * Find by unique key
	 */
	public DateFormatMask findByName(Long dateFormatId, String mask);

	/**
	 * Find by reference: dateFormat
	 */
	public List<DateFormatMask> findByDateFormat(DateFormat dateFormat);

	/**
	 * Find by ID of reference: dateFormat.id
	 */
	public List<DateFormatMask> findByDateFormatId(String dateFormatId);
}
