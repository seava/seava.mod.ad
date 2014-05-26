/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.security.model;

import seava.ad.domain.impl.security.AccessControl;
import seava.ad.domain.impl.security.AccessControlDsRpc;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.Param;
import seava.j4e.api.annotation.RefLookup;
import seava.j4e.api.annotation.RefLookups;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = AccessControlDsRpc.class, sort = {
		@SortField(field = AccessControlDsRpc_Ds.f_dsName),
		@SortField(field = AccessControlDsRpc_Ds.f_serviceMethod)})
@RefLookups({@RefLookup(refId = AccessControlDsRpc_Ds.f_accessControlId, namedQuery = AccessControl.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = AccessControlDsRpc_Ds.f_accessControl)})})
public class AccessControlDsRpc_Ds
		extends
			AbstractAuditable_Ds<AccessControlDsRpc> {

	public static final String ALIAS = "ad_AccessControlDsRpc_Ds";

	public static final String f_dsName = "dsName";
	public static final String f_serviceMethod = "serviceMethod";
	public static final String f_accessControlId = "accessControlId";
	public static final String f_accessControl = "accessControl";

	@DsField
	private String dsName;

	@DsField
	private String serviceMethod;

	@DsField(join = "left", path = "accessControl.id")
	private String accessControlId;

	@DsField(join = "left", path = "accessControl.name")
	private String accessControl;

	public AccessControlDsRpc_Ds() {
		super();
	}

	public AccessControlDsRpc_Ds(AccessControlDsRpc e) {
		super(e);
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getServiceMethod() {
		return this.serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	public String getAccessControlId() {
		return this.accessControlId;
	}

	public void setAccessControlId(String accessControlId) {
		this.accessControlId = accessControlId;
	}

	public String getAccessControl() {
		return this.accessControl;
	}

	public void setAccessControl(String accessControl) {
		this.accessControl = accessControl;
	}
}
