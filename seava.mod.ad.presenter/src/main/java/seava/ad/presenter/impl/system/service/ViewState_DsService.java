/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.service;

import seava.ad.domain.impl.system.ViewState;
import seava.ad.presenter.impl.system.model.ViewState_Ds;
import seava.j4e.api.service.presenter.IDsService;
import seava.j4e.presenter.service.ds.AbstractEntityDsService;

public class ViewState_DsService
		extends
			AbstractEntityDsService<ViewState_Ds, ViewState_Ds, Object, ViewState>
		implements
			IDsService<ViewState_Ds, ViewState_Ds, Object> {

	@Override
	public void preInsert(ViewState_Ds ds, Object params) {
		ds.setActive(true);
	}

	@Override
	public void preUpdate(ViewState_Ds ds, Object params) {
		ds.setActive(true);
	}
}
