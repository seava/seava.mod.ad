/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.Param;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeWithCodeNTLov;

@Ds(entity = Param.class, sort = {@SortField(field = ParamLov_Ds.f_code)})
public class ParamLov_Ds extends AbstractTypeWithCodeNTLov<Param> {

	public ParamLov_Ds() {
		super();
	}

	public ParamLov_Ds(Param e) {
		super(e);
	}
}
