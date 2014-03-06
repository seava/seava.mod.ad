/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.cnv;

import javax.persistence.EntityManager;
import seava.j4e.api.action.result.IDsConverter;
import seava.j4e.presenter.converter.AbstractDsConverter;
import seava.ad.business.api.report.IReportService;
import seava.ad.domain.impl.report.DsReportUsage;
import seava.ad.domain.impl.report.Report;
import seava.ad.presenter.impl.report.model.DsReportUsage_Ds;

public class DsReportUsage_DsCnv extends
		AbstractDsConverter<DsReportUsage_Ds, DsReportUsage> implements
		IDsConverter<DsReportUsage_Ds, DsReportUsage> {

	protected void modelToEntityReferences(DsReportUsage_Ds ds,
			DsReportUsage e, boolean isInsert, EntityManager em)
			throws Exception {

		if (ds.getReportId() == null) {
			Report x = ((IReportService) findEntityService(Report.class))
					.findByCode(ds.getReport());
			ds.setReportId(x.getId());
		}
		super.modelToEntityReferences(ds, e, isInsert, em);
	}
}
