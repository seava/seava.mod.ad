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
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = ReportParam.class, jpqlWhere = "  e.active = true  ", sort = {
		@SortField(field = ReportParamRt_Ds.f_sequenceNo),
		@SortField(field = ReportParamRt_Ds.f_name)})
public class ReportParamRt_Ds extends AbstractType_Ds<ReportParam> {
	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_value = "value";
	public static final String f_dataType = "dataType";
	public static final String f_parameterName = "parameterName";
	public static final String f_listOfValues = "listOfValues";
	public static final String f_noEdit = "noEdit";
	public static final String f_mandatory = "mandatory";
	public static final String f_sequenceNo = "sequenceNo";

	@DsField(join = "left", path = "report.id")
	private String reportId;

	@DsField(join = "left", path = "report.code")
	private String reportCode;

	@DsField(path = "defaultValue")
	private String value;

	@DsField
	private String dataType;

	@DsField(path = "name")
	private String parameterName;

	@DsField
	private String listOfValues;

	@DsField
	private Boolean noEdit;

	@DsField
	private Boolean mandatory;

	@DsField
	private Integer sequenceNo;

	public ReportParamRt_Ds() {
		super();
	}

	public ReportParamRt_Ds(ReportParam e) {
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getListOfValues() {
		return this.listOfValues;
	}

	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}

	public Boolean getNoEdit() {
		return this.noEdit;
	}

	public void setNoEdit(Boolean noEdit) {
		this.noEdit = noEdit;
	}

	public Boolean getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
}
