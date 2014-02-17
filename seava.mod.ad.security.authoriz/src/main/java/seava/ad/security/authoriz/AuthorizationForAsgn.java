/** 
 * DNet eBusiness Suite
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.security.authoriz;

import java.util.List;

import javax.persistence.TypedQuery;

import seava.j4e.api.exceptions.NotAuthorizedRequestException;
import seava.j4e.api.security.IAuthorization;
import seava.j4e.api.session.IUser;
import seava.j4e.api.session.Session;
import seava.ad.domain.impl.security.AccessControl;
import seava.ad.domain.impl.security.AccessControlAsgn;

public class AuthorizationForAsgn extends AbstractSecurity implements
		IAuthorization {

	public void authorize(String dsName, String action, String rpcName)
			throws Exception {
		IUser user = Session.user.get();

		if (user.isSystemUser() || user.getProfile().isAdministrator()) {
			return;
		}

		String filter = this.actionFilter(dsName, action);
		String eql = "select 1 from " + AccessControlAsgn.class.getSimpleName()
				+ " e where e.clientId = :clientId "
				+ " and e.asgnName = :asgnName " + filter
				+ " and e.accessControl.id in ( select p.id from "
				+ AccessControl.class.getSimpleName()
				+ " p, IN (p.roles) c where c.code in :roles ) ";

		TypedQuery<Integer> query = this.getEntityManager()
				.createQuery(eql, Integer.class)
				.setParameter("asgnName", dsName)
				.setParameter("clientId", Session.user.get().getClientId())
				.setParameter("roles", user.getProfile().getRoles());

		List<Integer> result = query.getResultList();

		if (result.size() < 1) {
			throw new NotAuthorizedRequestException(
					"You are not authorized to execute `" + action
							+ "`. <BR> Not enough privileges on resource `"
							+ dsName + "`");
		}
	}

	private String actionFilter(String dsName, String action) {
		if (action.equals("find")) {
			return " and e.queryAllowed = true ";
		} else {
			return " and e.updateAllowed = true ";
		}
	}
}
