/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.Report;
import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCode_Ds;

@Ds(entity = Report.class, sort = {@SortField(field = Report_Ds.f_code)})
@RefLookups({@RefLookup(refId = Report_Ds.f_reportServerId, namedQuery = ReportServer.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = Report_Ds.f_reportServer)})})
public class Report_Ds extends AbstractTypeWithCode_Ds<Report> {

	public static final String ALIAS = "ad_Report_Ds";

	public static final String f_reportServerId = "reportServerId";
	public static final String f_reportServer = "reportServer";
	public static final String f_serverUrl = "serverUrl";
	public static final String f_contextPath = "contextPath";

	@DsField(join = "left", path = "reportServer.id")
	private String reportServerId;

	@DsField(join = "left", path = "reportServer.name")
	private String reportServer;

	@DsField(join = "left", path = "reportServer.url")
	private String serverUrl;

	@DsField
	private String contextPath;

	public Report_Ds() {
		super();
	}

	public Report_Ds(Report e) {
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

	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
}
