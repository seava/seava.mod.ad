/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.report;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.report.IDsReportUsageService;
import seava.ad.domain.impl.report.DsReport;
import seava.ad.domain.impl.report.DsReportUsage;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link DsReportUsage} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DsReportUsage_Service extends AbstractEntityService<DsReportUsage>
		implements
			IDsReportUsageService {

	public DsReportUsage_Service() {
		super();
	}

	public DsReportUsage_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DsReportUsage> getEntityClass() {
		return DsReportUsage.class;
	}
	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportUsage> findByDsReport(DsReport dsReport) {
		return this.findByDsReportId(dsReport.getId());
	}
	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportUsage> findByDsReportId(String dsReportId) {
		return (List<DsReportUsage>) this
				.getEntityManager()
				.createQuery(
						"select e from DsReportUsage e where e.clientId = :clientId and e.dsReport.id = :dsReportId",
						DsReportUsage.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("dsReportId", dsReportId).getResultList();
	}
}
