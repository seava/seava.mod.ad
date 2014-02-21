/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.DsReportUsage;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = DsReportUsage.class, jpqlWhere = " e.dsReport.report.active = true ")
public class DsReportUsageRt_Ds extends AbstractAuditable_Ds<DsReportUsage> {
	public static final String f_dsReportId = "dsReportId";
	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_reportTitle = "reportTitle";
	public static final String f_reportContextPath = "reportContextPath";
	public static final String f_serverUrl = "serverUrl";
	public static final String f_queryBuilderClass = "queryBuilderClass";
	public static final String f_frameName = "frameName";
	public static final String f_toolbarKey = "toolbarKey";
	public static final String f_dcKey = "dcKey";

	@DsField(join = "left", path = "dsReport.id")
	private String dsReportId;

	@DsField(join = "left", path = "dsReport.report.id")
	private String reportId;

	@DsField(join = "left", path = "dsReport.report.code")
	private String reportCode;

	@DsField(join = "left", path = "dsReport.report.name")
	private String reportTitle;

	@DsField(join = "left", path = "dsReport.report.contextPath")
	private String reportContextPath;

	@DsField(join = "left", path = "dsReport.report.reportServer.url")
	private String serverUrl;

	@DsField(join = "left", path = "dsReport.report.reportServer.queryBuilderClass")
	private String queryBuilderClass;

	@DsField
	private String frameName;

	@DsField
	private String toolbarKey;

	@DsField
	private String dcKey;

	public DsReportUsageRt_Ds() {
		super();
	}

	public DsReportUsageRt_Ds(DsReportUsage e) {
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

	public String getReportCode() {
		return this.reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getReportTitle() {
		return this.reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportContextPath() {
		return this.reportContextPath;
	}

	public void setReportContextPath(String reportContextPath) {
		this.reportContextPath = reportContextPath;
	}

	public String getServerUrl() {
		return this.serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getQueryBuilderClass() {
		return this.queryBuilderClass;
	}

	public void setQueryBuilderClass(String queryBuilderClass) {
		this.queryBuilderClass = queryBuilderClass;
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
}
