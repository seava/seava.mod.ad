package seava.ad.security.authoriz;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ro.seava.j4e.api.ISettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class AbstractSecurity implements ApplicationContextAware {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	private ApplicationContext applicationContext;
	private ISettings settings;

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public ISettings getSettings() {
		if (this.settings == null) {
			this.settings = this.applicationContext.getBean(ISettings.class);
		}
		return settings;
	}

	public void setSettings(ISettings settings) {
		this.settings = settings;
	}
}
