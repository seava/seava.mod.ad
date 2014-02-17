package seava.ad.presenter.ext.system.delegate;

import java.util.ArrayList;
import java.util.List;

import seava.j4e.api.Constants;
import seava.j4e.api.descriptor.IJobDefinition;
import seava.j4e.api.descriptor.IJobDefinitions;
import seava.j4e.api.session.Session;
import seava.j4e.presenter.descriptor.FieldDefinition;
import seava.j4e.presenter.descriptor.JobDefinition;
import seava.j4e.presenter.service.AbstractPresenterDelegate;
import seava.ad.business.api.system.IJobService;
import seava.ad.domain.impl.system.Job;
import seava.ad.domain.impl.system.JobParam;
import seava.ad.presenter.impl.system.model.Job_Ds;

public class Job_Pd extends AbstractPresenterDelegate {

	/**
	 * Scan spring xml files to discover job definition and store them in
	 * database for easier access.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void synchronizeCatalog(Job_Ds ds) throws Exception {

		if (!Session.user.get().isSystemUser()) {
			throw new Exception(
					"This operation is allowed only for system users.");
		}

		IJobService srv = (IJobService) this.findEntityService(Job.class);
		List<Job> result = new ArrayList<Job>();

		if (this.getSettings().get(Constants.PROP_DEPLOYMENT)
				.equals(Constants.PROP_DEPLOYMENT_JEE)) {
			IJobDefinitions defs = this.getApplicationContext().getBean(
					IJobDefinitions.class);
			this._process(defs, result);
		} else {
			@SuppressWarnings("unchecked")
			List<IJobDefinitions> list = (List<IJobDefinitions>) this
					.getApplicationContext().getBean(
							Constants.SPRING_OSGI_JOB_DEFINITIONS);
			for (IJobDefinitions defs : list) {
				this._process(defs, result);
			}
		}

		srv.update("delete from " + Job.class.getSimpleName(), null);
		srv.insert(result);
	}

	private void _process(IJobDefinitions defs, List<Job> result)
			throws Exception {
		for (IJobDefinition def : defs.getJobDefinitions()) {
			Job e = new Job();
			e.setName(def.getName());
			e.setJavaClass(def.getJavaClass().getCanonicalName());
			e.setActive(true);

			for (FieldDefinition fld : ((JobDefinition) def).getJobParams()) {
				JobParam p = new JobParam();
				p.setName(fld.getName());
				p.setActive(true);
				p.setDataType(fld.getClassName());
				e.addToParams(p);
			}
			result.add(e);
		}
	}
}
