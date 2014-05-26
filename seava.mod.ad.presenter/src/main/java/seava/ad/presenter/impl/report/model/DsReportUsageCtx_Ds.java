/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.DsReportUsage;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = DsReportUsage.class)
@RefLookups({@RefLookup(refId = DsReportUsageCtx_Ds.f_dsReportId)})
public class DsReportUsageCtx_Ds extends AbstractAuditable_Ds<DsReportUsage> {

	public static final String ALIAS = "ad_DsReportUsageCtx_Ds";

	public static final String f_dsReportId = "dsReportId";
	public static final String f_reportId = "reportId";
	public static final String f_report = "report";
	public static final String f_frameName = "frameName";
	public static final String f_toolbarKey = "toolbarKey";
	public static final String f_dcKey = "dcKey";
	public static final String f_sequenceNo = "sequenceNo";

	@DsField(join = "left", path = "dsReport.id")
	private String dsReportId;

	@DsField(join = "left", path = "dsReport.report.id")
	private String reportId;

	@DsField(join = "left", path = "dsReport.report.code")
	private String report;

	@DsField
	private String frameName;

	@DsField
	private String toolbarKey;

	@DsField
	private String dcKey;

	@DsField
	private Integer sequenceNo;

	public DsReportUsageCtx_Ds() {
		super();
	}

	public DsReportUsageCtx_Ds(DsReportUsage e) {
		super(e);
	}

	public String getDsReportId() {
		return this.dsReportId;
	}

	public void setDsReportId(String dsReportId) {
		this.dsReportId = dsReportId;
	}

	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getFrameName() {
		return this.frameName;
	}

	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}

	public String getToolbarKey() {
		return this.toolbarKey;
	}

	public void setToolbarKey(String toolbarKey) {
		this.toolbarKey = toolbarKey;
	}

	public String getDcKey() {
		return this.dcKey;
	}

	public void setDcKey(String dcKey) {
		this.dcKey = dcKey;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
}
