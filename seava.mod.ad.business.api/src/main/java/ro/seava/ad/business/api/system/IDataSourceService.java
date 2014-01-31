/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.api.system;

import java.util.List;
import ro.seava.ad.domain.impl.system.DataSource;
import ro.seava.ad.domain.impl.system.DataSourceField;
import ro.seava.ad.domain.impl.system.DataSourceRpc;
import ro.seava.j4e.api.service.business.IEntityService;

/**
 * Interface to expose business functions specific for {@link DataSource} domain
 * entity.
 */
public interface IDataSourceService extends IEntityService<DataSource> {

	/**
	 * Find by unique key
	 */
	public DataSource findByName(String name);

	/**
	 * Find by unique key
	 */
	public DataSource findByModel(String model);

	/**
	 * Find by reference: fields
	 */
	public List<DataSource> findByFields(DataSourceField fields);

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<DataSource> findByFieldsId(String fieldsId);

	/**
	 * Find by reference: serviceMethods
	 */
	public List<DataSource> findByServiceMethods(DataSourceRpc serviceMethods);

	/**
	 * Find by ID of reference: serviceMethods.id
	 */
	public List<DataSource> findByServiceMethodsId(String serviceMethodsId);
}
