package seava.ad.presenter.ext.system.delegate;

import java.util.ArrayList;
import java.util.List;

import seava.j4e.api.Constants;
import seava.j4e.api.descriptor.IDsDefinition;
import seava.j4e.api.descriptor.IDsDefinitions;
import seava.j4e.api.descriptor.IFieldDefinition;
import seava.j4e.api.session.Session;
import seava.j4e.presenter.descriptor.DsDefinition;
import seava.j4e.presenter.service.AbstractPresenterDelegate;
import seava.ad.business.api.system.IDataSourceService;
import seava.ad.domain.impl.system.DataSource;
import seava.ad.domain.impl.system.DataSourceField;
import seava.ad.domain.impl.system.DataSourceRpc;
import seava.ad.presenter.impl.system.model.DataSource_Ds;

public class DataSource_Pd extends AbstractPresenterDelegate {

	/**
	 * Scan spring xml files to discover data-source definition and store them
	 * in database for easier access.
	 * 
	 * @param filter
	 * @throws Exception
	 */

	public void synchronizeCatalog(DataSource_Ds filter) throws Exception {

		if (!Session.user.get().isSystemUser()) {
			throw new Exception(
					"This operation is allowed only for system users.");
		}

		IDataSourceService srv = (IDataSourceService) this
				.findEntityService(DataSource.class);

		List<DataSource> result = new ArrayList<DataSource>();

		if (this.getSettings().get(Constants.PROP_DEPLOYMENT)
				.equals(Constants.PROP_DEPLOYMENT_JEE)) {
			IDsDefinitions defs = this.getApplicationContext().getBean(
					IDsDefinitions.class);
			this._process(defs, result);
		} else {
			@SuppressWarnings("unchecked")
			List<IDsDefinitions> list = (List<IDsDefinitions>) this
					.getApplicationContext().getBean(
							Constants.SPRING_OSGI_DS_DEFINITIONS);
			for (IDsDefinitions defs : list) {
				this._process(defs, result);
			}
		}
		srv.update("delete from " + DataSourceField.class.getSimpleName(), null);
		srv.update("delete from " + DataSourceRpc.class.getSimpleName(), null);
		srv.update("delete from " + DataSource.class.getSimpleName(), null);
		srv.insert(result);
	}

	private void _process(IDsDefinitions defs, List<DataSource> result)
			throws Exception {
		for (IDsDefinition def : defs.getDsDefinitions()) {
			DataSource e = new DataSource();
			e.setName(def.getName());
			e.setModel(def.getModelClass().getCanonicalName());
			e.setActive(true);
			e.setIsAsgn(def.isAsgn());

			for (IFieldDefinition fld : ((DsDefinition) def).getModelFields()) {
				DataSourceField f = new DataSourceField();
				f.setName(fld.getName());
				f.setActive(true);
				f.setDataType(fld.getClassName());
				e.addToFields(f);
			}

			List<String> serviceMethods = def.getServiceMethods();
			if (serviceMethods != null) {
				for (String sm : serviceMethods) {
					DataSourceRpc sme = new DataSourceRpc();
					sme.setActive(true);
					sme.setDataSource(e);
					sme.setName(sm);
					e.addToServiceMethods(sme);
				}
			}
			result.add(e);
		}
	}
}