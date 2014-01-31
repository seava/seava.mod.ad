/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.DataSourceRpc;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeNTDs;

@Ds(entity = DataSourceRpc.class, sort = {@SortField(field = DataSourceRpc_Ds.f_name)})
public class DataSourceRpc_Ds extends AbstractTypeNTDs<DataSourceRpc> {
	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSource = "dataSource";

	@DsField(join = "left", path = "dataSource.id")
	private String dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSource;

	public DataSourceRpc_Ds() {
		super();
	}

	public DataSourceRpc_Ds(DataSourceRpc e) {
		super(e);
	}

	public String getDataSourceId() {
		return this.dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}
