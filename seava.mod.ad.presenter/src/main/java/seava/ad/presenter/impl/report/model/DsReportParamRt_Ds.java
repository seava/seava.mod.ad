/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.DsReportParam;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = DsReportParam.class)
public class DsReportParamRt_Ds extends AbstractAuditable_Ds<DsReportParam> {

	public static final String ALIAS = "ad_DsReportParamRt_Ds";

	public static final String f_dsReportId = "dsReportId";
	public static final String f_dataSource = "dataSource";
	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_paramId = "paramId";
	public static final String f_param = "param";
	public static final String f_paramDataType = "paramDataType";
	public static final String f_paramMandatory = "paramMandatory";
	public static final String f_paramDefaultValue = "paramDefaultValue";
	public static final String f_paramListOfValues = "paramListOfValues";
	public static final String f_paramNoEdit = "paramNoEdit";
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

	@DsField(join = "left", path = "reportParam.dataType")
	private String paramDataType;

	@DsField(join = "left", path = "reportParam.mandatory")
	private Boolean paramMandatory;

	@DsField(join = "left", path = "reportParam.defaultValue")
	private String paramDefaultValue;

	@DsField(join = "left", path = "reportParam.listOfValues")
	private String paramListOfValues;

	@DsField(join = "left", path = "reportParam.noEdit")
	private Boolean paramNoEdit;

	@DsField
	private String dsField;

	@DsField
	private String staticValue;

	public DsReportParamRt_Ds() {
		super();
	}

	public DsReportParamRt_Ds(DsReportParam e) {
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

	public String getParamDataType() {
		return this.paramDataType;
	}

	public void setParamDataType(String paramDataType) {
		this.paramDataType = paramDataType;
	}

	public Boolean getParamMandatory() {
		return this.paramMandatory;
	}

	public void setParamMandatory(Boolean paramMandatory) {
		this.paramMandatory = paramMandatory;
	}

	public String getParamDefaultValue() {
		return this.paramDefaultValue;
	}

	public void setParamDefaultValue(String paramDefaultValue) {
		this.paramDefaultValue = paramDefaultValue;
	}

	public String getParamListOfValues() {
		return this.paramListOfValues;
	}

	public void setParamListOfValues(String paramListOfValues) {
		this.paramListOfValues = paramListOfValues;
	}

	public Boolean getParamNoEdit() {
		return this.paramNoEdit;
	}

	public void setParamNoEdit(Boolean paramNoEdit) {
		this.paramNoEdit = paramNoEdit;
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
