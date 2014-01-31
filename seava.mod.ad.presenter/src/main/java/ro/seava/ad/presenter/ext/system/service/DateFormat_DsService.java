/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.ext.system.service;

import ro.seava.j4e.api.service.presenter.IDsService;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.presenter.service.ds.AbstractEntityDsService;
import ro.seava.ad.domain.impl.system.DateFormat;
import ro.seava.ad.presenter.impl.system.model.DateFormat_Ds;

public class DateFormat_DsService
		extends
		AbstractEntityDsService<DateFormat_Ds, DateFormat_Ds, Object, DateFormat>
		implements IDsService<DateFormat_Ds, DateFormat_Ds, Object> {

	@Override
	protected boolean canInsert() {
		return this.canChange();
	}

	@Override
	protected boolean canUpdate() {
		return this.canChange();
	}

	@Override
	protected boolean canDelete() {
		return this.canChange();
	}

	private boolean canChange() {
		return Session.user.get().isSystemUser();
	}

}
