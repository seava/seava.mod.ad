/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.report;

import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link ReportServer} domain
 * entity.
 */
public interface IReportServerService extends IEntityService<ReportServer> {

	/**
	 * Find by unique key
	 */
	public ReportServer findByName(String name);
}
