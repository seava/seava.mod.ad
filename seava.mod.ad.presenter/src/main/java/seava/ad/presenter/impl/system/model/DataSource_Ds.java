/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.DataSource;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeNT_Ds;

@Ds(entity = DataSource.class, sort = {@SortField(field = DataSource_Ds.f_name)})
public class DataSource_Ds extends AbstractTypeNT_Ds<DataSource> {
	public static final String f_model = "model";
	public static final String f_isAsgn = "isAsgn";

	@DsField
	private String model;

	@DsField
	private Boolean isAsgn;

	public DataSource_Ds() {
		super();
	}

	public DataSource_Ds(DataSource e) {
		super(e);
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsAsgn() {
		return this.isAsgn;
	}

	public void setIsAsgn(Boolean isAsgn) {
		this.isAsgn = isAsgn;
	}
}
