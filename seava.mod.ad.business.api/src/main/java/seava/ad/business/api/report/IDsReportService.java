/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.report;

import java.util.List;
import seava.ad.domain.impl.report.DsReport;
import seava.ad.domain.impl.report.Report;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link DsReport} domain
 * entity.
 */
public interface IDsReportService extends IEntityService<DsReport> {

	/**
	 * Find by unique key
	 */
	public DsReport findByRep_ds(Report report, String dataSource);

	/**
	 * Find by unique key
	 */
	public DsReport findByRep_ds(Long reportId, String dataSource);

	/**
	 * Find by reference: report
	 */
	public List<DsReport> findByReport(Report report);

	/**
	 * Find by ID of reference: report.id
	 */
	public List<DsReport> findByReportId(String reportId);
}
