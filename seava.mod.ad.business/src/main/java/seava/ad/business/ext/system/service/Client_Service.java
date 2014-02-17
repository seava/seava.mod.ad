/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package seava.ad.business.ext.system.service;

import java.io.File;

import org.springframework.transaction.annotation.Transactional;

import seava.j4e.api.action.impex.IImportDataPackage;
import seava.j4e.api.exceptions.BusinessException;
import seava.ad.business.api.system.IClientService;
import seava.ad.business.ext.system.delegate.Client_Bd;
import seava.ad.domain.impl.system.Client;

/**
 * Business extensions specific for {@link Client} domain entity.
 * 
 */
public class Client_Service extends
		seava.ad.business.impl.system.Client_Service implements
		IClientService {

	@Override
	@Transactional
	public void doInsertWithUserAccount(Client client, String userCode,
			String userName, String loginName, String password)
			throws BusinessException {
		this.preSave(client);
		Client_Bd delegate = this.getBusinessDelegate(Client_Bd.class);
		delegate.createClientWithAdminUser(client, userCode, userName,
				loginName, password);
	}

	@Override
	@Transactional
	public void doInsertWithUserAccountAndSetup(Client client, String userCode,
			String userName, String loginName, String password,
			IImportDataPackage dataPackage) throws BusinessException {
		this.preSave(client);
		Client_Bd delegate = this.getBusinessDelegate(Client_Bd.class);
		delegate.createClientWithAdminUserAndSetup(client, userCode, userName,
				loginName, password, dataPackage);

	}

	@Override
	protected void preInsert(Client e) throws BusinessException {
		this.preSave(e);
	}

	@Override
	protected void preUpdate(Client e) throws BusinessException {
		this.preSave(e);
	}

	protected void preSave(Client e) throws BusinessException {

		this.validatePath(e.getWorkspacePath(), "Workspace");
		this.validatePath(e.getImportPath(), "Import");
		this.validatePath(e.getExportPath(), "Export");
		this.validatePath(e.getTempPath(), "Temporary");
	}

	protected void validatePath(String path, String name)
			throws BusinessException {
		if (path == null) {
			throw new BusinessException(name + " path cannot be empty.");
		}
		File f = new File(path);
		if (!f.isAbsolute()) {
			throw new BusinessException(name + " path `" + path
					+ "` must be an absolute path.");
		}

		if (!f.exists()) {
			if (!f.mkdirs()) {
				throw new BusinessException(name + " path `" + path
						+ "` structure cannot be created.");
			}
		} else {
			if (!f.canRead()) {
				throw new BusinessException(name + " path `" + path
						+ "` is not read enabled.");
			}
			if (!f.canWrite()) {
				throw new BusinessException(name + " path `" + path
						+ "` is not write enabled.");
			}
		}
	}

}
