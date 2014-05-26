/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.ReportParam;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;

@Ds(entity = ReportParam.class, sort = {@SortField(field = ReportParamLov_Ds.f_name)})
public class ReportParamLov_Ds extends AbstractTypeLov_Ds<ReportParam> {

	public static final String ALIAS = "ad_ReportParamLov_Ds";

	public static final String f_reportId = "reportId";
	public static final String f_title = "title";

	@DsField(join = "left", path = "report.id")
	private String reportId;

	@DsField
	private String title;

	public ReportParamLov_Ds() {
		super();
	}

	public ReportParamLov_Ds(ReportParam e) {
		super(e);
	}

	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
