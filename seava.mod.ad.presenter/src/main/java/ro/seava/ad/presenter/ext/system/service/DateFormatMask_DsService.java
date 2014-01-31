/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.ext.system.service;

import ro.seava.j4e.api.service.presenter.IDsService;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.presenter.service.ds.AbstractEntityDsService;
import ro.seava.ad.domain.impl.system.DateFormatMask;
import ro.seava.ad.presenter.impl.system.model.DateFormatMask_Ds;

public class DateFormatMask_DsService
		extends
		AbstractEntityDsService<DateFormatMask_Ds, DateFormatMask_Ds, Object, DateFormatMask>
		implements IDsService<DateFormatMask_Ds, DateFormatMask_Ds, Object> {

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
