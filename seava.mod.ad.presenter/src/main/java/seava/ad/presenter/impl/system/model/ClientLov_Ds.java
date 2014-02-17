/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.Client;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCodeNTLov_Ds;

@Ds(entity = Client.class, sort = {@SortField(field = ClientLov_Ds.f_code)})
public class ClientLov_Ds extends AbstractTypeWithCodeNTLov_Ds<Client> {

	public ClientLov_Ds() {
		super();
	}

	public ClientLov_Ds(Client e) {
		super(e);
	}
}
