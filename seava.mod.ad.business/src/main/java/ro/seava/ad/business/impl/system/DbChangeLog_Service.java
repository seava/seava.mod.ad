/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.business.impl.system;

import javax.persistence.EntityManager;
import ro.seava.ad.business.api.system.IDbChangeLogService;
import ro.seava.ad.domain.impl.system.DbChangeLog;
import ro.seava.j4e.business.service.entity.AbstractEntityService;

/**
 * Repository functionality for {@link DbChangeLog} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DbChangeLog_Service extends AbstractEntityService<DbChangeLog>
		implements
			IDbChangeLogService {

	public DbChangeLog_Service() {
		super();
	}

	public DbChangeLog_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DbChangeLog> getEntityClass() {
		return DbChangeLog.class;
	}
}
