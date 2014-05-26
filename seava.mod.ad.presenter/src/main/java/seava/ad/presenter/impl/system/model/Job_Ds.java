/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.Job;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeNT_Ds;

@Ds(entity = Job.class, sort = {@SortField(field = Job_Ds.f_name)})
public class Job_Ds extends AbstractTypeNT_Ds<Job> {

	public static final String ALIAS = "ad_Job_Ds";

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
