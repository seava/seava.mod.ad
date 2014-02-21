/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.report;

import java.util.List;
import javax.persistence.EntityManager;
import seava.ad.business.api.report.IDsReportParamService;
import seava.ad.domain.impl.report.DsReport;
import seava.ad.domain.impl.report.DsReportParam;
import seava.ad.domain.impl.report.ReportParam;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link DsReportParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DsReportParam_Service extends AbstractEntityService<DsReportParam>
		implements
			IDsReportParamService {

	public DsReportParam_Service() {
		super();
	}

	public DsReportParam_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DsReportParam> getEntityClass() {
		return DsReportParam.class;
	}
	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportParam> findByDsReport(DsReport dsReport) {
		return this.findByDsReportId(dsReport.getId());
	}
	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportParam> findByDsReportId(String dsReportId) {
		return (List<DsReportParam>) this
				.getEntityManager()
				.createQuery(
						"select e from DsReportParam e where e.clientId = :clientId and e.dsReport.id = :dsReportId",
						DsReportParam.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("dsReportId", dsReportId).getResultList();
	}
	/**
	 * Find by reference: reportParam
	 */
	public List<DsReportParam> findByReportParam(ReportParam reportParam) {
		return this.findByReportParamId(reportParam.getId());
	}
	/**
	 * Find by ID of reference: reportParam.id
	 */
	public List<DsReportParam> findByReportParamId(String reportParamId) {
		return (List<DsReportParam>) this
				.getEntityManager()
				.createQuery(
						"select e from DsReportParam e where e.clientId = :clientId and e.reportParam.id = :reportParamId",
						DsReportParam.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("reportParamId", reportParamId).getResultList();
	}
}
