/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.Client;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeWithCodeNTLov;

@Ds(entity = Client.class, sort = {@SortField(field = ClientLov_Ds.f_code)})
public class ClientLov_Ds extends AbstractTypeWithCodeNTLov<Client> {

	public ClientLov_Ds() {
		super();
	}

	public ClientLov_Ds(Client e) {
		super(e);
	}
}
