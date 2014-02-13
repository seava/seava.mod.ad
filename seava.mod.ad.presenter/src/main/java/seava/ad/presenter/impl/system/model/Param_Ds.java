/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.impl.model.AbstractTypeWithCodeNT_Ds;
import seava.ad.domain.impl.system.Param;

@Ds(entity = Param.class, sort = {@SortField(field = Param_Ds.f_code)})
public class Param_Ds extends AbstractTypeWithCodeNT_Ds<Param> {
	public static final String f_defaultValue = "defaultValue";
	public static final String f_listOfValues = "listOfValues";

	@DsField
	private String defaultValue;

	@DsField
	private String listOfValues;

	public Param_Ds() {
		super();
	}

	public Param_Ds(Param e) {
		super(e);
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getListOfValues() {
		return this.listOfValues;
	}

	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}
}
