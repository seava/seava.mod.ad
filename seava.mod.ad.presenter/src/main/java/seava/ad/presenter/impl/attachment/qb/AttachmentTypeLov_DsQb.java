/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.attachment.qb;

import seava.ad.presenter.impl.attachment.model.AttachmentTypeLov_Ds;
import seava.j4e.presenter.action.query.QueryBuilderWithJpql;
import seava.j4e.api.session.Session;

public class AttachmentTypeLov_DsQb
		extends
			QueryBuilderWithJpql<AttachmentTypeLov_Ds, AttachmentTypeLov_Ds, Object> {

	@Override
	public void setFilter(AttachmentTypeLov_Ds filter) {
		if (filter.getTargetType() == null || filter.getTargetType().equals("")) {
			filter.setTargetType("N/A");
		}
		super.setFilter(filter);
	}
}
