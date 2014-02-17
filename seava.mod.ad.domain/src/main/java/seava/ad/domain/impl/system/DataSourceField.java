/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.domain.impl.system;

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
import seava.ad.domain.impl.system.DataSource;
import seava.j4e.api.model.IModelWithId;
import seava.j4e.domain.impl.AbstractTypeNT;

@NamedQueries({
		@NamedQuery(name = DataSourceField.NQ_FIND_BY_NAME, query = "SELECT e FROM DataSourceField e WHERE e.dataSource = :dataSource and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = DataSourceField.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM DataSourceField e WHERE e.dataSource.id = :dataSourceId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DataSourceField.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = DataSourceField.TABLE_NAME
		+ "_UK1", columnNames = {"DATASOURCE_ID", "NAME"})})
public class DataSourceField extends AbstractTypeNT
		implements
			Serializable,
			IModelWithId {

	public static final String TABLE_NAME = "SYS_DS_FLD";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "DataSourceField.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "DataSourceField.findByName_PRIMITIVE";

	@NotBlank
	@Column(name = "DATATYPE", nullable = false, length = 255)
	private String dataType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DataSource.class)
	@JoinColumn(name = "DATASOURCE_ID", referencedColumnName = "ID")
	private DataSource dataSource;

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

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

	@PreUpdate
	public void preUpdate() {
		super.preUpdate();
	}

}
