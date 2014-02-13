/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.impl.system;

import javax.persistence.EntityManager;
import ro.seava.j4e.business.service.entity.AbstractEntityService;
import seava.ad.domain.impl.system.Client;

/**
 * Repository functionality for {@link Client} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Client_Service extends AbstractEntityService<Client> {

	public Client_Service() {
		super();
	}

	public Client_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Client> getEntityClass() {
		return Client.class;
	}
}
