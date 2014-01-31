/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.DataSource;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeNTLov;

@Ds(entity = DataSource.class, jpqlWhere = " e.isAsgn = true ", sort = {@SortField(field = DataSourceAsgnLov_Ds.f_name)})
public class DataSourceAsgnLov_Ds extends AbstractTypeNTLov<DataSource> {

	public DataSourceAsgnLov_Ds() {
		super();
	}

	public DataSourceAsgnLov_Ds(DataSource e) {
		super(e);
	}
}
