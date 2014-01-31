/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package ro.seava.ad.presenter.impl.system.model;

import ro.seava.ad.domain.impl.system.Job;
import ro.seava.j4e.api.annotation.Ds;
import ro.seava.j4e.api.annotation.DsField;
import ro.seava.j4e.api.annotation.SortField;
import ro.seava.j4e.presenter.model.AbstractTypeNTDs;

@Ds(entity = Job.class, sort = {@SortField(field = Job_Ds.f_name)})
public class Job_Ds extends AbstractTypeNTDs<Job> {
	public static final String f_javaClass = "javaClass";

	@DsField
	private String javaClass;

	public Job_Ds() {
		super();
	}

	public Job_Ds(Job e) {
		super(e);
	}

	public String getJavaClass() {
		return this.javaClass;
	}

	public void setJavaClass(String javaClass) {
		this.javaClass = javaClass;
	}
}
