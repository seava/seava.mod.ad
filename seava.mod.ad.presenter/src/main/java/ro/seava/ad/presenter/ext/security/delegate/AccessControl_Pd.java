package ro.seava.ad.presenter.ext.security.delegate;

import java.util.ArrayList;
import java.util.List;

import ro.seava.j4e.presenter.service.AbstractPresenterDelegate;
import ro.seava.ad.business.api.security.IAccessControlAsgnService;
import ro.seava.ad.business.api.security.IAccessControlDsService;
import ro.seava.ad.domain.impl.security.AccessControl;
import ro.seava.ad.domain.impl.security.AccessControlAsgn;
import ro.seava.ad.domain.impl.security.AccessControlDs;
import ro.seava.ad.presenter.impl.security.model.AccessControl_Ds;
import ro.seava.ad.presenter.impl.security.model.AccessControl_DsParam;

public class AccessControl_Pd extends AbstractPresenterDelegate {

	/**
	 * 
	 * @param ds
	 * @param params
	 * @throws Exception
	 */
	public void copyRulesFromAccessControl(AccessControl_Ds ds,
			AccessControl_DsParam params) throws Exception {
		if (params.getCopyFromId() == null) {
			throw new Exception(
					"No value provided for source access control ID to copy rules from!");
		}
		if (params.getSkipAsgn() && params.getSkipDs()) {
			return;
		}

		IAccessControlDsService dsACService = (IAccessControlDsService) this
				.findEntityService(AccessControlDs.class);

		AccessControl ac = dsACService.getEntityManager().find(
				AccessControl.class, ds.getId());

		if (!params.getSkipDs()) {

			List<AccessControlDs> sourceDsRulesList = dsACService
					.findByAccessControlId(params.getCopyFromId());
			List<AccessControlDs> targetDsRulesList = new ArrayList<AccessControlDs>();

			for (AccessControlDs s : sourceDsRulesList) {
				AccessControlDs t = new AccessControlDs();
				t.setAccessControl(ac);
				t.setDsName(s.getDsName());
				if (!params.getResetRules()) {
					t.setQueryAllowed(s.getQueryAllowed());
					t.setInsertAllowed(s.getInsertAllowed());
					t.setUpdateAllowed(s.getUpdateAllowed());
					t.setDeleteAllowed(s.getDeleteAllowed());
					t.setImportAllowed(s.getImportAllowed());
					t.setExportAllowed(s.getExportAllowed());
				}
				targetDsRulesList.add(t);
			}
			dsACService.insert(targetDsRulesList);
		}

		if (!params.getSkipAsgn()) {
			IAccessControlAsgnService asgnACService = (IAccessControlAsgnService) this
					.findEntityService(AccessControlAsgn.class);

			List<AccessControlAsgn> sourceAsgnRulesList = asgnACService
					.findByAccessControlId(params.getCopyFromId());
			List<AccessControlAsgn> targetAsgnRulesList = new ArrayList<AccessControlAsgn>();

			for (AccessControlAsgn s : sourceAsgnRulesList) {
				AccessControlAsgn t = new AccessControlAsgn();
				t.setAccessControl(ac);
				t.setAsgnName(s.getAsgnName());
				if (!params.getResetRules()) {
					t.setQueryAllowed(s.getQueryAllowed());
					t.setUpdateAllowed(s.getUpdateAllowed());
					t.setImportAllowed(s.getImportAllowed());
					t.setExportAllowed(s.getExportAllowed());
					targetAsgnRulesList.add(t);
				}
			}
			asgnACService.insert(targetAsgnRulesList);
		}

	}

}
