package ro.seava.ad.security.authentic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ro.seava.j4e.api.exceptions.InvalidConfiguration;
import ro.seava.j4e.commons.security.AppClient;
import ro.seava.j4e.commons.security.SessionUser;
import ro.seava.j4e.commons.security.AppUser;
import ro.seava.j4e.commons.security.AppUserProfile;
import ro.seava.j4e.commons.security.AppUserSettings;
import ro.seava.j4e.commons.security.AppWorkspace;
import ro.seava.j4e.api.security.IAuthenticationClientUserService;
import ro.seava.j4e.api.security.ILoginParams;
import ro.seava.j4e.api.session.ISessionUser;
import ro.seava.j4e.api.session.IUser;
import ro.seava.j4e.api.session.IUserProfile;
import ro.seava.j4e.api.session.IWorkspace;
import ro.seava.j4e.api.security.LoginParamsHolder;
import ro.seava.ad.domain.impl.security.Role;
import ro.seava.ad.domain.impl.security.User;
import ro.seava.ad.domain.impl.system.Client;
import ro.seava.ad.domain.impl.system.DateFormatMask;

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
			// Add the prefix required by Spring Security
			roles.add("ROLE_" + role.getCode());
			if (role.getCode().equals(c.getAdminRole())) {
				isAdmin = true;
			}
		}

		AppClient client = new AppClient(c.getId(), c.getCode(), c.getName());
		IWorkspace ws = new AppWorkspace(c.getWorkspacePath(),
				c.getImportPath(), c.getExportPath(), c.getTempPath());

		AppUserSettings settings = AppUserSettings.newInstance(this
				.getSettings());

		if (u.getThousandSeparator() != null && u.getDateFormat() != null) {
			String numberFormat = "0" + u.getThousandSeparator() + "000"
					+ u.getDecimalSeparator() + "00";
			settings.setNumberFormat(numberFormat);
		}

		if (u.getDateFormat() != null) {
			for (DateFormatMask mask : u.getDateFormat().getMasks()) {
				settings.setDateFormat(mask.getMask(), mask.getValue());
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
