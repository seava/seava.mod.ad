package ro.seava.ad.presenter.ext.security.delegate;

import ro.seava.j4e.presenter.service.AbstractPresenterDelegate;
import ro.seava.ad.business.api.security.IUserService;
import ro.seava.ad.domain.impl.security.User;
import ro.seava.ad.presenter.impl.security.model.User_Ds;
import ro.seava.ad.presenter.impl.security.model.User_DsParam;

public class User_Pd extends AbstractPresenterDelegate {

	public void changePassword(User_Ds ds, User_DsParam params)
			throws Exception {

		String newPassword = params.getNewPassword();
		String confPassword = params.getConfirmPassword();

		if (newPassword == null || newPassword.equals("")) {
			throw new Exception("Password must not be empty!");
		}

		if (!newPassword.equals(confPassword)) {
			throw new Exception("New password is not confirmed correctly !");
		}

		((IUserService) this.findEntityService(User.class)).doChangePassword(
				ds.getId(), newPassword);
	}

}
