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
import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.model.IModelWithId;
import seava.j4e.domain.impl.AbstractTypeWithCode;

@NamedQueries({
		@NamedQuery(name = Report.NQ_FIND_BY_CODE, query = "SELECT e FROM Report e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Report.NQ_FIND_BY_NAME, query = "SELECT e FROM Report e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Report.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Report.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = Report.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class Report extends AbstractTypeWithCode
		implements
			Serializable,
			IModelWithId {

	public static final String TABLE_NAME = "AD_RPT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Report.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Report.findByName";

	@Column(name = "CONTEXTPATH", length = 255)
	private String contextPath;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ReportServer.class)
	@JoinColumn(name = "REPORTSERVER_ID", referencedColumnName = "ID")
	private ReportServer reportServer;

	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public ReportServer getReportServer() {
		return this.reportServer;
	}

	public void setReportServer(ReportServer reportServer) {
		if (reportServer != null) {
			this.__validate_client_context__(reportServer.getClientId());
		}
		this.reportServer = reportServer;
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
