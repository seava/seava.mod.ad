package ro.seava.ad.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ro.seava.j4e.api.security.IAuthorization;
import ro.seava.j4e.api.security.IAuthorizationFactory;

public class AuthorizationFactory implements IAuthorizationFactory,
		ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public IAuthorization getAsgnAuthorizationProvider() {
		return (IAuthorization) this.applicationContext
				.getBean(AuthorizationForAsgn.class);
	}

	@Override
	public IAuthorization getDsAuthorizationProvider() {
		return (IAuthorization) this.applicationContext
				.getBean(AuthorizationForDs.class);
	}

	@Override
	public IAuthorization getJobAuthorizationProvider() {
		return (IAuthorization) this.applicationContext
				.getBean(AuthorizationForJob.class);
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
