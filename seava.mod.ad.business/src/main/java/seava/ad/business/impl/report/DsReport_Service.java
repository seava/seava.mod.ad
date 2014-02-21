/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.report;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.report.IDsReportService;
import seava.ad.domain.impl.report.DsReport;
import seava.ad.domain.impl.report.Report;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link DsReport} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DsReport_Service extends AbstractEntityService<DsReport>
		implements
			IDsReportService {

	public DsReport_Service() {
		super();
	}

	public DsReport_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DsReport> getEntityClass() {
		return DsReport.class;
	}
	/**
	 * Find by reference: report
	 */
	public List<DsReport> findByReport(Report report) {
		return this.findByReportId(report.getId());
	}
	/**
	 * Find by ID of reference: report.id
	 */
	public List<DsReport> findByReportId(String reportId) {
		return (List<DsReport>) this
				.getEntityManager()
				.createQuery(
						"select e from DsReport e where e.clientId = :clientId and e.report.id = :reportId",
						DsReport.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("reportId", reportId).getResultList();
	}
}
