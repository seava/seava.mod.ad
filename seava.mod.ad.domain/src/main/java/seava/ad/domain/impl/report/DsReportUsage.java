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
import seava.ad.domain.impl.report.DsReport;
import seava.j4e.domain.impl.AbstractAuditable;

@Entity
@Table(name = DsReportUsage.TABLE_NAME)
public class DsReportUsage extends AbstractAuditable implements Serializable {

	public static final String TABLE_NAME = "AD_RPT_DS_USAGE";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "FRAMENAME", length = 255)
	private String frameName;

	@Column(name = "TOOLBARKEY", length = 400)
	private String toolbarKey;

	@Column(name = "DCKEY", length = 400)
	private String dcKey;

	@Column(name = "SEQUENCENO", precision = 4)
	private Integer sequenceNo;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DsReport.class)
	@JoinColumn(name = "DSREPORT_ID", referencedColumnName = "ID")
	private DsReport dsReport;

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

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public DsReport getDsReport() {
		return this.dsReport;
	}

	public void setDsReport(DsReport dsReport) {
		if (dsReport != null) {
			this.__validate_client_context__(dsReport.getClientId());
		}
		this.dsReport = dsReport;
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
