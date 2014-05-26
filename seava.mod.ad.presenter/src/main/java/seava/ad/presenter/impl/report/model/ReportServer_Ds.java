/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.report.model;

import seava.ad.domain.impl.report.ReportServer;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractType_Ds;

@Ds(entity = ReportServer.class, sort = {@SortField(field = ReportServer_Ds.f_name)})
public class ReportServer_Ds extends AbstractType_Ds<ReportServer> {

	public static final String ALIAS = "ad_ReportServer_Ds";

	public static final String f_url = "url";
	public static final String f_queryBuilderClass = "queryBuilderClass";

	@DsField
	private String url;

	@DsField
	private String queryBuilderClass;

	public ReportServer_Ds() {
		super();
	}

	public ReportServer_Ds(ReportServer e) {
		super(e);
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQueryBuilderClass() {
		return this.queryBuilderClass;
	}

	public void setQueryBuilderClass(String queryBuilderClass) {
		this.queryBuilderClass = queryBuilderClass;
	}
}
