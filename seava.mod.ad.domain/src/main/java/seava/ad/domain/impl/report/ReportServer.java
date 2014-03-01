/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.domain.impl.report;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import seava.j4e.domain.impl.AbstractType;

@NamedQueries({@NamedQuery(name = ReportServer.NQ_FIND_BY_NAME, query = "SELECT e FROM ReportServer e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ReportServer.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ReportServer.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class ReportServer extends AbstractType implements Serializable {

	public static final String TABLE_NAME = "AD_RPT_SRV";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ReportServer.findByName";

	@Column(name = "URL", length = 255)
	private String url;

	@Column(name = "QUERY_BLD_CLASS", length = 255)
	private String queryBuilderClass;

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQueryBuilderClass() {
		return this.queryBuilderClass;
	}

	public void setQueryBuilderClass(String queryBuilderClass) {
		this.queryBuilderClass = queryBuilderClass;
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
