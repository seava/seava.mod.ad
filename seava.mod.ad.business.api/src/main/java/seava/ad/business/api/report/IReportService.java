/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.report;

import java.util.List;
import seava.ad.domain.impl.report.Report;
import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link Report} domain
 * entity.
 */
public interface IReportService extends IEntityService<Report> {

	/**
	 * Find by unique key
	 */
	public Report findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Report findByName(String name);

	/**
	 * Find by reference: reportServer
	 */
	public List<Report> findByReportServer(ReportServer reportServer);

	/**
	 * Find by ID of reference: reportServer.id
	 */
	public List<Report> findByReportServerId(String reportServerId);
}
