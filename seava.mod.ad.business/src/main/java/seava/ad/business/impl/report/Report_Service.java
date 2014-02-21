/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.report;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.report.IReportService;
import seava.ad.domain.impl.report.Report;
import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link Report} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Report_Service extends AbstractEntityService<Report>
		implements
			IReportService {

	public Report_Service() {
		super();
	}

	public Report_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Report> getEntityClass() {
		return Report.class;
	}
	/**
	 * Find by unique key
	 */
	public Report findByCode(String code) {
		return (Report) this
				.getEntityManager()
				.createNamedQuery(Report.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Report findByName(String name) {
		return (Report) this
				.getEntityManager()
				.createNamedQuery(Report.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: reportServer
	 */
	public List<Report> findByReportServer(ReportServer reportServer) {
		return this.findByReportServerId(reportServer.getId());
	}
	/**
	 * Find by ID of reference: reportServer.id
	 */
	public List<Report> findByReportServerId(String reportServerId) {
		return (List<Report>) this
				.getEntityManager()
				.createQuery(
						"select e from Report e where e.clientId = :clientId and e.reportServer.id = :reportServerId",
						Report.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("reportServerId", reportServerId).getResultList();
	}
}
