/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.report;

import java.util.List;
import seava.ad.domain.impl.report.Report;
import seava.ad.domain.impl.report.ReportParam;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link ReportParam} domain
 * entity.
 */
public interface IReportParamService extends IEntityService<ReportParam> {

	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Report report, String name);

	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Long reportId, String name);

	/**
	 * Find by reference: report
	 */
	public List<ReportParam> findByReport(Report report);

	/**
	 * Find by ID of reference: report.id
	 */
	public List<ReportParam> findByReportId(String reportId);
}
