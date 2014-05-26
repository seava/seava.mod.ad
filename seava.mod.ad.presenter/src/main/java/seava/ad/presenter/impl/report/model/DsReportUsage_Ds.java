/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.DsReport;
import seava.ad.domain.impl.report.DsReportUsage;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = DsReportUsage.class, sort = {@SortField(field = DsReportUsage_Ds.f_report)})
@RefLookups({@RefLookup(refId = DsReportUsage_Ds.f_dsReportId, namedQuery = DsReport.NQ_FIND_BY_REP_DS_PRIMITIVE, params = {
		@Param(name = "reportId", field = DsReportUsage_Ds.f_reportId),
		@Param(name = "dataSource", field = DsReportUsage_Ds.f_dataSource)})})
public class DsReportUsage_Ds extends AbstractAuditable_Ds<DsReportUsage> {

	public static final String ALIAS = "ad_DsReportUsage_Ds";

	public static final String f_dsReportId = "dsReportId";
	public static final String f_dataSource = "dataSource";
	public static final String f_reportId = "reportId";
	public static final String f_report = "report";
	public static final String f_reportName = "reportName";
	public static final String f_frameName = "frameName";
	public static final String f_toolbarKey = "toolbarKey";
	public static final String f_dcKey = "dcKey";
	public static final String f_sequenceNo = "sequenceNo";

	@DsField(join = "left", path = "dsReport.id")
	private String dsReportId;

	@DsField(join = "left", path = "dsReport.dataSource")
	private String dataSource;

	@DsField(join = "left", path = "dsReport.report.id")
	private String reportId;

	@DsField(join = "left", path = "dsReport.report.code")
	private String report;

	@DsField(join = "left", path = "dsReport.report.name")
	private String reportName;

	@DsField
	private String frameName;

	@DsField
	private String toolbarKey;

	@DsField
	private String dcKey;

	@DsField
	private Integer sequenceNo;

	public DsReportUsage_Ds() {
		super();
	}

	public DsReportUsage_Ds(DsReportUsage e) {
		super(e);
	}

	public String getDsReportId() {
		return this.dsReportId;
	}

	public void setDsReportId(String dsReportId) {
		this.dsReportId = dsReportId;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
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

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
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
