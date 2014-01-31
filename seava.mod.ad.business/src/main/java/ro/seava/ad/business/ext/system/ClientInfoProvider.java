package ro.seava.ad.business.ext.system;

import ro.seava.j4e.commons.security.AppWorkspace;
import ro.seava.j4e.api.session.IWorkspace;
import ro.seava.j4e.api.service.IClientInfoProvider;
import ro.seava.j4e.api.session.Session;
import ro.seava.j4e.business.service.AbstractBusinessBaseService;
import ro.seava.ad.domain.impl.system.Client;

public class ClientInfoProvider extends AbstractBusinessBaseService implements
		IClientInfoProvider {

	@Override
	public IWorkspace getClientWorkspace() {
		Client c = this.getEntityManager().find(Client.class,
				Session.user.get().getClientId());

		return new AppWorkspace(c.getWorkspacePath(), c.getImportPath(),
				c.getExportPath(), c.getTempPath());

	}

}
