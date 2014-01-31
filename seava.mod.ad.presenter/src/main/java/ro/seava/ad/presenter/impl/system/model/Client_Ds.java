/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.Client;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeWithCodeNTDs;

@Ds(entity = Client.class, sort = {@SortField(field = Client_Ds.f_code)})
public class Client_Ds extends AbstractTypeWithCodeNTDs<Client> {
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

	public Client_Ds() {
		super();
	}

	public Client_Ds(Client e) {
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
