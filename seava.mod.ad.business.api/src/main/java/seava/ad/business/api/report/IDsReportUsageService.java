/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.report;

import java.util.List;
import seava.ad.domain.impl.report.DsReport;
import seava.ad.domain.impl.report.DsReportUsage;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link DsReportUsage} domain
 * entity.
 */
public interface IDsReportUsageService extends IEntityService<DsReportUsage> {

	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportUsage> findByDsReport(DsReport dsReport);

	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportUsage> findByDsReportId(String dsReportId);
}
