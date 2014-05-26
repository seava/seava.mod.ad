/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.system.model;

import seava.ad.domain.impl.system.TargetRule;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.presenter.impl.model.AbstractAuditable_Ds;

@Ds(entity = TargetRule.class)
public class TargetRule_Ds extends AbstractAuditable_Ds<TargetRule> {

	public static final String ALIAS = "ad_TargetRule_Ds";

	public static final String f_sourceRefId = "sourceRefId";
	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";

	@DsField
	private String sourceRefId;

	@DsField
	private String targetAlias;

	@DsField
	private String targetType;

	public TargetRule_Ds() {
		super();
	}

	public TargetRule_Ds(TargetRule e) {
		super(e);
	}

	public String getSourceRefId() {
		return this.sourceRefId;
	}

	public void setSourceRefId(String sourceRefId) {
		this.sourceRefId = sourceRefId;
	}

	public String getTargetAlias() {
		return this.targetAlias;
	}

	public void setTargetAlias(String targetAlias) {
		this.targetAlias = targetAlias;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
}
