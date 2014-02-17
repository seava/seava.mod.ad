/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.Client;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeWithCodeNT_Ds;

@Ds(entity = Client.class, sort = {@SortField(field = MyClient_Ds.f_code)})
public class MyClient_Ds extends AbstractTypeWithCodeNT_Ds<Client> {
	public static final String f_workspacePath = "workspacePath";
	public static final String f_importPath = "importPath";
	public static final String f_exportPath = "exportPath";
	public static final String f_tempPath = "tempPath";
	public static final String f_adminRole = "adminRole";

	@DsField
	private String workspacePath;

	@DsField
	private String importPath;

	@DsField
	private String exportPath;

	@DsField
	private String tempPath;

	@DsField
	private String adminRole;

	public MyClient_Ds() {
		super();
	}

	public MyClient_Ds(Client e) {
		super(e);
	}

	public String getWorkspacePath() {
		return this.workspacePath;
	}

	public void setWorkspacePath(String workspacePath) {
		this.workspacePath = workspacePath;
	}

	public String getImportPath() {
		return this.importPath;
	}

	public void setImportPath(String importPath) {
		this.importPath = importPath;
	}

	public String getExportPath() {
		return this.exportPath;
	}

	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}

	public String getTempPath() {
		return this.tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getAdminRole() {
		return this.adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
}
