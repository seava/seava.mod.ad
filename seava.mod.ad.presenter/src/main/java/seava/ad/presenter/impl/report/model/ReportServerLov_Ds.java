/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;

@Ds(entity = ReportServer.class, sort = {@SortField(field = ReportServerLov_Ds.f_name)})
public class ReportServerLov_Ds extends AbstractTypeLov_Ds<ReportServer> {

	public static final String ALIAS = "ad_ReportServerLov_Ds";

	public ReportServerLov_Ds() {
		super();
	}

	public ReportServerLov_Ds(ReportServer e) {
		super(e);
	}
}
