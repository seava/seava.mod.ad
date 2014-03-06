/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.Report;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCode_Ds;

/**
 * Read-only report info to be used for runtime report execution center
 */
@Ds(entity = Report.class, sort = {@SortField(field = ReportRt_Ds.f_code)})
public class ReportRt_Ds extends AbstractTypeWithCode_Ds<Report> {
	public static final String f_reportServerId = "reportServerId";
	public static final String f_reportServer = "reportServer";
	public static final String f_serverUrl = "serverUrl";
	public static final String f_queryBuilderClass = "queryBuilderClass";
	public static final String f_contextPath = "contextPath";

	@DsField(join = "left", path = "reportServer.id")
	private String reportServerId;

	@DsField(join = "left", path = "reportServer.name")
	private String reportServer;

	@DsField(join = "left", path = "reportServer.url")
	private String serverUrl;

	@DsField(join = "left", path = "reportServer.queryBuilderClass")
	private String queryBuilderClass;

	@DsField
	private String contextPath;

	public ReportRt_Ds() {
		super();
	}

	public ReportRt_Ds(Report e) {
		super(e);
	}

	public String getReportServerId() {
		return this.reportServerId;
	}

	public void setReportServerId(String reportServerId) {
		this.reportServerId = reportServerId;
	}

	public String getReportServer() {
		return this.reportServer;
	}

	public void setReportServer(String reportServer) {
		this.reportServer = reportServer;
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

	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
}
