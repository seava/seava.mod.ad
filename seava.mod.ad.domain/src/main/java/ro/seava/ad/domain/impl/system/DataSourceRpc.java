/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.domain.impl.system;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import ro.seava.ad.domain.impl.system.DataSource;
import ro.seava.j4e.domain.impl.AbstractTypeNT;

@NamedQueries({
		@NamedQuery(name = DataSourceRpc.NQ_FIND_BY_NAME, query = "SELECT e FROM DataSourceRpc e WHERE e.dataSource = :dataSource and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = DataSourceRpc.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM DataSourceRpc e WHERE e.dataSource.id = :dataSourceId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DataSourceRpc.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = DataSourceRpc.TABLE_NAME
		+ "_UK1", columnNames = {"DATASOURCE_ID", "NAME"})})
public class DataSourceRpc extends AbstractTypeNT {

	public static final String TABLE_NAME = "SYS_DS_RPC";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "DataSourceRpc.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "DataSourceRpc.findByName_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DataSource.class)
	@JoinColumn(name = "DATASOURCE_ID", referencedColumnName = "ID")
	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
