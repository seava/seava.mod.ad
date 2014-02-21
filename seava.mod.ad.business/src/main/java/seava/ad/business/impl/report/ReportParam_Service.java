/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.report;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.report.IReportParamService;
import seava.ad.domain.impl.report.Report;
import seava.ad.domain.impl.report.ReportParam;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link ReportParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ReportParam_Service extends AbstractEntityService<ReportParam>
		implements
			IReportParamService {

	public ReportParam_Service() {
		super();
	}

	public ReportParam_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ReportParam> getEntityClass() {
		return ReportParam.class;
	}
	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Report report, String name) {
		return (ReportParam) this
				.getEntityManager()
				.createNamedQuery(ReportParam.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("report", report).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Long reportId, String name) {
		return (ReportParam) this
				.getEntityManager()
				.createNamedQuery(ReportParam.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("reportId", reportId).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by reference: report
	 */
	public List<ReportParam> findByReport(Report report) {
		return this.findByReportId(report.getId());
	}
	/**
	 * Find by ID of reference: report.id
	 */
	public List<ReportParam> findByReportId(String reportId) {
		return (List<ReportParam>) this
				.getEntityManager()
				.createQuery(
						"select e from ReportParam e where e.clientId = :clientId and e.report.id = :reportId",
						ReportParam.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("reportId", reportId).getResultList();
	}
}
