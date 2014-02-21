/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.report;

import java.util.List;
import seava.ad.domain.impl.report.DsReport;
import seava.ad.domain.impl.report.DsReportParam;
import seava.ad.domain.impl.report.ReportParam;
import seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link DsReportParam} domain
 * entity.
 */
public interface IDsReportParamService extends IEntityService<DsReportParam> {

	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportParam> findByDsReport(DsReport dsReport);

	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportParam> findByDsReportId(String dsReportId);

	/**
	 * Find by reference: reportParam
	 */
	public List<DsReportParam> findByReportParam(ReportParam reportParam);

	/**
	 * Find by ID of reference: reportParam.id
	 */
	public List<DsReportParam> findByReportParamId(String reportParamId);
}
