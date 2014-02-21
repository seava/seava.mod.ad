/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.domain.impl.report;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;
import seava.ad.domain.impl.report.Report;
import seava.j4e.api.model.IModelWithId;
import seava.j4e.domain.impl.AbstractType;

@NamedQueries({
		@NamedQuery(name = ReportParam.NQ_FIND_BY_NAME, query = "SELECT e FROM ReportParam e WHERE e.clientId = :clientId and e.report = :report and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ReportParam.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM ReportParam e WHERE e.clientId = :clientId and e.report.id = :reportId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ReportParam.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ReportParam.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "REPORT_ID", "NAME"})})
public class ReportParam extends AbstractType
		implements
			Serializable,
			IModelWithId {

	public static final String TABLE_NAME = "AD_RPT_PRM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ReportParam.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "ReportParam.findByName_PRIMITIVE";

	@NotBlank
	@Column(name = "TITLE", nullable = false, length = 255)
	private String title;

	@NotNull
	@Column(name = "SEQUENCENO", nullable = false, precision = 4)
	private Integer sequenceNo;

	@NotNull
	@Column(name = "MANDATORY", nullable = false)
	private Boolean mandatory;

	@NotNull
	@Column(name = "NOEDIT", nullable = false)
	private Boolean noEdit;

	@NotBlank
	@Column(name = "DATATYPE", nullable = false, length = 32)
	private String dataType;

	@Column(name = "DEFAULTVALUE", length = 400)
	private String defaultValue;

	@Column(name = "LISTOFVALUES", length = 400)
	private String listOfValues;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Report.class)
	@JoinColumn(name = "REPORT_ID", referencedColumnName = "ID")
	private Report report;

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

	public Boolean getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Boolean getNoEdit() {
		return this.noEdit;
	}

	public void setNoEdit(Boolean noEdit) {
		this.noEdit = noEdit;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getListOfValues() {
		return this.listOfValues;
	}

	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		if (report != null) {
			this.__validate_client_context__(report.getClientId());
		}
		this.report = report;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.mandatory == null) {
			this.mandatory = new Boolean(false);
		}
		if (this.noEdit == null) {
			this.noEdit = new Boolean(false);
		}
	}

	@PreUpdate
	public void preUpdate() {
		super.preUpdate();
	}

}
