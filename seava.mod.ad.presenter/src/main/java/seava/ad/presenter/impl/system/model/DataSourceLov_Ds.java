/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.DataSource;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeNTLov_Ds;

@Ds(entity = DataSource.class, sort = {@SortField(field = DataSourceLov_Ds.f_name)})
public class DataSourceLov_Ds extends AbstractTypeNTLov_Ds<DataSource> {

	public DataSourceLov_Ds() {
		super();
	}

	public DataSourceLov_Ds(DataSource e) {
		super(e);
	}
}
