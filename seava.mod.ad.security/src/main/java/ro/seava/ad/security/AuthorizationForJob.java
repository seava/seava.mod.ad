/** 
 * DNet eBusiness Suite
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.security;

import ro.seava.j4e.api.security.IAuthorization;

public class AuthorizationForJob extends AbstractSecurity implements
		IAuthorization {

	@Override
	public void authorize(String resourceName, String action, String rpcName)
			throws Exception {
		// If it doesn't throw exception is authorized
	}

}
