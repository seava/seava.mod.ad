/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.business.api.system;

import ro.seava.j4e.api.action.impex.IImportDataPackage;
import ro.seava.j4e.api.exceptions.BusinessException;
import ro.seava.j4e.api.service.business.IEntityService;
import seava.ad.domain.impl.system.Client;

/**
 * Interface to expose business functions specific for {@link Client} domain
 * entity.
 */
public interface IClientService extends IEntityService<Client> {

	public void doInsertWithUserAccount(Client client, String userCode,
			String userName, String loginName, String password)
			throws BusinessException;

	public void doInsertWithUserAccountAndSetup(Client client, String userCode,
			String userName, String loginName, String password,
			IImportDataPackage dataPackage) throws BusinessException;
}
