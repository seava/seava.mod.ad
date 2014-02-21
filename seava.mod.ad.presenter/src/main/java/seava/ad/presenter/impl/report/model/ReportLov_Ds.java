/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.Report;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCodeLov_Ds;

@Ds(entity = Report.class, sort = {@SortField(field = ReportLov_Ds.f_code)})
public class ReportLov_Ds extends AbstractTypeWithCodeLov_Ds<Report> {

	public ReportLov_Ds() {
		super();
	}

	public ReportLov_Ds(Report e) {
		super(e);
	}
}
