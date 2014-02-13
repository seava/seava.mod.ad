/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.system;

import java.util.List;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.system.DataSource;
import seava.ad.domain.impl.system.DataSourceRpc;

/**
 * Interface to expose business functions specific for {@link DataSourceRpc} domain
 * entity.
 */
public interface IDataSourceRpcService extends IEntityService<DataSourceRpc> {

	/**
	 * Find by unique key
	 */
	public DataSourceRpc findByName(DataSource dataSource, String name);

	/**
	 * Find by unique key
	 */
	public DataSourceRpc findByName(Long dataSourceId, String name);

	/**
	 * Find by reference: dataSource
	 */
	public List<DataSourceRpc> findByDataSource(DataSource dataSource);

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<DataSourceRpc> findByDataSourceId(String dataSourceId);
}
