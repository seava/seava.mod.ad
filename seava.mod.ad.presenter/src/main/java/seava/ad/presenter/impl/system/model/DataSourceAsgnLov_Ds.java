/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.impl.model.AbstractTypeNTLov_Ds;
import seava.ad.domain.impl.system.DataSource;

@Ds(entity = DataSource.class, jpqlWhere = " e.isAsgn = true ", sort = {@SortField(field = DataSourceAsgnLov_Ds.f_name)})
public class DataSourceAsgnLov_Ds extends AbstractTypeNTLov_Ds<DataSource> {

	public DataSourceAsgnLov_Ds() {
		super();
	}

	public DataSourceAsgnLov_Ds(DataSource e) {
		super(e);
	}
}
