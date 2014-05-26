/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.DsReportParam;
import seava.ad.domain.impl.report.ReportParam;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = DsReportParam.class)
@RefLookups({
		@RefLookup(refId = DsReportParam_Ds.f_dsReportId),
		@RefLookup(refId = DsReportParam_Ds.f_paramId, namedQuery = ReportParam.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "reportId", field = DsReportParam_Ds.f_reportId),
				@Param(name = "name", field = DsReportParam_Ds.f_param)})})
public class DsReportParam_Ds extends AbstractAuditable_Ds<DsReportParam> {

	public static final String ALIAS = "ad_DsReportParam_Ds";

	public static final String f_dsReportId = "dsReportId";
	public static final String f_dataSource = "dataSource";
	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_paramId = "paramId";
	public static final String f_param = "param";
	public static final String f_paramTitle = "paramTitle";
	public static final String f_dsField = "dsField";
	public static final String f_staticValue = "staticValue";

	@DsField(join = "left", path = "dsReport.id")
	private String dsReportId;

	@DsField(join = "left", path = "dsReport.dataSource")
	private String dataSource;

	@DsField(join = "left", path = "dsReport.report.id")
	private String reportId;

	@DsField(join = "left", path = "dsReport.report.code")
	private String reportCode;

	@DsField(join = "left", path = "reportParam.id")
	private String paramId;

	@DsField(join = "left", path = "reportParam.name")
	private String param;

	@DsField(join = "left", path = "reportParam.title")
	private String paramTitle;

	@DsField
	private String dsField;

	@DsField
	private String staticValue;

	public DsReportParam_Ds() {
		super();
	}

	public DsReportParam_Ds(DsReportParam e) {
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

	public String getReportCode() {
		return this.reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getParamId() {
		return this.paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getParam() {
		return this.param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getParamTitle() {
		return this.paramTitle;
	}

	public void setParamTitle(String paramTitle) {
		this.paramTitle = paramTitle;
	}

	public String getDsField() {
		return this.dsField;
	}

	public void setDsField(String dsField) {
		this.dsField = dsField;
	}

	public String getStaticValue() {
		return this.staticValue;
	}

	public void setStaticValue(String staticValue) {
		this.staticValue = staticValue;
	}
}
