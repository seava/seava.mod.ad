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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import seava.ad.domain.impl.report.Report;
import seava.j4e.api.model.IModelWithId;
import seava.j4e.domain.impl.AbstractAuditable;

@Entity
@Table(name = DsReport.TABLE_NAME)
public class DsReport extends AbstractAuditable
		implements
			Serializable,
			IModelWithId {

	public static final String TABLE_NAME = "AD_RPT_DS";

	private static final long serialVersionUID = -8865917134914502125L;

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
