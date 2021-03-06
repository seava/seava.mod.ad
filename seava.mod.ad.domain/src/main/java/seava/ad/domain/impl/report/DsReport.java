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
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;
import seava.ad.domain.impl.report.Report;
import seava.j4e.domain.impl.AbstractAuditable;

@NamedQueries({
		@NamedQuery(name = DsReport.NQ_FIND_BY_REP_DS, query = "SELECT e FROM DsReport e WHERE e.clientId = :clientId and e.report = :report and e.dataSource = :dataSource", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = DsReport.NQ_FIND_BY_REP_DS_PRIMITIVE, query = "SELECT e FROM DsReport e WHERE e.clientId = :clientId and e.report.id = :reportId and e.dataSource = :dataSource", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DsReport.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = DsReport.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "REPORT_ID", "DATASOURCE"})})
public class DsReport extends AbstractAuditable implements Serializable {

	public static final String TABLE_NAME = "AD_RPT_DS";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Rep_ds.
	 */
	public static final String NQ_FIND_BY_REP_DS = "DsReport.findByRep_ds";
	/**
	 * Named query find by unique key: Rep_ds using the ID field for references.
	 */
	public static final String NQ_FIND_BY_REP_DS_PRIMITIVE = "DsReport.findByRep_ds_PRIMITIVE";

	/** Reference to the data-source. 
	 */
	@NotBlank
	@Column(name = "DATASOURCE", nullable = false, length = 255)
	private String dataSource;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Report.class)
	@JoinColumn(name = "REPORT_ID", referencedColumnName = "ID")
	private Report report;

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
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
	}

	@PreUpdate
	public void preUpdate() {
		super.preUpdate();
	}

}
