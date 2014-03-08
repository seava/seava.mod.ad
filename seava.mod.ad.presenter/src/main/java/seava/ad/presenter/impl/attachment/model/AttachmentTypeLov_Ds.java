/**
 * Solutii Ecommerce, Automatizare, Validare si Analiza | Seava.ro
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package seava.ad.presenter.impl.attachment.model;

import seava.ad.domain.impl.attachment.AttachmentType;
import seava.j4e.api.annotation.Ds;
import seava.j4e.api.annotation.DsField;
import seava.j4e.api.annotation.SortField;
import seava.j4e.presenter.impl.model.AbstractTypeLov_Ds;

@Ds(entity = AttachmentType.class, sort = {@SortField(field = AttachmentTypeLov_Ds.f_name)})
public class AttachmentTypeLov_Ds extends AbstractTypeLov_Ds<AttachmentType> {
	public static final String f_category = "category";
	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";

	@DsField
	private String category;

	@DsField(fetch = false, jpqlFilter = "  e.refid in (select t.sourceRefId from TargetRule t where  t.targetAlias = :targetAlias and  t.targetType = :targetType and t.clientId = :clientId ) ")
	private String targetAlias;

	@DsField(fetch = false)
	private String targetType;

	public AttachmentTypeLov_Ds() {
		super();
	}

	public AttachmentTypeLov_Ds(AttachmentType e) {
		super(e);
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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
