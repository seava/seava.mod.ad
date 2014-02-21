/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.report;

import javax.persistence.EntityManager;
import seava.ad.business.api.report.IReportServerService;
import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.session.Session;
import seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link ReportServer} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ReportServer_Service extends AbstractEntityService<ReportServer>
		implements
			IReportServerService {

	public ReportServer_Service() {
		super();
	}

	public ReportServer_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ReportServer> getEntityClass() {
		return ReportServer.class;
	}
	/**
	 * Find by unique key
	 */
	public ReportServer findByName(String name) {
		return (ReportServer) this
				.getEntityManager()
				.createNamedQuery(ReportServer.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
