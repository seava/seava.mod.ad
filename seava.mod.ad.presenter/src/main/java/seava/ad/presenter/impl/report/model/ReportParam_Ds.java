/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.Report;
import seava.ad.domain.impl.report.ReportParam;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = ReportParam.class, sort = {@SortField(field = ReportParam_Ds.f_name)})
@RefLookups({@RefLookup(refId = ReportParam_Ds.f_reportId, namedQuery = Report.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ReportParam_Ds.f_reportCode)})})
public class ReportParam_Ds extends AbstractType_Ds<ReportParam> {

	public static final String ALIAS = "ad_ReportParam_Ds";

	public static final String f_reportId = "reportId";
	public static final String f_reportCode = "reportCode";
	public static final String f_title = "title";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_defaultValue = "defaultValue";
	public static final String f_dataType = "dataType";
	public static final String f_listOfValues = "listOfValues";
	public static final String f_noEdit = "noEdit";
	public static final String f_mandatory = "mandatory";

	@DsField(join = "left", path = "report.id")
	private String reportId;

	@DsField(join = "left", path = "report.code")
	private String reportCode;

	@DsField
	private String title;

	@DsField
	private Integer sequenceNo;

	@DsField
	private String defaultValue;

	@DsField
	private String dataType;

	@DsField
	private String listOfValues;

	@DsField
	private Boolean noEdit;

	@DsField
	private Boolean mandatory;

	public ReportParam_Ds() {
		super();
	}

	public ReportParam_Ds(ReportParam e) {
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
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
}
