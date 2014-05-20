package seava.ad.security.authentic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import seava.j4e.api.Constants;
import seava.j4e.api.exceptions.InvalidConfiguration;
import seava.j4e.commons.security.AppClient;
import seava.j4e.commons.security.SessionUser;
import seava.j4e.commons.security.AppUser;
import seava.j4e.commons.security.AppUserProfile;
import seava.j4e.commons.security.AppUserSettings;
import seava.j4e.commons.security.AppWorkspace;
import seava.j4e.api.security.IAuthenticationClientUserService;
import seava.j4e.api.security.ILoginParams;
import seava.j4e.api.session.ISessionUser;
import seava.j4e.api.session.IUser;
import seava.j4e.api.session.IUserProfile;
import seava.j4e.api.session.IWorkspace;
import seava.j4e.api.security.LoginParamsHolder;
import seava.ad.domain.impl.security.Role;
import seava.ad.domain.impl.security.User;
import seava.ad.domain.impl.system.Client;
import seava.ad.domain.impl.system.DateFormatMask;

/**
 * 
 * Authenticates login credentials against users defined in DNet-AD module.
 * 
 * @author amathe
 * 
 */
public class AuthenticationClientUserService extends AbstractSecurity implements
		IAuthenticationClientUserService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		EntityManager em = this.getEntityManager();

		ILoginParams lp = LoginParamsHolder.params.get();
		Client c = null;
		User u = null;
		try {
			c = em.createQuery(
					"select e from " + Client.class.getSimpleName()
							+ " e where e.code = :code", Client.class)
					.setParameter("code", lp.getClientCode()).getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("Invalid credentials");
		}

		if (!c.getActive()) {
			throw new UsernameNotFoundException("Inactive client");
		}

		try {
			u = em.createQuery(
					"select e from "
							+ User.class.getSimpleName()
							+ " e where e.loginName = :loginName and e.clientId = :clientId",
					User.class).setParameter("loginName", username)
					.setParameter("clientId", c.getId()).getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("Invalid credentials");
		}

		if (!u.getActive()) {
			throw new UsernameNotFoundException("Inactive user");
		}
		
		if (u.getRoles().size() == 0) {
			throw new UsernameNotFoundException(
					"User is not allowed to connect to application.");
		}

		ISessionUser su;
		try {
			su = buildSessionUser(c, u, lp);
		} catch (InvalidConfiguration e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
		return su;
	}

	public ISessionUser buildSessionUser(Client c, User u, ILoginParams lp)
			throws InvalidConfiguration {

		boolean isAdmin = false;
		List<String> roles = new ArrayList<String>();

		for (Role role : u.getRoles()) {
			roles.add(role.getCode());

			if (role.getCode().equals(Constants.ROLE_USER_CODE)) {
				// Add the prefix required by Spring Security
				roles.add("ROLE_" + role.getCode());
			}

			if (role.getCode().equals(c.getAdminRole())) {
				isAdmin = true;
			}
		}

		AppClient client = new AppClient(c.getId(), c.getCode(), c.getName());
		IWorkspace ws = new AppWorkspace(c.getWorkspacePath(),
				c.getImportPath(), c.getExportPath(), c.getTempPath());

		AppUserSettings settings = AppUserSettings.newInstance(this
				.getSettings());

		if (u.getThousandSeparator() != null
				&& !"".equals(u.getThousandSeparator())
				&& u.getDecimalSeparator() != null
				&& !"".equals(u.getDecimalSeparator())) {
			String numberFormat = "0" + u.getThousandSeparator() + "000"
					+ u.getDecimalSeparator() + "00";
			settings.setNumberFormat(numberFormat);
		}

		if (u.getDateFormat() != null) {
			for (DateFormatMask mask : u.getDateFormat().getMasks()) {
				settings.setDateFormatMask(mask.getMask(), mask.getValue());
			}
		}

		IUserProfile profile = new AppUserProfile(isAdmin, roles, false, false,
				u.getLocked());
		IUser user = new AppUser(u.getCode(), u.getName(), u.getLoginName(),
				u.getPassword(), null, null, client, settings, profile, ws,
				false);
		ISessionUser su = new SessionUser(user, lp.getUserAgent(), new Date(),
				lp.getRemoteHost(), lp.getRemoteIp());
		return su;
	}
}
