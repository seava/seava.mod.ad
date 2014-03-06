/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.DsReport;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.presenter.impl.model.AbstractAuditableLov_Ds;

@Ds(entity = DsReport.class)
public class DsReportLov_Ds extends AbstractAuditableLov_Ds<DsReport> {
	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_dataSource = "dataSource";

	@DsField(join = "left", path = "report.id")
	private String reportId;

	@DsField(join = "left", path = "report.code")
	private String reportCode;

	@DsField
	private String dataSource;

	public DsReportLov_Ds() {
		super();
	}

	public DsReportLov_Ds(DsReport e) {
		super(e);
	}

	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportCode() {
		return this.reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}
