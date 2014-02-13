/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.system;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.business.api.system.IViewStateService;
import seava.ad.domain.impl.system.ViewState;

/**
 * Repository functionality for {@link ViewState} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ViewState_Service extends AbstractEntityService<ViewState>
		implements
			IViewStateService {

	public ViewState_Service() {
		super();
	}

	public ViewState_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ViewState> getEntityClass() {
		return ViewState.class;
	}
}
