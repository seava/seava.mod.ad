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

@Ds(entity = DataSource.class, jpqlWhere = " e.isAsgn = true ", sort = {@SortField(field = DataSourceAsgnLov_Ds.f_name)})
public class DataSourceAsgnLov_Ds extends AbstractTypeNTLov_Ds<DataSource> {

	public static final String ALIAS = "ad_DataSourceAsgnLov_Ds";

	public DataSourceAsgnLov_Ds() {
		super();
	}

	public DataSourceAsgnLov_Ds(DataSource e) {
		super(e);
	}
}
