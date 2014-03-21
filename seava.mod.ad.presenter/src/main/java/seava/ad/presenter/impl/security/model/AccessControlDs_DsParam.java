/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

public class AccessControlDs_DsParam {

	public static final String f_withRoleId = "withRoleId";
	public static final String f_withRole = "withRole";

	private String withRoleId;

	private String withRole;

	public String getWithRoleId() {
		return this.withRoleId;
	}

	public void setWithRoleId(String withRoleId) {
		this.withRoleId = withRoleId;
	}

	public String getWithRole() {
		return this.withRole;
	}

	public void setWithRole(String withRole) {
		this.withRole = withRole;
	}
}
